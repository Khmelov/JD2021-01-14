package by.it.lapushkin.jd02_03;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueCustomers {

    private static final Deque<Person> CUSTOMER_DEQUE = new ArrayDeque<>();
    private static final Deque<Person> OLD_CUSTOMER_DEQUE = new ArrayDeque<>();

    private QueueCustomers() {

    }

    static synchronized void oldAdd(Person oldCustomer) {
        OLD_CUSTOMER_DEQUE.addLast(oldCustomer);
    }

    static synchronized boolean isOldDequeEmpty() {
        return OLD_CUSTOMER_DEQUE.isEmpty();
    }

    static synchronized int getLengthCustomerDeque() {
        return CUSTOMER_DEQUE.size();
    }

    static synchronized int getLengthOldCustomerDeque() {
        return OLD_CUSTOMER_DEQUE.size();
    }

    static synchronized int getLengthAllQueue() {
        return getLengthCustomerDeque() + getLengthOldCustomerDeque();
    }

    static synchronized void add(Person customer) {
        CUSTOMER_DEQUE.addLast(customer);
    }

    static synchronized Person poll() {
        if (isOldDequeEmpty()) {
            return CUSTOMER_DEQUE.pollFirst();
        } else {
            return OLD_CUSTOMER_DEQUE.pollFirst();
        }

    }

}
