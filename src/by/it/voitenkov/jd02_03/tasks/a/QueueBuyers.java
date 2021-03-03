package by.it.voitenkov.jd02_03.tasks.a;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    private final BlockingDeque<Buyer> generalQueue = new LinkedBlockingDeque<>(30);

    void addQueue(Buyer buyer) {
        try {
            generalQueue.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Buyer pollFirst() throws InterruptedException {
        return generalQueue.pollFirst();
    }
}