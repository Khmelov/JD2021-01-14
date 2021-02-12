package by.it.voitenkov.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> listPersons1 = new ArrayList<>();
        listPersons1.add("1");
        listPersons1.add("2");
        listPersons1.add("3");
        LinkedList<String> listPersons2 = new LinkedList<>();
        listPersons2.add("1");

        System.out.println(process(listPersons1));
        System.out.println(process(listPersons2));
    }

    static String process(ArrayList<String> peoples) {
        return (String) removeEverySecond(peoples).get(0);
    }

    static String process(LinkedList<String> peoples) {
        return (String) removeEverySecond(peoples).get(0);
    }

    static List<?> removeEverySecond(List<?> listPersons) {
        int count = 0;

        while (listPersons.size() != 1) {
            Iterator<?> iterator = listPersons.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                count++;
                if (count % 2 == 0){
                    iterator.remove();
                }
            }
        }
        return listPersons;
    }
}