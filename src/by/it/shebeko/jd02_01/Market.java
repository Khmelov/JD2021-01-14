package by.it.shebeko.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        int buyerNumber = 0;
        System.out.println("Market is opened");
        List<Buyers> buyers = new ArrayList<>();
        for (int second = 0; second < 100; second++) {
            int count = Helper.getRandom(2);
            for (int i = 0; i < count; i++) {
                Buyers buyer = new Buyers(++buyerNumber);
                buyer.start();
                buyers.add(buyer);
            }
            Helper.timeout(1000);
        }
        for (Buyers buyer : buyers){
            try {
                buyer.join();
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        }
        System.out.println("Market is closed");
    }
}
