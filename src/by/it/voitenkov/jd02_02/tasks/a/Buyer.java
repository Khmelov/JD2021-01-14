package by.it.voitenkov.jd02_02.tasks.a;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class Buyer implements BuyerBehavior, BasketBehavior, Runnable {
    private final String name;
    private final HashMap<String, BigDecimal> basket = new HashMap<>();
    private final Dispatcher dispatcher;

    private volatile boolean setBuyerPaid = false;

    public Buyer(String name, Dispatcher dispatcher) {
        this.name = name;
        this.dispatcher = dispatcher;
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
    }

    @Override
    public void toGetInLine() {
        dispatcher.getQueueBuyers().toGetInLine(this);
    }

    @Override
    public void leftTheStore() {
        System.out.println(this + " вышел из магазина.");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        putGoodsToBasket();
        toGetInLine();
        while (!setBuyerPaid) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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

    public void setSetBuyerPaid(boolean setBuyerPaid) {
        this.setBuyerPaid = setBuyerPaid;
    }
}