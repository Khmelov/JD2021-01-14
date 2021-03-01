package by.it.lapushkin.jd02_03;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Reporter {
    private static TransferQueue<Check> checks = new LinkedTransferQueue<>();

    public static int getSizeDeque() {
        return checks.size();
    }

    public static void report() {
        int cahiers = Monitoring.getCountOpenCashier();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbTime = new StringBuilder();
        StringBuilder sbCheckFor = new StringBuilder();
        StringBuilder sbCahier = new StringBuilder();
        StringBuilder sbTotal = new StringBuilder();
        String[] strings = new String[4];
        Arrays.fill(strings, "");

        String tr = "\n";
        int n = 40*(cahiers+1);
        String separatorLine = "#".repeat(n) + tr;

        sb.append(tr).append(separatorLine);
        for (int i = 0; i < cahiers; i++) {
            Check check = null;
            try {
                if (!checks.isEmpty()){
                    check = checks.take();
                }else {
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sbTime.append(strFormat(" Time : " + check.time));
            sbCheckFor.append(strFormat(" Check for : " + check.customer));
            sbCahier.append(strFormat(" Cashier   : " + check.cashier));
            int count = 0;
            int totalPrise = 0;
            for (Map.Entry<String, Integer> entry : check.customer.getBasket().getBasket().entrySet()) {
                totalPrise += entry.getValue();
                strings[count] += (strFormat(" " + entry.getKey() + " price : " + entry.getValue() + " $"));
                count++;
            }
            while (count != 4){
                strings[count++]+=strFormat("");
            }
            Bank.increaseRevenue(totalPrise);
            sbTotal.append(strFormat(" Total coast : " + totalPrise + " $"));
        }
        String stub = strFormat("");

        sb.append(sbTime).append(strFormat(" Current queue :"+ QueueCustomers.getLengthAllQueue())).append(tr)
                .append(sbCheckFor).append(strFormat(" Revenue : " + Bank.getRevenue() + " $")).append(tr)
                .append(sbCahier).append(stub).append(tr).append(separatorLine)
                .append(strings[0]).append(stub).append(tr)
                .append(strings[1]).append(stub).append(tr)
                .append(strings[2]).append(stub).append(tr)
                .append(strings[3]).append(stub).append(tr)
                .append(sbTotal).append(stub).append(tr).append(separatorLine);


        System.out.println(sb);

    }

    public static void setChecks(Check check) throws InterruptedException {
        checks.transfer(check);
    }

    private static String strFormat(String string) {
        String min = "#".repeat(5);
        return String.format("%s%-30s%s", min, string, min);
    }

}
