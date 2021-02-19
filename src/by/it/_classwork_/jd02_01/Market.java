package by.it._classwork_.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        List<Buyer> buyers = new ArrayList<>();
        System.out.println("Market opened");
        int numberBuyer = 0;
        for (int timeInSecond = 0; timeInSecond < 120; timeInSecond++) {
            int n = Utils.random(2);
            for (int i = 0; i < n; i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyers.add(buyer);
                buyer.start();
            }
            Utils.timeout(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
    }
}
