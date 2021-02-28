package by.it.nakhankov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        System.out.println("Market opened");
        int numberCustomer = 0;
        for (int timeInSecond = 0; timeInSecond < 70; timeInSecond++) {
            int n = Utils.random(2);
            for (int i = 0; i < n; i++) {
                Customer customer = new Customer(++numberCustomer);
                customers.add(customer);
                customer.start();
            }
            Utils.timeout(1000);
        }
        for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
    }
}
