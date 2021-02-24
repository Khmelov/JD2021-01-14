package by.it.shebeko.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {

    private static BlockingDeque <Buyers> deque = new LinkedBlockingDeque<>(30);

    static void add(Buyers buyers){
        try{
            deque.putLast(buyers);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    static Buyers extract(){
        return deque.pollFirst();
    }
}
