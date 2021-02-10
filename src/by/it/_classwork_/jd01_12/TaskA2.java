package by.it._classwork_.jd01_12;

import org.hamcrest.Condition;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] arrayA = {1, 1, 2, 2, 3, 3, 4, 5, 6, 33};
        Integer[] arrayB = {4, 4, 5, 6, 6, 7, 8, 9, 90};
        List<Integer> listA = Arrays.asList(arrayA);
        Set<Integer> setA = new HashSet<>(64, 1);
        setA.addAll(listA);
        Set<Integer> setB = new TreeSet<>(Arrays.asList(arrayB));
        System.out.printf("setA=%s\n", setA);
        System.out.printf("setB=%s\n", setB);
        System.out.printf("union=%s\n", getUnion(setA,setB));
        System.out.printf("cross=%s\n", getCross(setA,setB));
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
}
