package by.it.voitenkov.jd02_02.tasks.a;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher implements Runnable {
    private final long time;
    private Store store;
    private Cashier cashier;
    private QueueBuyers queueBuyers = new QueueBuyers();
    private List<Cashier> listCashier = new ArrayList<>();
    private List<Thread> listThreadCashier = new ArrayList<>();
    private Thread threadStrore;

    public Dispatcher(double time) {
        this.time = (long) (time * 1000);
    }

    @Override
    public void run() {
        store = new Store("Vitalur", 120, this);
        addThreadCashiers();
        threadStrore = new Thread(store);
        threadStrore.start();

        try {
            Thread.sleep(time / Time.SPEED_UP_STORE_OPENING_HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addThreadCashiers() {
        for (int i = 0; i < 2; i++) {
            Cashier cashier = new Cashier(i+1,this);
            listCashier.add(cashier);
            Thread thread = new Thread(cashier);
            listThreadCashier.add(thread);
            thread.start();
        }
    }

    public Store getStore() {
        return store;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public QueueBuyers getQueueBuyers() {
        return queueBuyers;
    }

    public List<Thread> getListThreadCashier() {
        return listThreadCashier;
    }
}