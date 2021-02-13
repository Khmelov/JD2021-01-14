package by.it.lapushkin.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] a ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Integer[] b ={3,1,5,3,7,45,3,4,2,6,7,8,9,34,5};
        Set<Integer> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(a));
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(Arrays.asList(b));
        System.out.println("A = "+hashSet);
        System.out.println("B = "+treeSet);
        System.out.println("Cross = "+getCross(treeSet,hashSet));
        System.out.println("Union = "+getUnion(treeSet,hashSet));
    }

    private static Set<Integer> getCross(Set<Integer> treeSet,Set<Integer> hashset){
        Set<Integer> newSet = new HashSet<>(hashset);
        newSet.retainAll(treeSet);
        return newSet;
    }
    private static Set<Integer> getUnion(Set<Integer> treeSet,Set<Integer> hashset){
        Set<Integer> newSet = new HashSet<>(64);
        newSet.addAll(treeSet);
        newSet.addAll(hashset);
        return newSet;
    }

}
