package by.it.vesniachok.jd02_02;

public class Dispatcher {

    //чтобы быстрее считать
    final static int SPEED=100;

    private static final Object MONITOR=new Object();

    private static final int PLAN=100;
    private volatile static int countBuyersInMarket=0;
    private volatile static int countBuyersExit=0;


    static boolean marketIsOpened(){
        return countBuyersExit+countBuyersInMarket<PLAN;
    }

    static boolean marketIsClosed(){
        return countBuyersExit==PLAN && countBuyersInMarket==0;
    }

    static void countEnteredBuyer(){
        synchronized (MONITOR) {
        countBuyersInMarket++;
        }
    }
    static void countExitedBuyer(){
        synchronized (MONITOR){
            countBuyersInMarket--;
            countBuyersExit++;
        }
    }
}