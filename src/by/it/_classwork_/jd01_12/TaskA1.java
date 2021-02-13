package by.it._classwork_.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private static Random rnd = new Random();

    private List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        int n = 20 + rnd.nextInt(20);
        for (int i = 0; i < n; i++) {
            int grade = 1 + rnd.nextInt(10);
            instance.grades.add(grade);
        }
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);
    }

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        //noinspection Java8CollectionRemoveIf
        while (iterator.hasNext()){
            Integer value = iterator.next();
            if (value<4) {
                iterator.remove();
            }
        }
    }
}
