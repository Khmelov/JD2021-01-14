package by.it.vesniachok.jd02_01;

import java.util.ArrayList;
import java.util.List;


public class MarketMain1 {
    public static void main(String[] args) {
        List<Buyer> buyers = new ArrayList<>();
        System.out.println("Market has opened right now.");
        int numberBuyer = 0;
        for (int timeInSecond = 0; timeInSecond < 120; timeInSecond++) {
            int n = Ut.GenRandom(0, 2);
            for (int i = 0; i < n; i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyers.add(buyer);
                buyer.start();
            }
            Ut.timeout(1000);

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

