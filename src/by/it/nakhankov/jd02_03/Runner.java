package by.it.nakhankov.jd02_03;

public class Runner {
    public static void main(String[] args) {
        QueueCustomers queueCustomers = new QueueCustomers();
        Dispatcher dispatcher = new Dispatcher();
        Market market = new Market(dispatcher, queueCustomers);
        market.start();
    }
}
