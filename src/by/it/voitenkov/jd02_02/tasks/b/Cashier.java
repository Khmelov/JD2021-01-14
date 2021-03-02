package by.it.voitenkov.jd02_02.tasks.b;

import java.math.BigDecimal;
import java.util.*;

public class Cashier implements Runnable {
    private int name = 0;
    private final Dispatcher dispatcher;
    private BigDecimal cashOnHand = new BigDecimal("0.00");
    private final HashMap<Object, BigDecimal> listItemsSold = new LinkedHashMap<>();

    private Deque<Buyer> listOfByersInTheQueue = new ArrayDeque<>();// СПИСОК В ОЧЕРЕДИ

    public Cashier(int name, Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.name = name;
    }

    public void openCashier() {
        System.out.println(this + " открылась.");
    }

    public synchronized void countThePurchaseAmount(Deque<Buyer> listOfByersInTheQueue) throws InterruptedException {
        synchronized (System.out) {
            openCashier();
            Set<Map.Entry<String, BigDecimal>> entries = dispatcher.getStore().getProductsList().entrySet();
            for (Map.Entry<String, BigDecimal> entry : entries) {
                System.out.printf("Товар - %-10s Стоимость - %s \n", entry.getKey(), entry.getValue());
            }
            for (Buyer buyer : listOfByersInTheQueue) {
                Set<Map.Entry<String, BigDecimal>> productList = buyer.getBasket().entrySet();
                BigDecimal purchaseAmount = new BigDecimal("0.00");
                for (Map.Entry<String, BigDecimal> product : productList) {
                    purchaseAmount = purchaseAmount.add(product.getValue());
                }
                cashOnHand = cashOnHand.add(purchaseAmount);
                listItemsSold.put(buyer, purchaseAmount);
                long timeOperationLong = (long) ((new Random().nextDouble() * (5 - 1)) + 2);
                System.out.println(buyer.toString() + " сумма покупки" + " = " + purchaseAmount);
                Thread.sleep((timeOperationLong * 1000) / Time.SPEED_UP_STORE_OPENING_HOURS);
                buyer.setSetBuyerPaid(true);

            }
            closeCheckout();
            System.out.println();
        }
    }

    public void closeCheckout() {
        System.out.println(this + " закрылась.");
    }

    @Override
    public void run() {
        try {
            countThePurchaseAmount(listOfByersInTheQueue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public void setListOfByersInTheQueue(Deque<Buyer> listOfByersInTheQueue) {
        this.listOfByersInTheQueue = listOfByersInTheQueue;
    }
}