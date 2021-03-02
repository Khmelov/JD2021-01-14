package by.it.nakhankov.jd02_02;

class Dispatcher {

    private Dispatcher() {
    }

    private final static Object MONITOR = new Object();
    final static int K_SPEED = 100;

    private final static int PLAN = 100;

    private volatile static int countCustomerInMarket = 0;
    private volatile static int countCustomerComplete = 0;

    static boolean marketIsClosed() {
        return countCustomerComplete == PLAN &&
                countCustomerInMarket == 0;
    }

    static boolean marketIsOpened() {
        return countCustomerComplete + countCustomerInMarket < PLAN;
    }

    static void enteredCurrentCustomer() {
        synchronized (MONITOR) {
            countCustomerInMarket++;
        }
    }

    static void completeCurrentCustomer() {
        synchronized (MONITOR) {
            countCustomerInMarket--;
            countCustomerComplete++;
        }
    }
}
