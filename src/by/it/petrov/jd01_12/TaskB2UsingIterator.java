package by.it.petrov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class TaskB2UsingIterator {
    static String process(LinkedList<String> peoples){

        int step = 1;
        LinkedList<String> bufferArray = (LinkedList<String>) peoples.clone();
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

        return bufferArray.get(0);
    }

    static String process(ArrayList<String> peoples){
        int step = 1;
        ArrayList<String> bufferArray = (ArrayList<String>)peoples.clone();
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

        return bufferArray.get(0);
    }

    public static void main(String[] args) {
        ArrayList<String> initialArray = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o"));
        System.out.println("Array list example: " + process(initialArray));
        LinkedList<String> initialLinkedList = new LinkedList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o"));
        System.out.println("Array linked list example: " + process(initialLinkedList));
    }
}
