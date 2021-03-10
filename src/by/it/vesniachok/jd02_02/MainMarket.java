package by.it.vesniachok.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class MainMarket {

    public static void main(String[] args) {
        System.out.println("Market opened");
        int numberBuyer = 0;
        //для всех потоков есть коллекция (избавимся от нее на следующем занятии)
        List<Thread> threads = new ArrayList<>();

        //создаем и запускаем двух кассиров
        for (int numberCashier=1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            threads.add(threadCashier);
        }

        //теперь создаем и впускам покупателей пока их не будет создано ровно 100
        while (Dispatcher.marketIsOpened()) {
            int n = Generator.GeneratorRandom(0,2);
            //тут важно проверить нужны ли новые покупатели, если их получилось 2 то можно впустить лишнего
            for (int i = 0; i < n && Dispatcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
                threads.add(buyer);

            }
            //ждем одну секунду
            Generator.timeout(1000);
        }














        //осталось дождаться завершения всех потоков
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