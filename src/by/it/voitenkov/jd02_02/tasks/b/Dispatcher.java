package by.it.voitenkov.jd02_02.tasks.b;

public class Dispatcher implements Runnable {
    private Store store;
    private QueueBuyers queueBuyers;
    Thread threadStore;
    Thread threadDispatcher;
    Thread threadQueueBuyers;

    public Dispatcher() {
        threadDispatcher = new Thread(this);
        threadDispatcher.start();
    }

    @Override
    public void run() {
        store = new Store("Vitalur", 120, this);
        queueBuyers= new QueueBuyers(this);
        threadStore = new Thread(store);
        threadQueueBuyers = new Thread(queueBuyers);
        threadStore.start();
        threadQueueBuyers.start();
        try {
            Thread.sleep(this.getStore().getShopOpeningHours() / Time.SPEED_UP_STORE_OPENING_HOURS);
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