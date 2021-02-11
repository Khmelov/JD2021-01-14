package by.it.petrov.jd01_12;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        Integer [] IntArray = new Integer [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> arrIntList = new ArrayList<>(Arrays.asList(IntArray));
        System.out.println(arrIntList);
    }
}