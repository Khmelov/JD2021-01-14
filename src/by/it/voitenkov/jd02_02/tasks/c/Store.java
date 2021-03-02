package by.it.voitenkov.jd02_02.tasks.c;

import java.math.BigDecimal;
import java.util.*;

public class Store implements StoreBehavior, Runnable {
    private final String nameStore;
    private int id = 0;
    private final long shopOpeningHours;
    private volatile int wentTheStore = 0;
    private volatile int leftTheStore = 0;
    private volatile BigDecimal storeRevenue = new BigDecimal("0.00");

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
        while (storeIsOpen()) {

        }
        while (isCashiersClose()) {

        }
        close();
    }

    public synchronized void getBuyer(int randomPerson) {
        for (int i = 0; i < randomPerson; i++) {
            Buyer buyer;
            if (Math.random() < 0.25) {
                buyer = new Pensioner(String.valueOf(++id), dispatcher);
            } else {
                buyer = new Buyer(String.valueOf(++id), dispatcher);
            }
            Thread threadBuyer = new Thread(buyer);
            listThreadsBuyers.add(threadBuyer);
            threadBuyer.start();

            try {
                Thread.sleep(Time.TIME_UPDATE_NUMBER_NEW_BUYERS / Time.SPEED_UP_STORE_OPENING_HOURS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
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

    public boolean storeIsOpen() {
        if (wentTheStore - leftTheStore != 0) {
            return true;
        }

        return false;
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

    public synchronized void setStoreRevenue(BigDecimal storeRevenue) {
        this.storeRevenue = storeRevenue;
    }

    public BigDecimal getStoreRevenue() {
        return storeRevenue;
    }

    private boolean isCashiersClose() {
        for (Thread listCashiersThread : dispatcher.getQueueBuyers().getListCashiersThreads()) {
            if (listCashiersThread.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public int getWentTheStore() {
        return wentTheStore;
    }

    public void setWentTheStore(int wentTheStore) {
        this.wentTheStore = wentTheStore;
    }

    public void setLeftTheStore(int leftTheStore) {
        this.leftTheStore = leftTheStore;
    }

    public int getLeftTheStore() {
        return leftTheStore;
    }
}