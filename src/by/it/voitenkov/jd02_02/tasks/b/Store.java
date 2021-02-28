package by.it.voitenkov.jd02_02.tasks.b;

import java.math.BigDecimal;
import java.util.*;

public class Store implements StoreBehavior, Runnable {
    private final String nameStore; // имя магазина
    private final long shopOpeningHours;
    private int id = 0; // id покупателя
    private static final HashMap<String, BigDecimal> productsList = new HashMap<>(); // список продуктов
    private final List<Thread> listThreadsBuyers = new ArrayList<>();
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

        while (dispatcher.getQueueBuyers().numberWorkingStreamsOfBuyers() > 0) {

        }
        close();
    }

    public void getBuyer() {
        Buyer buyer;
        if (Math.random() < 0.25) {
            buyer = new Pensioner(String.valueOf(++id), dispatcher);
        } else {
            buyer = new Buyer(String.valueOf(++id), dispatcher);
        }
        Thread threadBuyer = new Thread(buyer);
        threadBuyer.start();
        listThreadsBuyers.add(threadBuyer);

        try {
            Thread.sleep(Time.TIME_UPDATE_NUMBER_NEW_BUYERS / Time.SPEED_UP_STORE_OPENING_HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, BigDecimal> getProductsList() {
        return productsList;
    }

    public List<Thread> getListThreadsBuyers() {
        return listThreadsBuyers;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public long getShopOpeningHours() {
        return shopOpeningHours;
    }
}