package by.it._classwork_.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        System.out.println("Market opened");
        int numberBuyer = 0;

        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            threads.add(threadCashier);
        }

        while (Dispatcher.marketOpened()) {
            int n = Utils.random(2);
            for (int i = 0; i < n && Dispatcher.marketOpened(); i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                threads.add(buyer);
                buyer.start();
            }
            Utils.timeout(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
    }
}
