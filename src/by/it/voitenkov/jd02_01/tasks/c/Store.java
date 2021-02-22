package by.it.voitenkov.jd02_01.tasks.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Store implements StoreBehavior, Runnable {
    private static double shopOpeningHours;
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
        Store.shopOpeningHours = shopOpeningHours;
    }

    @Override
    public void open() {
        System.out.print(this + " открылся\n");
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
        int tmp = 0;
        int randomPerson = 0;

        Thread thread = new Thread(new ShopOpeningHours((shopOpeningHours)));
        open();
        thread.start();

        for (int time = 0, circleTime = 0; circleTime < shopOpeningHours; time++, circleTime++) {
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
                    getBuyer(randomPerson);
                }
            } else {
                int minimumRange = 10 + (tmp - randomPerson);
                int maximumRange = 40 + (30 - time);
                tmp = maximumRange;
                randomPerson = (int) Math.floor(Math.random() * (maximumRange - minimumRange + 1) + minimumRange);

                if (randomPerson <= minimumRange) {
                    getBuyer(randomPerson);
                }
            }
        }

        for (
                Thread threadList : threadsList) {
            try {
                threadList.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        close();
    }

    public void getBuyer(int randomPerson) {
        boolean wasCreatedPensioner = false;
        for (int i = 0; i < randomPerson; i++) {
            wasCreatedPensioner = Math.random() < 0.25;
            if (wasCreatedPensioner || id % 4 == 0) {
                Buyer pensioner = new Pensioner(String.valueOf(id++));
                Thread threadPensioner = new Thread(pensioner);
                threadPensioner.start();
                threadsList.add(threadPensioner);
            } else {
                Buyer buyer = new Buyer(String.valueOf(id++));
                Thread threadBuyer = new Thread(buyer);
                threadBuyer.start();
                threadsList.add(threadBuyer);
            }
        }

        try {
            Thread.sleep(Time.TIME_UPDATE_NUMBER_NEW_BUYERS / Time.SPEED_UP_STORE_OPENING_HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, Double> getProductsList() {
        return productsList;
    }
}