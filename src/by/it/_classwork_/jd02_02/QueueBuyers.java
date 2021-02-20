package by.it._classwork_.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    private static Deque<Buyer> buyers = new ArrayDeque<>();

    static synchronized void add(Buyer buyer) {
            buyers.addLast(buyer);
    }

    static synchronized Buyer poll(){
        return buyers.pollFirst();
    }

}
