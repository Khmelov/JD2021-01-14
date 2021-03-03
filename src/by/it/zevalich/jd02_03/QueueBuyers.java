package by.it.zevalich.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {
    private final BlockingDeque<Buyer> BUYER_DEQUE = new LinkedBlockingDeque<>(30);

    void add(Buyer buyer) {
        try {
            BUYER_DEQUE.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Buyer poll() {
        return BUYER_DEQUE.pollFirst();
    }
}
