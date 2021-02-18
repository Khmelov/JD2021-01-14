package by.it.nakhankov.jd01_12;

import java.util.*;

public class TaskB3 {

    public static void main(String[] args) {

        ArrayList<String> boys = new ArrayList<>();
        getRandomList(boys);
        long startArrayList = System.nanoTime();
        process (boys);
        long finishArrayList = System.nanoTime();
        System.out.println(process(boys));
        System.out.println("time ArrayList = " + (finishArrayList - startArrayList)/ 1000);


        LinkedList<String> girls = new LinkedList<>();
        getRandomList(girls);
        long startLinkedList = System.nanoTime();
        process (girls);
        long finishLinkedList = System.nanoTime();
        System.out.println(process(girls));
        System.out.println("time LinkedList = " + (finishLinkedList - startLinkedList)/ 1000);
    }

    static void getRandomList(List<String> list) {

        int count = 4096;
        Random random = new Random();
        while (count !=0) {
            list.add(random.nextInt() + "");
            count--;
        }
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
