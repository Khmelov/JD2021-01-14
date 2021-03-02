package by.it.voitenkov.jd02_02.tasks.a;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {
    private final Deque<Buyer> listBuyer = new ArrayDeque<>();

    public QueueBuyers() {
    }

    public synchronized void toGetInLine(Buyer buyer) {
        listBuyer.addLast(buyer);
    }

    public synchronized Deque<Buyer> getListBuyer() throws InterruptedException {
        return listBuyer;
    }
}