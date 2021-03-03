package by.it.voitenkov.jd02_03.tasks.a;

import java.util.concurrent.*;

public class Dispatcher implements Runnable {
    private final Store store = new Store("Vitalur", this);
    private final QueueBuyers queueBuyers = new QueueBuyers();
    private final int countCashiers = 2;

    ExecutorService threadsCashiers = Executors.newFixedThreadPool(countCashiers);

    public Dispatcher() {

    }

    @Override
    public void run() {
        Thread threadStore = new Thread(store);
        threadStore.start();
        addThreadCashiers();
        int sizeBuyers = 100;
        addBuyer(sizeBuyers);
    }

    private void addThreadCashiers() {
        for (int i = 0; i < 2; i++) {
            Cashier cashier = new Cashier(i+1,this);
            threadsCashiers.submit(cashier);
        }
        threadsCashiers.shutdown();
    }

    public void addBuyer(int numberBuyer) {
        for (int i = 1; i <= numberBuyer; i++) {
            this.getStore().addBuyersCame();
            Buyer buyer;
            if (Math.random() < 0.25) {
                buyer = new Pensioner(String.valueOf(i), this);
            } else {
                buyer = new Buyer(String.valueOf(i), this);
            }
            Thread thread = new Thread(buyer);
            thread.start();
        }

        try {
            Thread.sleep(Time.TIME_UPDATE_NUMBER_NEW_BUYERS / Time.SPEED_UP_STORE_OPENING_HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Store getStore() {
        return store;
    }

    public QueueBuyers getQueueBuyers() {
        return queueBuyers;
    }
}