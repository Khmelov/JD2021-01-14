package by.it.abeseda.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        int n = 4096;
        LinkedList<String> other = new LinkedList<>();
        ArrayList<String> human = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            other.add("n" + i);
            human.add("n" + i);
        }
        //считаем время первого метода
        long start1=System.nanoTime();
        process(human);
        long time1=(System.nanoTime()-start1)/1000;
        System.out.println(time1);

        //считаем время второго метода
        long start2=System.nanoTime();
        process(other);
        long time2=(System.nanoTime()-start2)/1000;
        System.out.println(time2);//линк

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
        int peopleNum=0;
        while (peoples.size()!=1 && peopleNum%2!=0){
            peoples.addLast(peoples.pollFirst());
            peoples.pollFirst();
            peopleNum=peopleNum+1;
        }
        return peoples.peekFirst();//возвращает элемент в хвосте двусторонннеей очереди
    }
}

