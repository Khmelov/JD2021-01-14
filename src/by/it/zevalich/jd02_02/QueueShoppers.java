package by.it.zevalich.jd02_02;
import java.util.ArrayDeque;
import java.util.Deque;

public class QueueShoppers {
    private static final Deque<Shopper> SHOPPERS_DEQUE = new ArrayDeque<>();

    static synchronized void add(Shopper shopper) {
        SHOPPERS_DEQUE.addLast(shopper);
    }

    static synchronized Shopper poll() {
        return SHOPPERS_DEQUE.pollFirst();
    }
}
