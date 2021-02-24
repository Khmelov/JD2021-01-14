package by.it.voitenkov.jd02_01.tasks.b;

import java.util.*;

class Store implements StoreBehavior, Runnable {
    private static long shopOpeningHours;
    private static int id = 1;
    private static final HashMap<String, Double> productsList = new HashMap<>();
    private final String nameStore;
    private final List<Thread> threadsList = new ArrayList<>();

    static {
        productsList.put("Молоко", 3.5);
        productsList.put("Хлеб", 1.2);
        productsList.put("Мясо", 10.9);
        productsList.put("Вода", 1.4);
    }

    public Store(String nameStore, long shopOpeningHours) {
        this.nameStore = nameStore;
        Store.shopOpeningHours = shopOpeningHours * 60000L;
    }

    @Override
    public void open() {
        System.out.println(this + " открылся\n");
    }

    @Override
    public void close() {
        System.out.println(this + " закрылся\n");
    }

    @Override
    public String toString() {
        return "Магазин " + nameStore;
    }

    @Override
    public void run() {
        Thread thread = new Thread(new ShopOpeningHours((shopOpeningHours)));
        open();
        thread.start();

        while (thread.isAlive()) {
            for (int i = 0; i < Time.getNewBuyers(); i++) {
                Buyer buyer = new Buyer(String.valueOf(id++));
                Thread threadBuyer = new Thread(buyer);
                threadBuyer.start();
                threadsList.add(threadBuyer);
            }
            try {
                Thread.sleep(Time.TIME_UPDATE_NUMBER_NEW_BUYERS / Time.SPEED_UP_STORE_OPENING_HOURS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread threadList : threadsList) {
            try {
                threadList.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        close();
    }

    public static HashMap<String, Double> getProductsList() {
        return productsList;
    }
}