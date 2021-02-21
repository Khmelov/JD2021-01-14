package by.it.lapushkin.jd02_02;

import java.util.Map;
import java.util.Objects;

public class Cashier implements Runnable {
    private final int NUMBER;
    static final Object MONITOR = new Object();

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
            if (Manager.isManyCashiers()){
                break;
            }
        }
        Monitoring.removeCashier(this);
        cashierClose();
    }

    private void printCheck(Person customer) {
        String min = "#".repeat(10);
        String max = "#".repeat(50);
        String tr ="\n";
        StringBuilder sb = new StringBuilder();
        sb.append(tr);
        sb.append(max).append(tr);
        sb.append(String.format("%s%-30s%s\n",min," Time : "+ Manager.getCurrentTime(),min));
        sb.append(max).append(tr);
        sb.append(String.format("%s%-30s%s\n",min," Check for : "+ customer,min));
        sb.append(max).append(tr);
        sb.append(String.format("%s%-30s%s\n",min," Cashier : "+this,min));
        sb.append(String.format("%s%-30s%s\n",min," Cashier in work : "+Monitoring.getCountOpenCashier(),min));
        sb.append(max).append(tr);

        int sum = 0;
        for (Map.Entry<String, Integer> entry : customer.getProductInBasket().entrySet()) {
            sb.append(String.format("%s%-30s%s\n",min," "+entry.getKey()+" price : "+entry.getValue()+" $",min));
            sum += entry.getValue();
        }

        Bank.increaseRevenue(sum);
        sb.append(String.format("%s%-30s%s\n",min," Total coast : "+sum+" $",min));
        sb.append(max).append(tr);
        sb.append(String.format("%s%-30s%s\n",min," Current queue : "+QueueCustomers.getLengthCustomerDeque(),min));
        sb.append(max).append(tr);
        sb.append(String.format("%s%-30s%s\n",min," Revenue : "+Bank.getRevenue()+" $",min));
        sb.append(max).append(tr);
        System.out.println(sb);
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
