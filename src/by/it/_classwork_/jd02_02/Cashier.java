package by.it._classwork_.jd02_02;

import java.util.Objects;

public class Cashier implements Runnable {
    private int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketClosed()) {
            Buyer buyer = QueueBuyers.poll();
            if (Objects.nonNull(buyer)) {
                System.out.println(this + "started service for " + buyer);
                int timeout = Utils.random(2000, 5000);
                Utils.timeout(timeout);
                synchronized (buyer.getMonitor()) {
                    buyer.setiWaiting(false);
                    buyer.notify();
                }
                System.out.println(this + "finished service for " + buyer);
            } else {
                // waiting ????
                Thread.onSpinWait();
            }
        }

        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return "-- Cashier №" + number + " ";
    }
}
