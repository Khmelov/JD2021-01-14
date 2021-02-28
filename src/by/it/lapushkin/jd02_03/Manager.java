package by.it.lapushkin.jd02_03;

import static by.it.lapushkin.jd02_02.Helper.logicCustomers;
import static by.it.lapushkin.jd02_02.Helper.timeout;

public class Manager extends Thread {
    private static final int MAX_CASHIER = 5;
    private static final int END_DAY = 120;
    private static final int TIMEOUT = 1000;
    private final Monitoring monitoring = new Monitoring(this);
    private final Score score = new Score("BEl_HARD_WARE", monitoring);
    private String name;
    private int currentTime = 0;
    private boolean limitCashiers;

    public Manager(String name) {
        this.name = name;
    }

    public void workDay() {
        startDay();
        startCashierManager();
        startScoreManager();

        for (int time = 0; time <= END_DAY; time++) {
            setCurrentTime(time);
            score.jobScore(logicCustomers(time));
            timeout(TIMEOUT);
        }

        score.closeDoor();

        //ожидаем пока кассы обслужат последних клиентов и закроются
        while (!monitoring.emptyScore() && !monitoring.cashierIsEmpty()) {
            //overtime
            currentTime++;
            timeout(TIMEOUT);
            //ожидаха
        }
        endDay();
    }

    @Override
    public void run() {
        super.run();
    }

    private void startScoreManager() {
        Thread customerManager = new Thread(() -> {
            while (score.isScore().get()) {
                if (monitoring.isFullScore()) {
                    if (score.isDoor().get()) {
                        score.closeDoor();
                    }
                } else {
                    if (!score.isDoor().get() && currentTime < END_DAY) {
                        score.openDoor();
                    }
                }
            }
            timeout(TIMEOUT);
        });
        customerManager.start();
    }

    private void startCashierManager() {
        Thread helperManager = new Thread(() -> {
            while (score.isScore().get()) {
                int expectedCashier = (QueueCustomers.getLengthAllQueue() / MAX_CASHIER) + 1;
                if (monitoring.getCountOpenCashier() < MAX_CASHIER) {
                    if (expectedCashier > monitoring.getCountOpenCashier()) {
                        setLimitCashiers(false);
                        openCashier(monitoring.getNumberCashier());
                    }
                    //last CASHIER
                    else if (monitoring.getCountOpenCashier() != 1) {
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

    public boolean isLimitCashiers() {
        return limitCashiers;
    }

    public void setLimitCashiers(boolean limitCashiers) {
        this.limitCashiers = limitCashiers;
    }

    private void openCashier(int num) {
        Cashier cashier = new Cashier(num);
        Thread thread = new Thread(cashier);
        thread.start();
    }

    private void startDay() {
        score.openScore();
        score.openDoor();
    }

    private void endDay() {
        score.closeScore();
    }

    public int getCurrentTime() {
        return currentTime;
    }

    private void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }
}
