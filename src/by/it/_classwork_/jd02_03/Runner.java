package by.it._classwork_.jd02_03;

public class Runner {
    public static void main(String[] args) {
        QueueBuyers queueBuyers = new QueueBuyers();
        Dispatcher dispatcher = new Dispatcher();
        Market market = new Market(dispatcher, queueBuyers);
        market.start();
    }
}
