package by.it.petrov.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int speedCoefficient = 50;
        Timer timer = new Timer(120, speedCoefficient);
        Deque paymentsDeque = new Deque();
        int setCashiersCount = 1;
        ExecutorService executors = Executors.newFixedThreadPool(setCashiersCount);

        for (int i = 0; i < setCashiersCount; i++) {
            executors.execute(new Cashier("Cashier #"
                    + (Cashier.getInitialNumberOfCashiers() + 1), speedCoefficient, timer));
            System.out.println("Cashier has been created through 'execute'");
        }

        int setBuyersCount = 1;
        ExecutorService executorsBuy = Executors.newFixedThreadPool(setBuyersCount);
        for (int i = 0; i < setBuyersCount; i++) {
            System.out.println("Number " + (i + 1) + " has been created through 'execute'");
            executorsBuy.execute(new Buyer("Number" + (i + 1)));
        }
    }
}