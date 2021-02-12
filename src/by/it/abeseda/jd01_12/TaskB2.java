package by.it.abeseda.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        int n = 20;
        ArrayList<String> human = new ArrayList<>();
//        human.add("Владимир");human.add("Дмитрий");human.add("Николай");human.add("Сергей");
//        human.add("Иосиф");human.add("Илья");human.add("Егор");human.add("Елисей");

        LinkedList<String> other = new LinkedList<>();
//        other.add("Владимир");other.add("Дмитрий");other.add("Николай");other.add("Сергей");
//        other.add("Иосиф");other.add("Илья");other.add("Егор");other.add("Елисей");
        for (int i = 1; i <= n; i++) {
            human.add("n" + i);
            other.add("n" + i);
        }

//        System.out.println(other);
        System.out.println(process(human));
        System.out.println(process(other));
    }

    static String process(ArrayList<String> peoples) {
        int count = 0;
        ArrayList<String> second = new ArrayList<>(peoples);

        while (second.size() != 1) {

            Iterator<String> iterator = second.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                count++;
                if (count % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return second.get(0);
    }

    static String process(LinkedList<String> peoples) {
        int count = 0;
        ArrayList<String> second = new ArrayList<>(peoples);

        while (second.size() != 1) {

            Iterator<String> iterator = second.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                count++;
                if (count % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return second.get(0);
    }
}


