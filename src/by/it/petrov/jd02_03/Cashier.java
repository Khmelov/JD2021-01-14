package by.it.petrov.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Cashier extends Thread implements ICashier {

    private static AtomicInteger marketsProfit = new AtomicInteger(0);
    private static volatile Map<String, Integer> cashiersProfit = new HashMap<>(Map.of(
            "Cashier #1", 0,
            "Cashier #2", 0,
            "Cashier #3", 0,
            "Cashier #4", 0,
            "Cashier #5", 0
    ));

    private final String CASHIERS_NAME;
    private final Integer SPEED_COEFFICIENT;
    private static ArrayList<Cashier> cashiersDeque = new ArrayList<>();
    private static ArrayList<Cashier> initialCashiersList = new ArrayList<>();
    private final Timer TIMER_TO_LIVE;

    public Cashier(String cashiers_name, Integer speed_coefficient, Timer timer) {
        super(cashiers_name);
        this.TIMER_TO_LIVE = timer;
        this.CASHIERS_NAME = cashiers_name;
        this.SPEED_COEFFICIENT = speed_coefficient;
        synchronized (Cashier.class) {
            initialCashiersList.add(this);
        }
        synchronized (Cashier.class) {
            cashiersDeque.add(this);
        }
        System.out.println(this.CASHIERS_NAME + " has been opened! (created)");
        start();
    }


    public static void addMarketsProfit(Integer totalProfit) {
        marketsProfit.getAndAdd(totalProfit);
    }

    public static Integer getMarketsProfit() {
        return marketsProfit.get();
    }

    public static void addCashiersProfit(String cashiersName, Integer totalProfit) {
        synchronized (Cashier.class) {
            cashiersProfit.put(cashiersName, cashiersProfit.get(cashiersName) + totalProfit);
        }
        System.out.println(cashiersName + " profit is " + getCashiersProfit(cashiersName));
    }

    public static Integer getCashiersProfit(String cashiersName) {
        return cashiersProfit.get(cashiersName);
    }

    public static Integer getCurrentNumberOfCashiers() {
        return cashiersDeque.size();
    }

    public static Integer getInitialNumberOfCashiers() {
        return initialCashiersList.size();
    }

    @Override
    public void run() {
        meetTheClientAtCheckoutCounter();
    }

    @Override
    public void meetTheClientAtCheckoutCounter() {
        Buyer buyer;
        while (TIMER_TO_LIVE.isAlive() || (Manager.totalVisitorsCount.get() < Manager.totalVisitorsServedCount.get())) {
            if ((buyer = Deque.poll()) != null) {
                System.out.println(this.CASHIERS_NAME + ": Please, come here " + buyer.getBuyersName());
                try {
                    Thread.sleep(4250 / Timer.getSpeedCoefficient());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                calculatePurchases(buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
                continue;
            }

            cashiersDeque.remove(this);
            if (!TIMER_TO_LIVE.isAlive()) {
                synchronized (System.out) {
                    System.out.println("--------------------------------------------------------------------------------------------");
                    System.out.printf("||%-11s||%-11s||%-11s||%-11s||%-11s||%-11s||%-11s%n", "Cashier#1", "Cashier#2",
                            "Cashier#3", "Cashier#4", "Cashier#5", "Queue size", "Total profit");
                    System.out.printf("||%-11s||%-11s||%-11s||%-11s||%-11s||%-11s||%-11s%n",
                            Cashier.getCashiersProfit("Cashier #1"), Cashier.getCashiersProfit("Cashier #2"),
                            Cashier.getCashiersProfit("Cashier #3"), Cashier.getCashiersProfit("Cashier #4"),
                            Cashier.getCashiersProfit("Cashier #5"), Deque.currentCustomersInDeque(),
                            Cashier.getMarketsProfit());

                    System.out.println("--------------------------------------------------------------------------------------------");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(this.CASHIERS_NAME + " HAS BEEN CLOSED (AND GONE HOME)");
    }

    @Override
    public void calculatePurchases(Buyer buyer) {
        ArrayList<String> purchasedProducts = buyer.getProductList();
        Integer totalCount = 0;
        synchronized (System.out) {
            System.out.println();
            System.out.println("******** BILL ********");
            System.out.printf("%-4s%-10s%n", "Cm.#", buyer.getBuyersName());
            for (int i = 0; i < purchasedProducts.size(); i++) {
                System.out.printf("%-13s%-6s%-10s%n", purchasedProducts.get(i),
                        "...", buyer.getGoodsList().get(purchasedProducts.get(i)));
                totalCount += buyer.getGoodsList().get(purchasedProducts.get(i));
            }
            System.out.println("----------------------");
            System.out.printf("%-19s%-10s%n", "Total:", totalCount);
            System.out.printf("%-19s%-10s%n", "Customers served:", Manager.totalVisitorsServedCount.get());
            System.out.printf("%-19s%-10s%n", "Total customers:", Manager.totalVisitorsCount.get());
            System.out.println("----------------------");
            System.out.println();
            addCashiersProfit(this.CASHIERS_NAME, totalCount);
            addMarketsProfit(totalCount);
        }
    }
}