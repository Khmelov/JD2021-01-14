package by.it._classwork_.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    //сама очередь скрыта.
    private static final Deque<Buyer> BUYER_DEQUE = new ArrayDeque<>();

    //делаем обращение к очереди безопасным safe-thead (монитор - QueueBuyers.class)
    static synchronized void add(Buyer buyer) {
        BUYER_DEQUE.addLast(buyer);
    }

    //делаем обращение к очереди безопасным safe-thead (монитор - QueueBuyers.class)
    static synchronized Buyer poll() {
        return BUYER_DEQUE.pollFirst();
    }

}
