package by.it.lapushkin.jd02_02;

import static by.it.lapushkin.jd02_02.Helper.logicCustomers;
import static by.it.lapushkin.jd02_02.Helper.timeout;

public class Manager {
    private static final int MAX_CASHIER = 5;
    private static final int END_DAY = 120;
    private static final int TIMEOUT = 1000;
    private static int currentTime = 0;
    private static boolean limitCashiers;

    public static void main(String[] args) {
        workDay();
    }

    public static void workDay() {
        startDay();
        startCashierManager();
        startScoreManager();

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
        endDay();
    }

    private static void startScoreManager() {
        Thread customerManager = new Thread(() -> {
            while (Score.isScore()) {
                if (Monitoring.fullScore()) {
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
                if (Monitoring.getCountOpenCashier() < MAX_CASHIER) {
                    if (expectedCashier > Monitoring.getCountOpenCashier()) {
                        setLimitCashiers(false);
                        openCashier(Monitoring.getNumberCashier());
                    }
                    //last CASHIER
                    else if (Monitoring.getCountOpenCashier() != 1) {
                        setLimitCashiers(true);
                    }
                } else if (expectedCashier < MAX_CASHIER) {
                    setLimitCashiers(true);
                }
                Helper.timeout(TIMEOUT);
            }
        });
        helperManager.start();
    }

    public static synchronized boolean isLimitCashiers() {
        return limitCashiers;
    }

    public static synchronized void setLimitCashiers(boolean limitCashiers) {
        Manager.limitCashiers = limitCashiers;
    }

    private static void openCashier(int num) {
        Cashier cashier = new Cashier(num);
        Thread thread = new Thread(cashier);
        thread.start();
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
