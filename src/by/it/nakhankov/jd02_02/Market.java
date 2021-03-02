package by.it.nakhankov.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        System.out.println("Market opened");
        int numberCustomer = 0;
        List<Thread> threads = new ArrayList<>();

        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            threads.add(threadCashier);
        }

        while (Dispatcher.marketIsOpened()) {
            int n = Utils.random(2);
            for (int i = 0; i < n && Dispatcher.marketIsOpened(); i++) {
                Customer customer = new Customer(++numberCustomer);
                threads.add(customer);
                customer.start();
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
