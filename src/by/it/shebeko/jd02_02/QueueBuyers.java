package by.it.shebeko.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyers {

    private static final Object MONITOR = new Object();

    static Deque<Buyers> deque = new LinkedList<>();
    static volatile int countBuyers = 0;
    static void add (Buyers buyers){
        synchronized (MONITOR){
            deque.addLast(buyers);
        }
    }
    static Buyers extract(){
        synchronized (MONITOR){
            return deque.pollFirst();
        }
    }
}
