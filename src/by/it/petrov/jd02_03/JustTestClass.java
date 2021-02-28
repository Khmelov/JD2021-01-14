package by.it.petrov.jd02_03;

import java.util.concurrent.*;

public class JustTestClass {

    private static ArrayBlockingQueue<Buyer> paymentBlockingDeque = new ArrayBlockingQueue(5);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            try {
                paymentBlockingDeque.put(new Buyer(String.valueOf(i)));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(i + "has been added to queue");

            }
        }
    }
}