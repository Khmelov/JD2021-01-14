package by.it.voitenkov.jd02_02.tasks.b;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Pensioner extends Buyer {

    public Pensioner(String name, Dispatcher dispatcher) {
        super(name, dispatcher);
    }

    @Override
    public void chooseGoods() {
        try {
            double timeOperation = timeOperationDouble();
            Thread.sleep(timeOperationLong(timeOperation) / Time.SPEED_UP_STORE_OPENING_HOURS);
//            System.out.printf("%s выбирал товар (%.2f секунд).\n", this, timeOperation);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void takeBasket() {
        try {
            double timeOperation = timeOperationDouble();
            Thread.sleep(timeOperationLong(timeOperation) / Time.SPEED_UP_STORE_OPENING_HOURS);
//            System.out.printf("%s взял корзину (%.2f секунд.)\n", this, timeOperation);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putGoodsToBasket() {
        int id = 1;
        HashMap<Integer, String> listProductsId = new HashMap<>();
        Set<Map.Entry<String, BigDecimal>> entries = super.getDispatcher().getStore().getProductsList().entrySet();
        for (Map.Entry<String, BigDecimal> entry : entries) {
            listProductsId.put(id++, entry.getKey());
        }
        //заполняем корзину случайными продуктами
        for (int i = 0; i < new Random().nextInt(4) + 1; i++) {
            chooseGoods();
            String randomProduct = listProductsId.get(new Random().nextInt(listProductsId.size()) + 1);
            BigDecimal price = super.getDispatcher().getStore().getProductsList().get(randomProduct);

            if (getBasket().containsKey(randomProduct)) {
                getBasket().replace(randomProduct, getBasket().get(randomProduct).add(super.getDispatcher().getStore().getProductsList().get(randomProduct)));
            } else {
                getBasket().put(randomProduct, price);
            }

            try {
                double timeOperation = timeOperationDouble();
                Thread.sleep(timeOperationLong(timeOperation) / Time.SPEED_UP_STORE_OPENING_HOURS);
//                System.out.printf("%s положил %s в корзину (%.2f секунд.)\n", this, randomProduct, timeOperation);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return "Покупатель (пенсионер) № " + this.getName();
    }

    static double timeOperationDouble() {
        return (Time.getItemSelectionTime()
                * new Random().nextInt(3) + 1);
    }

    static long timeOperationLong(double averageTimeDilationFactor) {
        return (long) ((Time.getItemSelectionTime() * 1000
                * (Math.random() * averageTimeDilationFactor * 2)));
    }
}