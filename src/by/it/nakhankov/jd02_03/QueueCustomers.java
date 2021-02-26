package by.it.nakhankov.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueCustomers {

    private final BlockingDeque<Customer> CUSTOMER_DEQUE = new LinkedBlockingDeque<>(30);

    void add(Customer customer) {
        try {
            CUSTOMER_DEQUE.putLast(customer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Customer poll() {
        return CUSTOMER_DEQUE.pollFirst();
    }

}
