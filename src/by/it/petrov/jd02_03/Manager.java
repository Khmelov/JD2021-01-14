package by.it.petrov.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    public static AtomicInteger currentVisitorsCountInTheShop = new AtomicInteger(0);
    public static AtomicInteger totalVisitorsCount = new AtomicInteger(0);
    public static AtomicInteger totalVisitorsServedCount = new AtomicInteger(0);
    public static AtomicInteger totalVisitorsInHallCount = new AtomicInteger(0);
    public static AtomicInteger totalVisitorsBehindTheDoors = new AtomicInteger(0);

    public static Integer determineNumberOfCashiersNeeded() {
        if (Deque.currentCustomersInDeque() == 0) {
            return 0;
        } else if (Deque.currentCustomersInDeque() >= 21) {
            return 5;
        } else return (Deque.currentCustomersInDeque() / 5) + 1;
    }

    public static void generateBuyers(ExecutorService executorsBuy, Semaphore hallSem, Semaphore queueSem, Semaphore backetSem) {

        if (Timer.getSecondsPassed() < 30 && currentVisitorsCountInTheShop.get() < Timer.getSecondsPassed() + 10) {
            for (int i = 0; i < 1; i++) {
                executorsBuy.execute(new Buyer(("Visitor number " + (totalVisitorsCount.get() + 1)),hallSem, queueSem, backetSem));
                System.out.println("Number " + Manager.totalVisitorsCount + " has been created through 'execute'");
                try {
                    Thread.sleep(100 / Timer.getSpeedCoefficient());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (Timer.getSecondsPassed() < 30 && currentVisitorsCountInTheShop.get() >= Timer.getSecondsPassed() + 10) {
            System.out.println("Too many customers ... (max: " + (Timer.getSecondsPassed() + 10) + ") (current: "
                    + currentVisitorsCountInTheShop);
            try {
                Thread.sleep(2000 / Timer.getSpeedCoefficient());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (Timer.getSecondsPassed() >= 30 && currentVisitorsCountInTheShop.get() <= 40 + (30 - Timer.getSecondsPassed())) {
            for (int i = 0; i < 1; i++) {
                executorsBuy.execute(new Buyer(("Visitor number " + (totalVisitorsCount.get() + 1)),hallSem, queueSem, backetSem));
                System.out.println("Number " + Manager.totalVisitorsCount + " has been created through 'execute'");
                try {
                    Thread.sleep(100 / Timer.getSpeedCoefficient());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (Timer.getSecondsPassed() >= 30 && currentVisitorsCountInTheShop.get() > 40 + (30 - Timer.getSecondsPassed())) {
            System.out.println("Too many customers ... (max: " + (Timer.getSecondsPassed() + 10) +
                    ") (current: " + currentVisitorsCountInTheShop);
            try {
                Thread.sleep(2000 / Timer.getSpeedCoefficient());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void generateCashiers(ExecutorService executorsCash, Timer timer, int speedCoefficient) {
        if(Cashier.getInitialNumberOfCashiers() < 5){
            Integer numberOfCashiersNeeded = determineNumberOfCashiersNeeded();
            Integer currentNumberOfCashiers = Cashier.getCurrentNumberOfCashiers();
            if (currentNumberOfCashiers < numberOfCashiersNeeded) {
                synchronized (System.out) {
                    System.out.println("----------------------------");
                    System.out.println("Current cashiers count: " + currentNumberOfCashiers);
                    System.out.println("Cashiers needed:        " + numberOfCashiersNeeded);
                    System.out.println("Total queue size:       " + Deque.currentCustomersInDeque());
                    System.out.println("----------------------------");
                }
                for (int i = 0; i < numberOfCashiersNeeded - Cashier.getCurrentNumberOfCashiers(); i++) {
                    executorsCash.execute(new Cashier("Cashier #"
                            + (Cashier.getInitialNumberOfCashiers() + 1), speedCoefficient, timer));
                    try {
                        Thread.sleep(1000 / Timer.getSpeedCoefficient());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}