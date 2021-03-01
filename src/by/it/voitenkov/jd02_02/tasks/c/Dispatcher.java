package by.it.voitenkov.jd02_02.tasks.c;

public class Dispatcher implements Runnable {
    private Store store;
    private final QueueBuyers queueBuyers = new QueueBuyers(this);
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
        threadStore = new Thread(store);
        threadStore.start();
        int tmp = 0;
        int randomPerson = 0;
        for (int time = 0, circleTime = 0; circleTime < getStore().getShopOpeningHours(); time++, circleTime++) {
            if (time % 60 == 0 && circleTime == 60) {
                tmp = 0;
                randomPerson = 0;
                time = 0;
            }

            if (time < 30) {
                int minimumRange = ((time == 0) ? time : (time + 10));
                int maximumRange = ((minimumRange == 0) ? (10 - randomPerson) : (minimumRange + tmp - randomPerson));
                tmp = maximumRange;
                randomPerson = (int) Math.floor(Math.random() * (maximumRange - minimumRange + 1) + minimumRange);

                if (randomPerson >= minimumRange) {
                    getStore().getBuyer(randomPerson);
                }
            } else {
                int minimumRange = 10 + (tmp - randomPerson);
                int maximumRange = 40 + (30 - time);
                tmp = maximumRange;
                randomPerson = (int) Math.floor(Math.random() * (maximumRange - minimumRange + 1) + minimumRange);

                if (randomPerson <= minimumRange) {
                    getStore().getBuyer(randomPerson);
                }
            }
        }
        threadQueueBuyers = new Thread(queueBuyers);
        threadQueueBuyers.start();
    }

    public Store getStore() {
        return store;
    }

    public QueueBuyers getQueueBuyers() {
        return queueBuyers;
    }
}