package by.it.lapushkin.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

import static by.it.lapushkin.jd02_02.Helper.logicCustomers;
import static by.it.lapushkin.jd02_02.Helper.timeout;

public class Manager {
    private static final int MAX_CASHIER = 5;
    private static final int END_DAY = 120;
    private static final int TIMEOUT = 1000;
    private static final AtomicBoolean limitCashiers = new AtomicBoolean(false);
    private static final ExecutorService cashierPool = Executors.newFixedThreadPool(MAX_CASHIER);
    private static final Semaphore semaphore = new Semaphore(20);
    private static int currentTime = 0;

    public static void semaphoreAcquire() throws InterruptedException {
        semaphore.acquire();
    }

    public static void semaphoreRelease() {
        semaphore.release();
    }


    public static void main(String[] args) {
        workDay();
    }

    public static void workDay() {

        initBasket();
        startDay();
        //logger();
        startCashierManager();
        startScoreManager();
        startReportManager();


        for (int time = 0; time <= END_DAY; time++) {
            setCurrentTime(time);
            Score.jobScore(logicCustomers(time));
            timeout(TIMEOUT);
        }

        Score.closeDoor();

        //ожидаем пока кассы обслужат последних клиентов и закроются
        while (!Monitoring.emptyScore() && !Monitoring.cashierIsEmpty()) {
            //overtime
            currentTime++;
            timeout(TIMEOUT);
            //ожидаха
        }
        cashierPool.shutdown();
        endDay();
    }

    private static void logger() {
        new Thread(() -> {
            while (1==1) {
                System.out.println();
                System.out.println("OPEN CASHIERS = " + Monitoring.getCountOpenCashier());
                System.out.println("CUSTOMERS IN MARKET = " + Monitoring.getCountCustomersInScore());
                System.out.println("QUEUE CHECK = " + Reporter.getSizeDeque());
                System.out.println("QUEUE CUSTOMERS = " + QueueCustomers.getLengthAllQueue());
                System.out.println("QUEUE BASKET = " + QueueBasket.getDequeBasket().size());
                System.out.println();
                //System.out.println("QUEUE BASKET = "+QueueBasket.getDequeBasket().size());

                timeout(TIMEOUT * 2);
            }
        }).start();
    }

    private static void startReportManager() {
        new Thread(() -> {
            while (Score.isScore()) {
                if ((Reporter.getSizeDeque() == Monitoring.getCountOpenCashier()) && Reporter.getSizeDeque() != 0) {
                    Reporter.report();
                }
            }
        }).start();
    }

    private static void initBasket() {
        for (int i = 0; i < 50; i++) {
            QueueBasket.getDequeBasket().addLast(new Basket());
        }
    }

    private static void startScoreManager() {
        Thread customerManager = new Thread(() -> {
            while (Score.isScore()) {
                if (Monitoring.isFullScore()) {
                    if (Score.isDoor()) {
                        Score.closeDoor();
                    }
                } else {
                    if (!Score.isDoor() && currentTime < END_DAY) {
                        Score.openDoor();
                    }
                }
            }
            timeout(TIMEOUT);
        });
        customerManager.start();
    }

    private static void startCashierManager() {
        Thread helperManager = new Thread(() -> {
            while (Score.isScore()) {
                int expectedCashier = (QueueCustomers.getLengthAllQueue() / MAX_CASHIER) + 1;
                int cashiersOpen = Monitoring.getCountOpenCashier();
                if (expectedCashier > cashiersOpen && expectedCashier < MAX_CASHIER) {
                    openCashier(cashiersOpen);
                }

                if (expectedCashier > cashiersOpen) {
                    setLimitCashiersFalse();
                }

                if (expectedCashier < cashiersOpen && cashiersOpen != 1) {
                    setLimitCashiersTrue();
                }



            }
        });
        helperManager.start();
    }

    public static boolean isLimitCashiers() {
        return limitCashiers.get();
    }

    public static void setLimitCashiersTrue() {
        limitCashiers.compareAndSet(false, true);
    }

    public static void setLimitCashiersFalse() {
        limitCashiers.compareAndSet(true, false);
    }

    private static void openCashier(int num) {
        Cashier cashier = new Cashier(num);
        if (!cashierPool.isShutdown()) {
            cashierPool.submit(cashier);
        }
    }

    private static void startDay() {
        Score.openScore();
        Score.openDoor();
    }

    private static void endDay() {
        Score.closeScore();
    }

    public static int getCurrentTime() {
        return currentTime;
    }

    private static void setCurrentTime(int currentTime) {
        Manager.currentTime = currentTime;
    }
}
