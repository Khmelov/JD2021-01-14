package by.it.voitenkov.jd01_12;

import java.util.*;

public class TaskB3 {

    public static void main(String[] args) {

        ArrayList<String> listPersons1 = new ArrayList<>();
        getRandomList(listPersons1);
        long startArrayList = System.nanoTime();
        process(listPersons1);
        long finishArrayList = System.nanoTime();
        System.out.println(process(listPersons1));
        System.out.println("time ArrayList = " + (finishArrayList - startArrayList) / 1000);

        LinkedList<String> listPersons2 = new LinkedList<>();
        getRandomList(listPersons2);
        long startLinkedList = System.nanoTime();
        process(listPersons2);
        long finishLinkedList = System.nanoTime();
        System.out.println(process(listPersons2));
        System.out.println("time LinkedList = " + (finishLinkedList - startLinkedList) / 1000);
    }

    static void getRandomList(List<String> list) {
        int count = 4096;
        Random random = new Random();
        while (count != 0) {
            list.add(random.nextInt() + "");
            count--;
        }
    }

    static String process(ArrayList<? extends Object> peoples) {
        return (String) removeEverySecond(peoples).get(0);
    }

    static String process(LinkedList<? extends Object> peoples) {
        return (String) removeEverySecond(peoples).get(0);
    }

    static List<?> removeEverySecond(List<? extends Object> listPersons) {
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