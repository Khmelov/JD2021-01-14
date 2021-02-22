package by.it.zevalich.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {
    static  int countShoppers = 0;

    public static void main(String[] args) throws InterruptedException{
        Queue<Shopper> queue = new ArrayDeque<>();
        while (countShoppers<10){
            Thread.sleep(100);
            int count = Rndm.fromTo(0,2);
            for (int i = 0; i <= count ; i++) {
                countShoppers++;
                if(countShoppers<11){
                    Shopper shopper = new Shopper(countShoppers);
                    queue.add(shopper);
                }
            }
        }
    }

}
