package by.it.abeseda.jd01_12;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two){
        Set<Integer> result=new HashSet<>(one);
        result.addAll(two);
    return result;
    }

    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two){
        Set<Integer> result=new HashSet<>(one);
        result.retainAll(two);
        return result;
    }

    public static void main(String[] args) {
        Integer[] arrayA = {1, 1, 2, 2, 3, 3, 4, 5, 6, 33};
        Integer[] arrayB = {4, 4, 5, 6, 6, 7, 8, 9, 90};
        TreeSet<Integer> treeSet=new TreeSet<>(Arrays.asList(arrayA));
        HashSet<Integer> hashSet=new HashSet<>(Arrays.asList(arrayB));
        System.out.println(getCross(treeSet, hashSet));
        System.out.println(getUnion(treeSet, hashSet));
    }
}
