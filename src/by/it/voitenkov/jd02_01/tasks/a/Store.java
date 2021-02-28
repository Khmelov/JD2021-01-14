package by.it.voitenkov.jd02_01.tasks.a;

import java.util.ArrayList;
import java.util.List;

class Store implements StoreBehavior, Runnable {
    private final List<Thread> threadsList = new ArrayList<>();
    private static int id = 1;
    private final String nameStore;
    static long shopOpeningHours;

    public Store(String nameStore, long shopOpeningHours) {
        this.nameStore = nameStore;
        Store.shopOpeningHours = shopOpeningHours * 60000L;
    }

    @Override
    public void open() {
        System.out.println(this + " открылся");
    }

    @Override
    public void close() {
        System.out.println(this + " закрылся");
    }

    @Override
    public String toString() {
        return "Магазин " + nameStore;
    }

    @Override
    public void run() {
        open();
        Thread thread = new Thread(new ShopOpeningHours((shopOpeningHours)));
        thread.start();
        while (thread.isAlive()) {
            for (int i = 0; i < Time.getNewBuyers(); i++) {
                Thread buyer = new Thread (new Buyer(String.valueOf(id++)));
                buyer.start();
                threadsList.add(buyer);
            }
            try {
                Thread.sleep(1000/Time.SPEED_UP_STORE_OPENING_HOURS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(Thread threadList : threadsList) {
            try {
                threadList.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        close();
    }
}