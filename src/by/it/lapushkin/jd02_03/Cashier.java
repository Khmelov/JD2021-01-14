package by.it.lapushkin.jd02_03;


import java.util.Objects;

public class Cashier implements Runnable {
    final Object MONITOR = new Object();
    private final int NUMBER;


    public Cashier(int number) {
        Monitoring.addCashier(this);
        this.NUMBER = number;
    }

    @Override
    public void run() {
        //cashierOpen();

        while (Monitoring.getCountCustomersInScore() != 0) {
            Person customer = QueueCustomers.poll();
            if (Objects.nonNull(customer)) {
                startServiceCustomer(customer);
                Helper.timeout(Helper.random(2000, 5000));

                try {
                    Reporter.setChecks(new Check(this, Manager.getCurrentTime(), customer));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (customer.getMonitorWaiting()) {
                    customer.setWaitFlag(false);
                    customer.notify();
                }
                QueueBasket.getDequeBasket().addLast(new Basket());
            }
            synchronized (MONITOR){
                if (Manager.isLimitCashiers()) {
                    break;
                }
            }
        }
        Monitoring.removeCashier(this);
        //cashierClose();
    }

    private void startServiceCustomer(Person customer) {
        System.out.println(this + "started service for " + customer);
    }

    private void cashierClose() {
        System.out.println(this + "is closed!");
    }

    private void cashierOpen() {
        System.out.println(this + "is open!");
    }

    @Override
    public String toString() {
        return "Cashier №" + NUMBER + " ";
    }

    public Object getMonitor() {
        return MONITOR;
    }
}
