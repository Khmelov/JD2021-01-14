package by.it.zevalich.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market extends Thread{
    static final int COUNT_CASHIERS = 5;

    private final QueueBuyers queueBuyers;
    private final Dispatcher dispatcher;

    Market(Dispatcher dispatcher, QueueBuyers queueBuyers) {
        this.queueBuyers = queueBuyers;
        this.dispatcher = dispatcher;
    }

    public QueueBuyers getQueueBuyers() {
        return queueBuyers;
    }
    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    @Override
    public void run() {
        System.out.println("Market opened");
        int numberBuyer = 0;
        ExecutorService threadPool = Executors.newFixedThreadPool(COUNT_CASHIERS);
        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier, this);
            threadPool.submit(cashier);
        }
        threadPool.shutdown();

        while (dispatcher.marketIsOpened()) {
            int n = Utils.random(2);
            for (int i = 0; i < n && dispatcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++numberBuyer, this);
                buyer.start();
            }
            Utils.timeout(1000);
        }
        try {
            while (!threadPool.awaitTermination(1, TimeUnit.SECONDS)) {
                Thread.onSpinWait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Market closed");

    }
}
