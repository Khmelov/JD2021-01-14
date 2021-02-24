package by.it.zevalich.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        String[] list = {"1","2","3","4","5","6","7","8","9","10"};
        ArrayList<String> arrPeoples = new ArrayList<>(Arrays.asList(list));
        LinkedList<String> linPeoples= new LinkedList<>(Arrays.asList(list));
        System.out.println(process(arrPeoples));
        System.out.println(process(linPeoples));
    }
    static String process(ArrayList<String> peoples){
        int count = 0;
        while (peoples.size()!=1) {
            Iterator<String> iter = peoples.iterator();
            while (iter.hasNext()) {
                iter.next();
                count++;
                if (count % 2 == 0) {
                    iter.remove();
                }
            }
        }
        return peoples.get(0);
    }
    static String process(LinkedList<String> peoples){
        int count = 0;
        while (peoples.size()!=1) {
            Iterator<String> iter = peoples.iterator();
            while (iter.hasNext()) {
                iter.next();
                count++;
                if (count % 2 == 0) {
                    iter.remove();
                }
            }
        }
        return peoples.get(0);
    }

}
