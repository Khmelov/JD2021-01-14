package by.it.vesniachok.jd02_03;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {


        QueueBuyers queueBuyers = new QueueBuyers();
        Dispatcher dispatcher = new Dispatcher();
        Market market = new Market(dispatcher, queueBuyers);
        market.start();
    }
}