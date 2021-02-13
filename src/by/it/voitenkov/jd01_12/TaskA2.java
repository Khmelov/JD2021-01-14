package by.it.voitenkov.jd01_12;

import java.util.*;

public class TaskA2 {

    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> setB = new TreeSet<>(Arrays.asList(2, 3, 3));
        System.out.printf("setA = %s\n", setA);
        System.out.printf("setB = %s\n", setB);
        System.out.printf("union = %s\n", getUnion(setA, setB));
        System.out.printf("cross = %s\n", getCross(setA, setB));
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