package by.it.nakhankov.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Market extends Thread {
    static final int COUNT_CASHIERS = 5;

    private final QueueCustomers queueCustomers;

    private final Dispatcher dispatcher;


    Market(Dispatcher dispatcher, QueueCustomers queueCustomers) {
        this.queueCustomers = queueCustomers;
        this.dispatcher = dispatcher;
    }

    public QueueCustomers getQueueCustomers() {
        return queueCustomers;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    @Override
    public void run() {
        System.out.println("Market opened");
        int numberCustomer = 0;
        ExecutorService threadPool = Executors.newFixedThreadPool(COUNT_CASHIERS);

        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier, this);
            threadPool.submit(cashier);
        }

        threadPool.shutdown();

        while (dispatcher.marketIsOpened()) {
            int n = Utils.random(2);
            for (int i = 0; i < n && dispatcher.marketIsOpened(); i++) {
                Customer customer = new Customer(++numberCustomer, this);
                customer.start();
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
