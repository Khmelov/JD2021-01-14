package by.it.voitenkov.jd02_03.tasks.b;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Store implements StoreBehavior, Runnable {
    private final String nameStore;
    private final Dispatcher dispatcher;
    private final AtomicInteger buyersCame = new AtomicInteger(0);
    private final AtomicInteger buyersLeft = new AtomicInteger(0);
    private static final HashMap<String, BigDecimal> productsList = new HashMap<>(); // список продуктов

    public Store(String nameStore, Dispatcher dispatcher) {
        this.nameStore = nameStore;
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
        try {
            while (!dispatcher.threadsCashiers.awaitTermination(1, TimeUnit.SECONDS)) {
                Thread.onSpinWait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        close();
    }

    public HashMap<String, BigDecimal> getProductsList() {
        return productsList;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public boolean isStoreOpen() {
        int count = buyersCame.get() - buyersLeft.get();
        return count != 0;
    }

    public void setBuyersLeft() {
        this.buyersLeft.getAndIncrement();
    }

    public void addBuyersCame() {
        this.buyersCame.getAndIncrement();
    }
}