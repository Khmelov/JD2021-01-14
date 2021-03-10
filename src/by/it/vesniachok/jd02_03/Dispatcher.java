package by.it.vesniachok.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {


    final static int K_SPEED = 100;

    private final int PLAN = 100;
    private final AtomicInteger countBuyerInMarket = new AtomicInteger(0);
    private final AtomicInteger countBuyerComplete = new AtomicInteger(0);

    boolean marketIsClosed() {
        return countBuyerComplete.get() == PLAN &&
                countBuyerInMarket.get() == 0;
    }

    boolean marketIsOpened() {
        return countBuyerComplete.get() + countBuyerInMarket.get() != PLAN;
    }

    void enteredCurrentBuyer() {
        countBuyerInMarket.getAndIncrement();
    }

    void completeCurrentBuyer() {
        countBuyerInMarket.getAndDecrement();
        countBuyerComplete.getAndIncrement();
    }
}