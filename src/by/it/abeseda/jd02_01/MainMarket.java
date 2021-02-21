package by.it.abeseda.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class MainMarket {

    static int countBuyer = 0;

    public static void main(String[] args) {

        System.out.println("Market has opened right now.");

        List<Buyer> buyers=new ArrayList<>();

        for (int sec = 0; sec < 120; sec++) {

            int n = Generator.GeneratorRandom(0,2);
            for (int i = 0; i < n; i++) {

                Buyer buyer;
                if(countBuyer%4==0){
                    buyer = new Buyer(++countBuyer, true);
                }
                else{
                    buyer = new Buyer(++countBuyer);
                }
                buyers.add(buyer);
                buyer.start();

//если поместить сюда join, то пока покупатели n-количества не завершат свои покупки и не уйдет
       //         следующий покупатель ждет еще 1 сек и только тогда заходит
            }
            Generator.timeout(1000);
            //если поместить сюда join, то покупатели n-количества будет проводить ровно 1 сек в магазине,выходить,
            // а затем будет заходить следующий
        }

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market has closed right now.");//сигнал о завершении main

//        for (Buyer buyer : buyers) {
//            System.out.println(buyer);
//        }
    }
}
