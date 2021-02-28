package by.it.nakhankov.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    final static int K_SPEED = 100;

    private final int PLAN = 100;

    private final AtomicInteger countCustomerInMarket = new AtomicInteger(0);
    private final AtomicInteger countCustomerComplete = new AtomicInteger(0);

    boolean marketIsClosed() {
        return countCustomerComplete.get() == PLAN &&
                countCustomerInMarket.get() == 0;
    }

    boolean marketIsOpened() {
        return countCustomerComplete.get() + countCustomerInMarket.get() != PLAN;
    }

    void enteredCurrentCustomer() {
        countCustomerInMarket.getAndIncrement();
    }

    void completeCurrentCustomer() {
        countCustomerInMarket.getAndDecrement();
        countCustomerComplete.getAndIncrement();
    }
}
