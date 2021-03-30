package by.it.vesniachok.jd02_02;

import java.util.Objects;

public class Cashier implements Runnable{

    private final int number;
    int timeout = Generator.GeneratorRandom(2000, 5000);
    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        while (!Dispatcher.marketIsClosed()) {
            Buyer buyerin = OneQueueBuyers.poll();
            if (Objects.nonNull(buyerin)) {

                System.out.println(this + " started service for " + buyerin);
                Generator.timeout(timeout);
                synchronized (buyerin.getMonitorWaiting()) {
                    buyerin.setWaitFlag(false);
                    buyerin.notify();
                }
                System.out.println(this+" finished service for " + buyerin);
            } else {
                System.out.println(this+" is waiting.No buyers in queue.");
                Generator.timeout(timeout);
            }
            }
        System.out.println(this + " closed");
        }

    @Override
    public String toString() {
        return "-- Cashier "+this.number;
    }
}