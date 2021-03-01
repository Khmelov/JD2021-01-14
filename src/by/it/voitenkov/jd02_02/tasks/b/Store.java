package by.it.voitenkov.jd02_02.tasks.b;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Store implements StoreBehavior, Runnable {
    private final String nameStore;
    private int id = 0;
    private final long shopOpeningHours;
    private int counterBuyers = 0;

    private static final HashMap<String, BigDecimal> productsList = new HashMap<>(); // список продуктов

    private final Deque<Thread> listThreadsBuyers = new ArrayDeque<>();
    private final Dispatcher dispatcher;

    public Store(String nameStore, long shopOpeningHours, Dispatcher dispatcher) {
        this.nameStore = nameStore;
        this.shopOpeningHours = shopOpeningHours * 1000;
        this.dispatcher = dispatcher;
        productsList.put("Молоко", new BigDecimal("3.56"));
        productsList.put("Хлеб", new BigDecimal("1.49"));
        productsList.put("Мясо", new BigDecimal("11.50"));
        productsList.put("Вода", new BigDecimal("2.19"));
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
        while (dispatcher.threadDispatcher.isAlive()) {
            getBuyer();
        }
        while (isWorkThreads()) {

        }
        while (isWorkCashiers()) {

        }
        close();
    }

    public synchronized void getBuyer() {
        Buyer buyer;
        if (Math.random() < 0.25) {
            buyer = new Pensioner(String.valueOf(++id), dispatcher);
        } else {
            buyer = new Buyer(String.valueOf(++id), dispatcher);
        }
        Thread threadBuyer = new Thread(buyer);
        listThreadsBuyers.add(threadBuyer);
        counterBuyers++;
        threadBuyer.start();

        try {
            Thread.sleep(Time.TIME_UPDATE_NUMBER_NEW_BUYERS / Time.SPEED_UP_STORE_OPENING_HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean isWorkCashiers() {
        for (Thread listCashiersThread : dispatcher.getQueueBuyers().getListCashiersThreads()) {
            if (listCashiersThread.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public boolean isWorkThreads() {
        for (Thread listThreadsBuyer : listThreadsBuyers) {
            if (listThreadsBuyer.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public int getNumberWorkThreads() {
        int count = 0;
        for (Thread listThreadsBuyer : listThreadsBuyers) {
            if (listThreadsBuyer.isAlive()) {
                count++;
            }
        }
        return count;
    }

    public HashMap<String, BigDecimal> getProductsList() {
        return productsList;
    }

    public Deque<Thread> getListThreadsBuyers() {
        return listThreadsBuyers;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public long getShopOpeningHours() {
        return shopOpeningHours;
    }

    public int getCounterBuyers() {
        return counterBuyers;
    }
}