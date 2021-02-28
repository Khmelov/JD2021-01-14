package by.it.abeseda.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    //сама очередь скрыта.
    //потокобезопасная очередь длина у которой 30!не более!
    //блокирующие очереди BlockingDeque, гарантирующие остановку
    //потока (если нет элемента или нет места для вставки)
    private final BlockingDeque<Buyer> BUYER_DEQUE = new LinkedBlockingDeque<>(30);

    //делаем обращение к очереди безопасным safe-thead (монитор - QueueBuyers.class)
    void add(Buyer buyer) {
        try {
            BUYER_DEQUE.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //делаем обращение к очереди безопасным safe-thead (монитор - QueueBuyers.class)
    Buyer poll() {
        return BUYER_DEQUE.pollFirst();
    }

}
