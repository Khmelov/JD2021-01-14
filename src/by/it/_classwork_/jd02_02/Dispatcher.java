package by.it._classwork_.jd02_02;

class Dispatcher {

    private Dispatcher() {
    }

    private final static Object MONITOR = new Object();
    final static int K_SPEED = 100;

    private final static int PLAN = 100;

    private volatile static int countBuyerInMarket = 0;
    private volatile static int countBuyerComplete = 0;

    static boolean marketClosed() {
        return countBuyerComplete == PLAN &&
                countBuyerInMarket == 0;
    }

    static boolean marketOpened() {
        return countBuyerComplete + countBuyerInMarket < PLAN;
    }

    static void enteredBuyer() {
        synchronized (MONITOR) {
            countBuyerInMarket++;
        }
    }

    static void completeBuyer() {
        synchronized (MONITOR) {
            countBuyerInMarket--;
            countBuyerComplete++;
        }
    }
}
