package by.it.shebeko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Supervisor {

    private static final AtomicInteger buyersEnterTheMarket = new AtomicInteger(0);
    private  static  final AtomicInteger buyersLeftTheMarket = new AtomicInteger(0);

    private static final int buyerTotal = 100;

    static synchronized void addBuyer() {
        buyersEnterTheMarket.getAndIncrement();
    }
    static void leaveBuyer() {buyersLeftTheMarket.getAndIncrement(); }

    static boolean marketIsOpened(){ return buyersEnterTheMarket.get() != buyerTotal; }
    static boolean marketIsClosed(){ return buyersLeftTheMarket.get() == buyerTotal;
    }
}
