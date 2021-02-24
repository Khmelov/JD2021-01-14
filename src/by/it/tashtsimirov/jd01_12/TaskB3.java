package by.it.tashtsimirov.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class TaskB3 {

    static String finish = "";
    static String finish2 = "";

    static String process(ArrayList<String> peoples) {

        ListIterator<String> iter = peoples.listIterator();
        while (peoples.size() != 1) {
            peoples.add(peoples.size(),peoples.get(0));
            peoples.remove(0);
            peoples.remove(0);
        }
        finish = peoples.get(0);
        return finish;
    }

    static String process(LinkedList<String> peoples) {
        while (peoples.size() != 1) {
            peoples.addLast(peoples.get(0));
            peoples.remove(0);
            peoples.remove(0);
        }
        finish2 = peoples.get(0);
        return finish2;
    }


    public static void main(String[] args) {

        ArrayList<String> peoples = new ArrayList<>();
        for (int i = 0; i < 4097; i++) {
            peoples.add("Name_" + String.valueOf(i));
        }

        LinkedList<String> peoples2 = new LinkedList<>();
        for (int i = 0; i < 4097; i++) {
            peoples2.add("Name_" + String.valueOf(i));
        }

        System.out.println(peoples.toString());
        System.out.println(process(peoples) + "\n");

        System.out.println(peoples2.toString());
        System.out.println(process(peoples2));


    }
}
