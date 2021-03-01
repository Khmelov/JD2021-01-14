package by.it.petrov.jd02_02;

import java.util.ArrayDeque;

public class Deque {

    private static volatile ArrayDeque<Buyer> PAYMENT_DEQUE = new ArrayDeque<>();
    private static volatile ArrayDeque<Buyer> PAYMENT_DEQUE_PENSIONEER = new ArrayDeque<>();

    public static synchronized void add(Buyer buyer) {
        if (buyer.isPensioneer()) {
            PAYMENT_DEQUE_PENSIONEER.add(buyer);
        } else {
            PAYMENT_DEQUE.add(buyer);
        }
    }

    public static synchronized Buyer poll() {
        return PAYMENT_DEQUE.poll();
    }

    public static synchronized Buyer pollP() {
        return PAYMENT_DEQUE_PENSIONEER.poll();
    }


    public static synchronized boolean isEmpty() {
        return PAYMENT_DEQUE.isEmpty();
    }

    public static synchronized boolean isEmptyP() {
        return PAYMENT_DEQUE_PENSIONEER.isEmpty();
    }

    public static Integer currentCustomersInDeque() {
        return PAYMENT_DEQUE.size() + PAYMENT_DEQUE_PENSIONEER.size();
    }
}
