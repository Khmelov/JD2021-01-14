package by.it.voitenkov.jd01_11;

import java.util.HashSet;

public class Has {


    public static void main(String[] args) {
        HashSet<Integer> array = new HashSet<>();
        array.add(1);
        array.add(32);
        array.add(33);
        array.add(333);
        array.add(3323);
        array.add(33233);
        array.add(33333);




        array.add(6);
        array.add(null);
        array.add(null);
        System.out.println(array.contains(1));
        System.out.println(array);
    }
}
