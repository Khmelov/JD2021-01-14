package by.it.lapushkin.jd01_12;

import java.util.*;

public class TaskB3 {

    public static void main(String[] args) {
        Random random = new Random();
        String[] peopleArray = new String[4096];
        for (String s : peopleArray) {
            s = String.valueOf(random.nextInt());
        }
        ArrayList<String> peopleArrayList = new ArrayList<>(Arrays.asList(peopleArray));
        LinkedList<String> peopleLinkedList = new LinkedList<>(Arrays.asList(peopleArray));

        double oneTimeStart = System.currentTimeMillis();
        process(peopleArrayList);
        double oneTime =System.currentTimeMillis()-oneTimeStart;
        System.out.println(oneTime);

        double twoTimeStart = System.currentTimeMillis();
        process(peopleLinkedList);
        double twoTime =System.currentTimeMillis()-twoTimeStart;
        System.out.println(twoTime);

    }
    //linked list работает быстрее т.к операция удаоения у него o(1) а arraylist o(n)


    static String process(ArrayList<String> peoples) {
        for (int counter = 1; peoples.size() > 1; ) {
            Iterator<String> iterator = peoples.iterator();

            while (iterator.hasNext()) {
                iterator.next();
                if (counter % 2 == 0) {
                    iterator.remove();
                }
                counter++;
            }
        }

        return peoples.get(0);
    }


    static String process(LinkedList<String> peoples) {
        for (int counter = 1; peoples.size() > 1; ) {
            Iterator<String> iterator = peoples.iterator();

            while (iterator.hasNext()) {
                iterator.next();
                if (counter % 2 == 0) {
                    iterator.remove();
                }
                counter++;
            }
        }

        return peoples.get(0);
    }
}


   /* static String process(LinkedList<String> peoples) {
        Deque<String> deque = peoples;
        for (; deque.size() > 1; ) {
            if (deque.size() !=2){
                deque.pollFirst();
                deque.pollLast();
            }else{
                deque.pollFirst();
            }
        }
        return peoples.get(0);
    }*/