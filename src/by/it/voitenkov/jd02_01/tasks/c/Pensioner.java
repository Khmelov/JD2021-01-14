package by.it.voitenkov.jd02_01.tasks.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Pensioner extends Buyer {

    public Pensioner(String name) {
        super(name);
    }

    @Override
    public void chooseGoods() {
        try {
            double timeOperation = timeOperationDouble();
            Thread.sleep(timeOperationLong(timeOperation) / Time.SPEED_UP_STORE_OPENING_HOURS);
            System.out.printf("%s выбирал товар (%.2f секунд).\n", this, timeOperation);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void takeBasket() {
        try {
            double timeOperation = timeOperationDouble();
            Thread.sleep(timeOperationLong(timeOperation) / Time.SPEED_UP_STORE_OPENING_HOURS);
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
                double timeOperation = timeOperationDouble();
                Thread.sleep(timeOperationLong(timeOperation) / Time.SPEED_UP_STORE_OPENING_HOURS);
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

    @Override
    public String toString() {
        return "Покупатель (пенсионер) по имени " + super.getName();
    }

    static double timeOperationDouble() {
        return (Time.getItemSelectionTime()
                * (Math.random() * 1.5 * 2));
    }

    static long timeOperationLong(double averageTimeDilationFactor) {
        return (long) ((Time.getItemSelectionTime() * 1000
                * (Math.random() * averageTimeDilationFactor * 2)));
    }
}