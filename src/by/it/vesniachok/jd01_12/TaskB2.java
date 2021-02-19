package by.it.vesniachok.jd01_12;


import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        ArrayList <String> people = new ArrayList<>();
        LinkedList <String> people1 = new LinkedList<>();

        String[] arr = {"Maria", "Susan", "Marina", "Ksenia", "Nadia"};
        for (String element : arr) {
            people.add(element);
            people1.add(element);
        }
        System.out.println(people);
        System.out.println(process(people));
        System.out.println(people1);
        System.out.println(process(people1));
    }

    static String process (ArrayList<String> people0){
        int count = 0;
        Iterator<String> iterator = people0.iterator();
        while (people0.size()!= 1){
            while (iterator.hasNext()){
                iterator.next();
                if (count == 1){
                    iterator.remove();
                    count = 0;
                    continue;
                }
                count = 1;
            }
            iterator = people0.iterator();
        }
        String name = people0.toString();
        name = name.replaceAll("\\[", "");
        name = name.replaceAll("]", "");
        return name;
    }

    static String process (LinkedList<String> people0){
        int count = 0;
        Iterator<String> iterator = people0.iterator();
        while (people0.size()!= 1){
            while (iterator.hasNext()){
                iterator.next();
                if (count == 1){
                    iterator.remove();
                    count = 0;
                    continue;
                }
                count = 1;
            }
            iterator = people0.iterator();
        }
        String name = people0.toString();
        name = name.replaceAll("\\[", "");
        name = name.replaceAll("]", "");
        return name;
    }
}
