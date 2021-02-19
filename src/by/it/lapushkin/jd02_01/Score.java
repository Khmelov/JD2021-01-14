package by.it.lapushkin.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.it.lapushkin.jd02_01.Helper.*;


public class Score {
    private static volatile int customersInScore = 0;
    private static final List<Person> personList = new ArrayList<>();
    private static final Map<Integer, Integer> timeMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Score is opened!");
        boolean oldCustomer;
        for (int time = 0, circleTime = 0, countCustomers = 0; time <= 120; time++, circleTime++) {
            int max = (circleTime < 30) ? circleTime + 10 : circleTime - 10;
            circleTime = (circleTime == 60)?0:circleTime;
            if (customersInScore <= 40 + (20 - circleTime)) {
                for (int i = 0, n = random(max); i < n; i++) {
                    oldCustomer = countCustomers % 4 == 0;
                    Person customer = new Person(++countCustomers, oldCustomer);
                    customer.start();
                    personList.add(customer);
                }
            }else {
                System.err.println("Many customers.Close doors");
            }
            timeout(1000);
            timeMap.put(time, getCustomersInScore());
        }
        for (Person person : personList) {
            person.join();
        }
        //System.out.println(timeMap.toString());
        System.out.println("Score is closed!");
        renderResult(timeMap);
    }

    private static void renderResult(Map<Integer, Integer> map) {

        for (int i = 45, j = 0; i >= 0; i--, j++) {
            StringBuilder stringBuilder = new StringBuilder();
            int count = 0;
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                if (entry.getValue() == i){
                    String s = " ".repeat(entry.getKey() - count)+"+";
                    stringBuilder.append(s);
                    count = entry.getKey();
                }
            }
            System.out.printf("%-2d|%s",i,stringBuilder.toString());
            System.out.println();
        }
    }

    static synchronized void enterCustomers() {
        customersInScore++;
    }

    static synchronized void leaveCustomers() {
        customersInScore--;
    }

    public static int getCustomersInScore() {
        return customersInScore;
    }
}
