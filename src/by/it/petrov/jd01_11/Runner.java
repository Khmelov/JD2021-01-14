package by.it.petrov.jd01_11;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        SetC<Integer> mySet = new SetC<>();
        Set<Integer> mySet2 = new SetC<>();
        Set<Integer> arSet = new HashSet<>();

        List<Integer> expList = new ArrayList<>();

        expList.add(null);expList.add(5);expList.add(7);expList.add(5);expList.add(5);expList.add(777);

        mySet.add(1);mySet.add(null);mySet.add(3);mySet.add(4);mySet.add(5);
        mySet.add(6);mySet.add(7);mySet.add(8);mySet.add(9);mySet.add(10);

        System.out.println(mySet.contains(5));
        mySet.removeAll(expList);
        System.out.println(mySet);

        arSet.add(1);arSet.add(2);arSet.add(3);arSet.add(4);arSet.add(5);
        arSet.add(6);arSet.add(7);arSet.add(8);arSet.add(9);arSet.add(10);
        System.out.println("My Set is: " + mySet.toString() + "\nAr Set is: " + arSet.toString());

    }
}
