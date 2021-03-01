package by.it.voitenkov.jd02_02.tasks.c;

import java.math.BigDecimal;
import java.util.*;

public class Cashier implements Runnable {
    private int name = 0;
    private final Dispatcher dispatcher;

    private Deque<Buyer> listOfByersInTheQueue = new ArrayDeque<>();// СПИСОК В ОЧЕРЕДИ

    public Cashier(int name, Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.name = name;
    }

    public void openCashier() {
        System.out.print(this + " открылась.");
    }

    public synchronized void countThePurchaseAmount(Deque<Buyer> listOfByersInTheQueue) throws InterruptedException {
        synchronized (System.out) {
            printCashier(this);
            openCashier();
            printCurrentQueueSize(this);
            Set<Map.Entry<String, BigDecimal>> entries = dispatcher.getStore().getProductsList().entrySet();
            for (Map.Entry<String, BigDecimal> entry : entries) {
                printCashier(this);
                System.out.printf("Товар - %-7s Сумма - %s \n", entry.getKey(), entry.getValue());
            }
            BigDecimal checkAmount = new BigDecimal("0.00");
            for (Buyer buyer : listOfByersInTheQueue) {
                BigDecimal purchaseAmount = new BigDecimal("0.00");
                Set<Map.Entry<String, BigDecimal>> productList = buyer.getBasket().entrySet();
                printCashier(this);
                System.out.println(buyer.toString() + " купил: ");
                for (Map.Entry<String, BigDecimal> product : productList) {
                    purchaseAmount = purchaseAmount.add(product.getValue());
                    printCashier(this);
                    System.out.println("Продукт-" + product.getKey() + " на сумму " + product.getValue());
                }
                long timeOperationLong = (long) ((new Random().nextDouble() * (5 - 1)) + 2);
                Thread.sleep((timeOperationLong * 1000) / Time.SPEED_UP_STORE_OPENING_HOURS);
                printCashier(this);
                System.out.print("Сумма " + buyer.toString() + " = " + purchaseAmount + "\n");
                checkAmount = checkAmount.add(purchaseAmount);
                synchronized (buyer) {
                    buyer.setWaiting(true);
                    buyer.notify();
                }
            }
            dispatcher.getStore().setStoreRevenue(dispatcher.getStore().getStoreRevenue().add(checkAmount));
            printCashier(this);
            System.out.print("Сумма чека кассы = " + checkAmount);
            printCurrentProceeds(this);
            printCashier(this);
            closeCheckout();
            System.out.println();

        }
    }

    public void printCashier(Cashier cashier) {
        if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(0).getName()) {
        } else if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(1).getName()) {
            System.out.printf("%-35s", "");
        } else if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(2).getName()) {
            System.out.printf("%-70s", "");
        } else if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(3).getName()) {
            System.out.printf("%-105s", "");
        } else if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(4).getName()) {
            System.out.printf("%-140s", "");
        }

    }

    public void printCurrentQueueSize(Cashier cashier) {
        if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(0).getName()) {
            System.out.printf("%175s %s\n", "Текущий размер очереди", dispatcher.getStore().getWentTheStore() - dispatcher.getStore().getLeftTheStore());
        } else if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(1).getName()) {
            System.out.printf("%140s %s\n", "Текущий размер очереди", dispatcher.getStore().getWentTheStore() - dispatcher.getStore().getLeftTheStore());
        } else if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(2).getName()) {
            System.out.printf("%105s %s\n", "Текущий размер очереди", dispatcher.getStore().getWentTheStore() - dispatcher.getStore().getLeftTheStore());
        } else if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(3).getName()) {
            System.out.printf("%70s %s\n", "Текущий размер очереди", dispatcher.getStore().getWentTheStore() - dispatcher.getStore().getLeftTheStore());
        } else if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(4).getName()) {
            System.out.printf("%35s %s\n", "Текущий размер очереди", dispatcher.getStore().getWentTheStore() - dispatcher.getStore().getLeftTheStore());
        }
    }

    public void printCurrentProceeds(Cashier cashier) {
        if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(0).getName()) {
            System.out.printf("%210s %s\n", "Текущая выручка", dispatcher.getStore().getStoreRevenue());
        } else if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(1).getName()) {
            System.out.printf("%175s %s\n", "Текущая выручка", dispatcher.getStore().getStoreRevenue());
        } else if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(2).getName()) {
            System.out.printf("%140s %s\n", "Текущая выручка", dispatcher.getStore().getStoreRevenue());
        } else if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(3).getName()) {
            System.out.printf("%105s %s\n", "Текущая выручка", dispatcher.getStore().getStoreRevenue());
        } else if (cashier.getName() == dispatcher.getQueueBuyers().getListCashiers().get(4).getName()) {
            System.out.printf("%70s %s\n", "Текущая выручка", dispatcher.getStore().getStoreRevenue());
        }
    }

    public void closeCheckout() {
        System.out.println(this + " закрылась.");
    }

    @Override
    public void run() {
        try {
            if (!listOfByersInTheQueue.isEmpty()) {
                countThePurchaseAmount(listOfByersInTheQueue);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Касса номер " + this.name;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public int getName() {
        return this.name;
    }

    public void setListOfByersInTheQueue(Deque<Buyer> listOfByersInTheQueue) {
        this.listOfByersInTheQueue = listOfByersInTheQueue;
    }
}