package by.it.petrov.jd02_03;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private final String BUYERS_NAME;
    private boolean pensioneer;
    private final double PENSIONEER_SPEED_COEFFICIENT = 0.66;
    private final double totalSpeed;
    private final double pensioneerProbability = 0.25;
    private ArrayList<String> purchasedProducts = new ArrayList<>();

    private final Semaphore queueSem;
    private final Semaphore hallSem;
    private final Semaphore backetSem;

    private final Map<String, Integer> goods = Map.of(
            "Meet", 300,
            "Milk", 200,
            "Sausages", 500,
            "Apples", 100,
            "Toilet paper", 50,
            "Potatoes", 100
    );

    public boolean isPensioneer() {
        return pensioneer;
    }

    public Buyer(String buyersName, Semaphore hallSem, Semaphore queueSem, Semaphore backetSem) {
        super(buyersName);
        this.queueSem = queueSem;
        this.hallSem = hallSem;
        this.backetSem = backetSem;
        this.BUYERS_NAME = buyersName;
        if (Math.random() <= pensioneerProbability) {
            this.pensioneer = true;
        }
        if (this.pensioneer) {
            totalSpeed = 1 * PENSIONEER_SPEED_COEFFICIENT;
            System.out.println("Attention, " + BUYERS_NAME + " is a retiree ...");
        } else {
            totalSpeed = 1;
        }
        Manager.totalVisitorsCount.getAndAdd(1);
        System.out.println(buyersName + " was created");
    }

    public ArrayList<String> getProductList() {
        return purchasedProducts;
    }

    public Map<String, Integer> getGoodsList() {
        return goods;
    }

    public String getBuyersName() {
        return BUYERS_NAME;
    }

    @Override
    public void layOutGoodsToCashier() {
        try {
            queueSem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Deque.add(this);
        hallSem.release();
        System.out.println(this.getBuyersName() + "stands in the queue ... " +
                "Visitors in the hall left: " + Manager.totalVisitorsInHallCount.addAndGet(-1));
        if (this.pensioneer) {
            System.out.println(this.getBuyersName() + " is in the Queue (Pensioneers queue). And waiting for his turn ...");
        } else {
            System.out.println(this.getBuyersName() + " is in the Queue! And waiting for his turn ...");
        }
        synchronized (this) {
            try {
                this.wait();
                queueSem.release();
                backetSem.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getBuyersName() + " has been served!");
        }
    }

    @Override
    public void takeBasket() {
        try {
            backetSem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.BUYERS_NAME + " has taken a basket ...");
    }

    @Override
    public void putGoodsToBasket() {
        int numberOfGoodsToBuy = (int) Math.round(Math.random() * 3 + 1);
        System.out.println(BUYERS_NAME + " has decided to buy " + numberOfGoodsToBuy + " products");
        chooseGoods();
        for (int i = 0; i < numberOfGoodsToBuy; i++) {
            try {
                Thread.sleep((int) (Math.round(Math.random() * 500 + 500) / (this.totalSpeed * Timer.getSpeedCoefficient())));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String rndGood = (String) goods.keySet().toArray()[(int) Math.round(Math.random() * (goods.size() - 1))];
            System.out.println(BUYERS_NAME + " puts " + rndGood + " into the basket");
            purchasedProducts.add(rndGood);
        }
        System.out.println(BUYERS_NAME + " has finished putting products in his basket");
    }

    @Override
    public void run() {
        Manager.totalVisitorsBehindTheDoors.addAndGet(1);
        enteredToMarket();
        takeBasket();
        putGoodsToBasket();
        layOutGoodsToCashier();
        goOut();
    }

    @Override
    public void enteredToMarket() {
        try {
            hallSem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Manager.totalVisitorsBehindTheDoors.addAndGet(-1);
        System.out.println(BUYERS_NAME + " entered the market! " +
                "Total customers in shop at the current moment: " + Manager.currentVisitorsCountInTheShop.addAndGet(1));
        System.out.println("Customers in the hall " + Manager.totalVisitorsInHallCount.addAndGet(1));
    }

    @Override
    public void chooseGoods() {
        System.out.println(BUYERS_NAME + " is choosing products ...");
        int choosingTime = (int) (Math.round(Math.random() * 1500 + 500) / (this.totalSpeed * Timer.getSpeedCoefficient()));
        try {
            Thread.sleep(choosingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goOut() {
        Manager.currentVisitorsCountInTheShop.getAndAdd(-1);
        System.out.println(BUYERS_NAME + " has left the market ... " +
                "Total customers in shop at the current moment: " + Manager.currentVisitorsCountInTheShop);
    }
}