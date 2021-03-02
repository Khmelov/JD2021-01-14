package by.it.voitenkov.jd02_01.tasks.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class Buyer implements BuyerBehavior, BasketBehavior, Runnable {
    private final String name;

    public HashMap<String, Double> basket = new HashMap<>();

    public Buyer(String name) {
        this.name = name;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин.");
    }

    @Override
    public void chooseGoods() {
        try {
            double timeOperation = Time.getItemSelectionTime();
            Thread.sleep(timeOperationLong() / Time.SPEED_UP_STORE_OPENING_HOURS);
            System.out.printf("%s выбирал товар (%.2f секунд).\n", this, timeOperation);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leftTheStore() {
        System.out.println(this + " вышел из магазина.");
    }

    @Override
    public void takeBasket() {
        try {
            double timeOperation = Time.getItemSelectionTime();
            Thread.sleep(timeOperationLong() / Time.SPEED_UP_STORE_OPENING_HOURS);
            System.out.printf("%s взял корзину (%.2f секунд.)\n", this, timeOperation);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void putGoodsToBasket() {
        int id = 1;
        HashMap<Integer, String> listProductsId = new HashMap<>();
        // listProductsId заполняется key - id(number) value - название продукта
        Set<Map.Entry<String, Double>> entries = Store.getProductsList().entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            listProductsId.put(id++, entry.getKey());
        }
        //заполняем корзину случайными продуктами
        for (int i = 0; i < new Random().nextInt(4) + 1; i++) {
            chooseGoods();
            String randomProduct = listProductsId.get(new Random().nextInt(listProductsId.size()) + 1);
            double price = Store.getProductsList().get(randomProduct);

            if (basket.containsKey(randomProduct)) {
                basket.replace(randomProduct, basket.get(randomProduct) + Store.getProductsList().get(randomProduct));
            } else {
                basket.put(randomProduct, price);
            }

            try {
                double timeOperation = Time.getItemSelectionTime();
                Thread.sleep(timeOperationLong() / Time.SPEED_UP_STORE_OPENING_HOURS);
                System.out.printf("%s положил %s в корзину (%.2f секунд.)\n", this, randomProduct, timeOperation);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        putGoodsToBasket();
        leftTheStore();
        getListProductsSold();
    }

    public void getListProductsSold() {
        Set<Map.Entry<String, Double>> entries = basket.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            System.out.printf("Покупатель \"%s\" купил \"%s\" - цена:%.2f / кол-во:%d / сумму %.2f\n", this.name, entry.getKey(), Store.getProductsList().get(entry.getKey()),
                    (int) (entry.getValue() / Store.getProductsList().get(entry.getKey())), entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "Покупатель по имени " + this.name;
    }

    public String getName() {
        return name;
    }

    static long timeOperationLong() {
        return (long) (Time.getItemSelectionTime() * 1000);
    }
}