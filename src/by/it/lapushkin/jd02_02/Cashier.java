package by.it.lapushkin.jd02_02;

import java.util.Map;
import java.util.Objects;

public class Cashier implements Runnable {
    static final Object MONITOR = new Object();
    private final int NUMBER;

    public Cashier(int number) {
        Monitoring.addCashier(this);
        this.NUMBER = number;
    }

    @Override
    public void run() {
        cashierOpen();

        while (Monitoring.getCountCustomersInScore() != 0) {
            Person customer = QueueCustomers.poll();
            if (Objects.nonNull(customer)) {
                startServiceCustomer(customer);
                Helper.timeout(Helper.random(2000, 5000));

                synchronized (MONITOR) {
                    printCheck(customer);
                }


                synchronized (customer.getMonitorWaiting()) {
                    customer.setWaitFlag(false);
                    customer.notify();
                }
            }
            if (Manager.isLimitCashiers()) {
                break;
            }
        }
        Monitoring.removeCashier(this);
        cashierClose();
    }

    private void printCheck(Person customer) {
        String tr = "\n";
        String separatorLine = "#".repeat(50) + tr;
        StringBuilder sb = new StringBuilder();
        sb.append(tr).append(separatorLine);
        sb.append(strFormat(" Time : " + Manager.getCurrentTime())).append(separatorLine);
        sb.append(strFormat(" Check for : " + customer)).append(separatorLine);
        sb.append(strFormat(" Cashier : " + this));
        sb.append(strFormat(" Cashier in work : " + Monitoring.getCountOpenCashier())).append(separatorLine);

        int sum = 0;
        for (Map.Entry<String, Integer> entry : customer.getProductInBasket().entrySet()) {
            sb.append(strFormat(" " + entry.getKey() + " price : " + entry.getValue() + " $"));
            sum += entry.getValue();
        }
        Bank.increaseRevenue(sum);

        sb.append(strFormat(" Total coast : " + sum + " $")).append(separatorLine);
        sb.append(strFormat(" Current queue : " + QueueCustomers.getLengthAllQueue())).append(separatorLine);
        sb.append(strFormat(" Revenue : " + Bank.getRevenue() + " $")).append(separatorLine);
        System.out.println(sb);
    }

    private String strFormat(String string) {
        String min = "#".repeat(10);
        return String.format("%s%-30s%s%n", min, string, min);
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
}
