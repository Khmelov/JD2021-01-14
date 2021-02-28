package by.it.abeseda.jd02_03;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {
 //       ExecutorService executor= Executors.newFixedThreadPool(2);

        QueueBuyers queueBuyers = new QueueBuyers();
        Dispatcher dispatcher = new Dispatcher();
        Market market = new Market(dispatcher, queueBuyers);
        market.start();
    }
}
