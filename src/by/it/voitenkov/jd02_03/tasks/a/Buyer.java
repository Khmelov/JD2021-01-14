package by.it.voitenkov.jd02_03.tasks.a;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class Buyer implements BuyerBehavior, BasketBehavior, Runnable {
    private final String name;
    private final HashMap<String, BigDecimal> basket = new HashMap<>();
    Dispatcher dispatcher;

    public Buyer(String name, Dispatcher dispatcher) {
        super();
        this.name = name;
        this.dispatcher = dispatcher;
    }

    Object getMonitorWaiting() {
        return this;
    }

    private boolean waitFlag;

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }

    @Override
    public synchronized void enterToMarket() {
        System.out.println(this + " вошел в магазин.");
    }

    @Override
    public void takeBasket() {
        try {
            double timeOperation = Time.getItemSelectionTime();
            Thread.sleep(timeOperationLong() / Time.SPEED_UP_STORE_OPENING_HOURS);
            System.out.printf("%s взял корзину. (%.2f секунд.)\n", this, timeOperation);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void chooseGoods() {
        try {
            double timeOperation = Time.getItemSelectionTime();
            Thread.sleep(timeOperationLong() / Time.SPEED_UP_STORE_OPENING_HOURS);
            System.out.printf("%s выбрал товар (%.2f секунд).\n", this, timeOperation);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putGoodsToBasket() {
        int id = 1;
        HashMap<Integer, String> listProductsId = new HashMap<>();
        Set<Map.Entry<String, BigDecimal>> entries = dispatcher.getStore().getProductsList().entrySet();

        for (Map.Entry<String, BigDecimal> entry : entries) {
            listProductsId.put(id++, entry.getKey());
        }

        for (int i = 0; i < new Random().nextInt(4) + 1; i++) {
            chooseGoods();
            String product = listProductsId.get(new Random().nextInt(listProductsId.size()) + 1);
            BigDecimal price = dispatcher.getStore().getProductsList().get(product);

            if (basket.containsKey(product)) {
                basket.replace(product, basket.get(product).add(dispatcher.getStore().getProductsList().get(product)));
            } else {
                basket.put(product, price);
            }

            try {
                double timeOperation = Time.getItemSelectionTime();
                Thread.sleep(timeOperationLong() / Time.SPEED_UP_STORE_OPENING_HOURS);
                System.out.printf("%s положил %s в корзину (%.2f секунд.)\n", this, product, timeOperation);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " закончил выбирать продукты и пошел в кассу.");
        synchronized (this) {
            toGetInLine();
            waitFlag = true;
            while (waitFlag)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    @Override
    public void toGetInLine() {
        dispatcher.getQueueBuyers().addQueue(this);
    }

    @Override
    public void leftTheStore() {
        System.out.println(this + " вышел из магазина.");
        dispatcher.getStore().setBuyersLeft();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        putGoodsToBasket();
        leftTheStore();
    }

    @Override
    public String toString() {
        return "Покупатель № " + name;
    }

    public String getName() {
        return name;
    }

    static long timeOperationLong() {
        return (long) (Time.getItemSelectionTime() * 1000);
    }

    public HashMap<String, BigDecimal> getBasket() {
        return basket;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }
}