package by.it.petrov.jd01_12;
import java.util.*;
public class TaskA2 {

    public static Set<Integer> getUnion(Set<Integer> collection1, Set<Integer> collection2){
        Set<Integer> unionSet = new HashSet<>(collection1);
        unionSet.addAll(collection2);
        return unionSet;
    }

    public static Set<Integer> getCross(Set<Integer> collection1, Set<Integer> collection2){
        HashSet<Integer> crossSet = new HashSet<>();
        for (Integer integer1 : collection1) {
            for (Integer integer2 : collection2) {
                        if(integer1.equals(integer2)){
                            crossSet.add(integer1);
                        }
            }
        }
        return crossSet;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        HashSet<Integer> collection1 = new HashSet<>(Arrays.asList(a));
        Integer[] b = new Integer[]{2, 5, 10, 999, 666, 555, 0, 0, 1};
        TreeSet<Integer> collection2 = new TreeSet<>(Arrays.asList(b));
        System.out.println(getUnion(collection1, collection2));
        System.out.println(getCross(collection1, collection2));
    }
}
