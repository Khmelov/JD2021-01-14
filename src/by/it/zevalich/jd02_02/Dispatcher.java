package by.it.zevalich.jd02_02;

public class Dispatcher {
    private Dispatcher(){}

    private final static Object MONITOR = new Object();
    final static int K_SPEED = 100;
    private final static int PLAN = 100;

    private volatile static int countShopperInMarket = 0;
    private volatile static int countShopperComplete = 0;

    static boolean marketIsClosed() {
        return countShopperComplete == PLAN &&
                countShopperInMarket == 0;
    }

    static boolean marketIsOpened() {
        return countShopperComplete + countShopperInMarket < PLAN;
    }

    static void enteredCurrentShopper(){
        synchronized (MONITOR){
            countShopperInMarket++;
        }
    }

    static void completeCurrentShopper() {
        synchronized (MONITOR) {
            countShopperInMarket--;
            countShopperComplete++;
        }
    }
}
