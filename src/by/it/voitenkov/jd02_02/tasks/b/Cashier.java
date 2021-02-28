package by.it.voitenkov.jd02_02.tasks.b;

import by.it.abeseda.jd01_11.Person;
import by.it.voitenkov.lessons.lesson_jd01_01.SortingArray;

import java.math.BigDecimal;
import java.util.*;

public class Cashier implements Runnable {
    static int name = 0;
    private final Dispatcher dispatcher;
    private BigDecimal cashOnHand = new BigDecimal("0.00");
    private final HashMap<Object, BigDecimal> listItemsSold = new LinkedHashMap<>();
    private final List<Buyer> listOfByersInTheQueue = new ArrayList<>();// СПИСОК В ОЧЕРЕДИ

    public Cashier(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        name = name + 1;
    }

    public void openCashier() {
        System.out.println(this + " открылась.");
    }

    public void countThePurchaseAmount(Buyer buyer) throws InterruptedException {
        synchronized (this) {
            if (buyer != null) {
                System.out.println(buyer + " в кассе № " + this.getName());
                Set<Map.Entry<String, BigDecimal>> productList = buyer.getBasket().entrySet();
                BigDecimal purchaseAmount = new BigDecimal("0.00");
                for (Map.Entry<String, BigDecimal> product : productList) {
                    purchaseAmount = purchaseAmount.add(product.getValue());
                    System.out.println(buyer.toString() + " взял " + product.getKey() + " на сумму " + product.getValue());
                }
                cashOnHand = cashOnHand.add(purchaseAmount);
                listItemsSold.put(buyer, purchaseAmount);
                long timeOperationLong = (long) ((new Random().nextDouble() * (5 - 1)) + 2);
                System.out.println(this
                        + ". Сумма покупки " + buyer.toString() + " = "
                        + purchaseAmount + ". Время нахождения в кассе = "
                        + timeOperationLong + " сек.");
                Thread.sleep((timeOperationLong * 1000) / Time.SPEED_UP_STORE_OPENING_HOURS);
                buyer.setSetBuyerPaid(true);
            }
        }
    }

    public void closeCheckout() {
        System.out.println(this + " закрылась.");
    }

    @Override
    public void run() {
        openCashier();
        for (Buyer buyer : listOfByersInTheQueue) {
            try {
                countThePurchaseAmount(buyer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " сумма = " + cashOnHand);
        closeCheckout();
    }

    @Override
    public String toString() {
        return "Касса номер " + name;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public int getName() {
        return name;
    }

    public List<Buyer> getListOfByersInTheQueue() {
        return listOfByersInTheQueue;
    }
}