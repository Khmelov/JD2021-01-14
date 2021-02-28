package by.it.nakhankov.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueCustomers {

    private static final Deque<Customer> CUSTOMER_DEQUE = new ArrayDeque<>();

    static synchronized void add(Customer customer) {
        CUSTOMER_DEQUE.addLast(customer);
    }

    static synchronized Customer poll() {
        return CUSTOMER_DEQUE.pollFirst();
    }

}
