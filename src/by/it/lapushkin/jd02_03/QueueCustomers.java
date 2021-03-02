package by.it.lapushkin.jd02_03;

import java.util.concurrent.ConcurrentLinkedDeque;

public class QueueCustomers {

    private static final ConcurrentLinkedDeque<Person> CUSTOMER_DEQUE = new ConcurrentLinkedDeque<>();
    private static final ConcurrentLinkedDeque<Person> OLD_CUSTOMER_DEQUE = new ConcurrentLinkedDeque<>();

    private QueueCustomers() {
    }

    static void oldAdd(Person oldCustomer) {
        OLD_CUSTOMER_DEQUE.addLast(oldCustomer);
    }

    static boolean isOldDequeEmpty() {
        return OLD_CUSTOMER_DEQUE.isEmpty();
    }
    static boolean isDequeEmpty() {
        return CUSTOMER_DEQUE.isEmpty();
    }

    static int getLengthCustomerDeque() {
        return CUSTOMER_DEQUE.size();
    }

    static int getLengthOldCustomerDeque() {
        return OLD_CUSTOMER_DEQUE.size();
    }

    static int getLengthAllQueue() {
        return getLengthCustomerDeque() + getLengthOldCustomerDeque();
    }

    static void add(Person customer) {
        CUSTOMER_DEQUE.addLast(customer);
    }

    static Person poll() {
        if (isOldDequeEmpty()) {
            return CUSTOMER_DEQUE.pollFirst();
        } else if (!isDequeEmpty()){
            return OLD_CUSTOMER_DEQUE.pollFirst();
        }else {
            return null;
        }

    }

}
