package by.it.petrov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TaskB3  {

    static String process(LinkedList<String> peoples){
        int step = 1;
        do{
            if (step % 2 == 0){
                peoples.pollFirst();
                step++;
                continue;
            }
            peoples.addLast(peoples.pollFirst());
            step++;
        } while (peoples.size() != 1);

        return peoples.peekFirst();
    }

    static String process(ArrayList<String> peoples){
        int step = 1;
        ArrayList<String> bufferArray = (ArrayList<String>)peoples.clone();
        ArrayList<String> bufferArray1 = new ArrayList<>();
        do{
            for (int i = 0 + step; i < bufferArray.size(); i += step) {
                if(((i + step) == bufferArray.size() - 1) && bufferArray.size() > 2){
                    bufferArray.add(0, bufferArray.get(i + 1));
                    bufferArray.remove(i+1);
                    bufferArray.remove(i+1);
                    break;
                }
                bufferArray.remove(i);
            }
        } while (bufferArray.size() != 1);
        for (int i = 0; i < 10000; i++) {
            bufferArray1.add("n"+i);
        }
        return bufferArray.get(0);
    }

    public static void main(String[] args) {

        int n = 4096;

        ArrayList<String> initialArray = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            initialArray.add("Human#" + i );
        }

        long firstPoint = System.nanoTime();
        System.out.println("Array list example: " + process(initialArray));
        long secondPoint = System.nanoTime();

        LinkedList<String> initialLinkedList = new LinkedList<>();
        for (int i = 1; i <= n + 1; i++) {
            initialLinkedList.add("Human#" + i);
        }

        long thirdPoint = System.nanoTime();
        System.out.println("Array linked list example: " + process(initialLinkedList));
        long fourthPoint = System.nanoTime();

        System.out.println("Time needed for ArrayList is " + (secondPoint - firstPoint)/1000);
        System.out.println("Time needed for LinkedList is " + (fourthPoint - thirdPoint)/1000);
    }
}
