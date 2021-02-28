package by.it.petrov.jd02_03;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    public static AtomicInteger currentVisitorsCountInTheShop = new AtomicInteger(0);
    public static AtomicInteger totalVisitorsCount = new AtomicInteger(0);
    public static AtomicInteger totalVisitorsServedCount = new AtomicInteger(0);

    public static Integer determineNumberOfCashiersNeeded(Integer currentCustomersInDeque) {
        if (Deque.currentCustomersInDeque() == 0) {
            return 0;
        } else if (Deque.currentCustomersInDeque() >= 21) {
            return 5;
        } else return (Deque.currentCustomersInDeque() / 5) + 1;
    }

    public static void generateBuyers() {

        if (Timer.getSecondsPassed() < 30 && currentVisitorsCountInTheShop.get() < Timer.getSecondsPassed() + 10) {
            for (int i = 0; i < 1; i++) {
                Buyer buyer = new Buyer(("Visitor number " + (totalVisitorsCount.get() + 1)));
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
                Buyer buyer = new Buyer(("Visitor number " + (totalVisitorsCount.get() + 1)));
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

    public static void generateCashiers(Timer timer, int speedCoefficient) {

        Integer numberOfCashiersNeeded = determineNumberOfCashiersNeeded(currentVisitorsCountInTheShop.get());
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
                Cashier cashier = new Cashier("Cashier #"
                        + (Cashier.getCurrentNumberOfCashiers() + 1), speedCoefficient, timer);
                try {
                    Thread.sleep(1000 / Timer.getSpeedCoefficient());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void generateCashiersSemaphore(Timer timer, int speedCoefficient, int semaphoreCount) {
        Semaphore sm = new Semaphore(semaphoreCount);

        Integer numberOfCashiersNeeded = determineNumberOfCashiersNeeded(currentVisitorsCountInTheShop.get());
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
                Cashier cashier = new Cashier("Cashier #"
                        + (Cashier.getCurrentNumberOfCashiers() + 1), speedCoefficient, timer);
                try {
                    Thread.sleep(1000 / Timer.getSpeedCoefficient());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}