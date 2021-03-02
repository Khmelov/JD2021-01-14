package by.it.petrov.jd02_03;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class Deque {

    private static final Comparator<Buyer> comparator = new Comparator<Buyer>() {
        @Override
        public int compare(Buyer o1, Buyer o2) {
            if (o1.isPensioneer() && o2.isPensioneer()) {return  0;}
            if (o1.isPensioneer()) {return  1;}
            if (o2.isPensioneer()) {return  -1;}
            else return 0;
        }
    };

    private static final PriorityBlockingQueue<Buyer> paymentPriorityBlockingQueue =
            new PriorityBlockingQueue<>(30, comparator);

    public static void add(Buyer buyer) {
            paymentPriorityBlockingQueue.put(buyer);
    }

    public static Buyer poll() {
        return paymentPriorityBlockingQueue.poll();
    }


    public static boolean isEmpty() {
        return paymentPriorityBlockingQueue.isEmpty();
    }

    public static Integer currentCustomersInDeque() {
        return paymentPriorityBlockingQueue.size();
    }
}