package by.it.zevalich.jd02_02;

import java.util.Objects;

public class Cashier implements Runnable{
    private final int number;

    public Cashier(int number){
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketIsClosed()){
            Shopper shopper = QueueShoppers.poll();
            if(Objects.nonNull(shopper)){
                System.out.println(this + "started service for " + shopper);
                int timeout = Utils.random(2000, 5000);
                Utils.timeout(timeout);
                synchronized (shopper.getMonitorWaiting()){
                    shopper.setWaitFlag(false);
                    shopper.notify();
                }
                System.out.println(this + "finished service for " + shopper);
            }else {
                Thread.onSpinWait();
            }
        }
        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return "Cashier №" + number + " ";
    }
}
