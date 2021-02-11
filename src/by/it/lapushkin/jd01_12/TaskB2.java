package by.it.lapushkin.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        String[] peopleArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ArrayList<String> peopleArrayList = new ArrayList<>(Arrays.asList(peopleArray));
        LinkedList<String> peopleLinkedList = new LinkedList<>(Arrays.asList(peopleArray));
    }

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
