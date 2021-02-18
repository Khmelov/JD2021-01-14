package by.it.nakhankov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {

    public static void main(String[] args) {

        ArrayList<String> boys = new ArrayList<>();
        boys.add("Nick");
        boys.add("Mike");
        boys.add("Tom");

        LinkedList<String> girls = new LinkedList<>();
        girls.add("Nicole");
        girls.add("Monica");
        girls.add("Susan");

        System.out.println(boys);
        System.out.println(girls);
    }

    static String process(ArrayList<String> peoples) {
        return (String) removeEverySecond(peoples).get(0);
    }

    static String process(LinkedList<String> peoples) {
        return (String) removeEverySecond(peoples).get(0);
    }

    static List<?> removeEverySecond(List<?> listPeople) {
        int count = 0;
        while (listPeople.size() !=1) {
            Iterator<?> iterator = listPeople.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                count++;
                if (count % 2 == 0) {
                    iterator.remove();
                }
            }
        }
    return listPeople;


}







}
