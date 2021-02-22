package by.it.voitenkov.jd01_16;

import org.junit.experimental.theories.Theories;

import java.util.TreeMap;

public class Store implements StoreBehavior, Runnable {
    private int id = 0;
    private final String nameStore;
    private long shopOpeningHours;

    public Store(String nameStore, int shopOpeningHours) {
        this.nameStore = nameStore;
        this.shopOpeningHours = shopOpeningHours * 60000L;
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
        boolean bool = false;
        open();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().isAlive());
        close();

    }
}

