package by.it.lapushkin.jd01_12;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private static Random random = new Random();

    private List<Integer> rating = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        int n = 20 + random.nextInt(20);
        for (int i = 0; i < n; i++) {
            int j = 1 + random.nextInt(10);
            instance.rating.add(j);
        }
        System.out.println(instance.rating);
        instance.clearBad(instance.rating);
        System.out.println();
        System.out.println(instance.rating);
    }
    private void clearBad(List<Integer> rating){
        Iterator<Integer> iterator = rating.iterator();

        while (iterator.hasNext()){
            Integer value = iterator.next();
            if (value < 4){
                iterator.remove();
            }
        }

    }
}
