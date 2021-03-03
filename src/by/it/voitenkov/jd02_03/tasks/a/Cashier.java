package by.it.voitenkov.jd02_03.tasks.a;

import java.math.BigDecimal;
import java.util.*;

public class Cashier implements Runnable {
    private final int name;
    private final Dispatcher dispatcher;
    private BigDecimal cashOnHand = new BigDecimal("0.00");
    HashMap<Object, BigDecimal> listItemsSold = new LinkedHashMap<>();

    public Cashier(int name, Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.name = name;
    }

    public void openCashier() {
        System.out.println(this + " открылась.");
    }

    public void countThePurchaseAmount(Buyer buyer) throws InterruptedException {
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
            System.out.println("Сумма покупки " + buyer.toString() + " = " + purchaseAmount + ". Время нахождения в кассе = " + timeOperationLong + "сек.");
            Thread.sleep((timeOperationLong * 1000) / Time.SPEED_UP_STORE_OPENING_HOURS);
        }
    }

    public void closeCheckout() {
        System.out.println(this + " закрылась.");
    }

    @Override
    public void run() {
        openCashier();
        while (dispatcher.getStore().isStoreOpen()) {
            try {
                Buyer buyer = dispatcher.getQueueBuyers().pollFirst();
                if (Objects.nonNull(buyer)) {
                    countThePurchaseAmount(buyer);
                    synchronized (buyer.getMonitorWaiting()) {
                        buyer.setWaitFlag(false);
                        buyer.notify();
                    }
                } else {
                    Thread.yield();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " сумма = " + cashOnHand);
        dispatcher.threadsCashiers.shutdown();
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
}