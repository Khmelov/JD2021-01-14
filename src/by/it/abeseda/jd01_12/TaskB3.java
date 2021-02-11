package by.it.abeseda.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class TaskB3 {
    public static void main(String[] args) {
        int n = 4096;

        //считаем время первого метода
        long start1=System.nanoTime();
        ArrayList<String> human = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            human.add("n" + i);
        }
        String resultProcess1=process(human);
        long time1=(System.nanoTime()-start1)/1000;
        System.out.println(time1);

        //считаем время второго метода
        long start2=System.nanoTime();
        LinkedList<String> other = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            other.add("n" + i);
        }
        String resultProcess2=process(other);
        long time2=(System.nanoTime()-start2)/1000;
        System.out.println(time2);//linkedlist

//        System.out.println(resultProcess1);
//        System.out.println(resultProcess2);
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
        PriorityQueue<String> myQueue=new PriorityQueue<>(second);

        while (myQueue.size() !=1){

        }
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
//        int[] listPerson = new int[10] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//=        Queue<int> list = new Queue<int>(listPerson);
//
//        while (list.Count != 1)
//        {
//            list.Enqueue(list.Dequeue());
//            list.Dequeue();
//        }
    }
}
