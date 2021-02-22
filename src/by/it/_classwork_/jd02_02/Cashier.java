package by.it._classwork_.jd02_02;

import java.util.Objects;

public class  Cashier implements Runnable {

    private final int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketIsClosed()) {
            Buyer buyer = QueueBuyers.poll();
            if (Objects.nonNull(buyer)) {
                System.out.println(this + "started service for " + buyer);
                int timeout = Utils.random(2000, 5000);
                Utils.timeout(timeout);
                synchronized (buyer.getMonitorWaiting()) {
                    buyer.setWaitFlag(false);
                    buyer.notify();
                }
                System.out.println(this + "finished service for " + buyer);
            } else {

                //нет покупателей в очереди
                // тут подумайте как сделать так чтобы кассир ожидал (но не завис в конце работы)
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
