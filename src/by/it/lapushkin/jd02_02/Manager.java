package by.it.lapushkin.jd02_02;

public class Manager {
    private static final int MAX_CASHIER = 5;
    private static int currentTime = 0;
    private static boolean manyCashiers;

    public static void main(String[] args) {
        int timeEnd = 120;
        startDay();
        startSupportManager();
        for (int time = 0; time <= timeEnd; time++) {
            setCurrentTime(time);
            int circleTime = time%60;
            int max  = (circleTime < 30) ? circleTime + 10 : circleTime - 10;
            Score.jobScore(max);
            Helper.timeout(1000);
        }
        Score.closeDoorScore();
        while (!Monitoring.emptyScore() && !Monitoring.cashierIsEmpty()) {
            //overtime
            currentTime++;
            Helper.timeout(1000);
            //ожидаха
        }
        endDay();
    }

    public static void setManyCashiers(boolean manyCashiers) {
        Manager.manyCashiers = manyCashiers;
    }

    private static void startSupportManager() {
        Thread helperManager = new Thread(() -> {
            while (Score.isScoreOpen()) {
                int queueLength = QueueCustomers.getLengthCustomerDeque() + QueueCustomers.getLengthOldCustomerDeque();
                int expectedCashier = queueLength / MAX_CASHIER;
                if (Monitoring.getCountOpenCashier() < MAX_CASHIER) {
                    if (expectedCashier > Monitoring.getCountOpenCashier()) {
                        Manager.setManyCashiers(false);
                        openCashier(Monitoring.getNumberCashier());
                    }
                    //last CASHIER
                    else if (Monitoring.getCountOpenCashier() != 1){
                        Manager.setManyCashiers(true);
                    }
                }else if (expectedCashier < MAX_CASHIER){
                    Manager.setManyCashiers(true);
                }
                Helper.timeout(50);
            }
        });
        helperManager.start();
    }

    public static synchronized boolean isManyCashiers() {
        return manyCashiers;
    }

    private static void openCashier(int num) {
        Cashier cashier = new Cashier(num);
        Thread thread = new Thread(cashier);
        thread.start();
    }

    private static void startDay() {
        Score.openScore();
        Score.openDoorScore();
    }

    private static void endDay() {
        Score.closeScore();
    }

    private static void setCurrentTime(int currentTime) {
        Manager.currentTime = currentTime;
    }

    public static int getCurrentTime() {
        return currentTime;
    }
}
