package by.it.shebeko.jd02_02;

public class Supervisor {

    private static volatile int buyersEnterTheMarket = 0;
    private  static  volatile int buyersLeftTheMarket = 0;

    private static final int buyerTotal = 100;

    static synchronized void addBuyer() {
        buyersEnterTheMarket++;
    }
    static void leaveBuyer (){
        synchronized (Supervisor.class){
            buyersLeftTheMarket++;
        }
    }

    static boolean marketIsOpened(){
        return buyersEnterTheMarket != buyerTotal;
    }
    static boolean marketIsClosed(){
        return buyersLeftTheMarket == buyerTotal;
    }
}
