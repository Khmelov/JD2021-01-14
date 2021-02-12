package by.it.petrov.jd01_12;

import java.util.*;

import static java.lang.Double.parseDouble;

public class TaskC2 {

    @SafeVarargs
    public static <K extends Number> HashSet<Double> getUnion(Set<? extends K>... collection) {
        HashSet<Double> unionSet = new HashSet<>();
        for (Set<? extends K> ks : collection) {
            for (K collection1Item : ks) {
                Double item = collection1Item.doubleValue();
                unionSet.add(item);
            }
        }
        return unionSet;
    }

    public static <K extends Number> HashSet<Number> getCross(Set<? extends K>... collection) {
        HashSet<Number> unionSet = new HashSet<>();
        for (int i = 0; i < collection[0].size(); i++) {
            int intersectionCount = 0;
            Number initialNumber = ((Number) collection[0].toArray()[i]).doubleValue();
            for (int j = 1; j < collection.length; j++) {
                for (int k = 0; k < collection[j].size(); k++) {
                    Number numberToCompare = ((Number) collection[j].toArray()[k]).doubleValue();
                    if(initialNumber.equals(numberToCompare)){
                        intersectionCount++;
                        break;
                    }
                }
            }
            if (intersectionCount == collection.length - 1){
                unionSet.add(initialNumber);
            }
        }
        return unionSet;
    }

    public static void main(String[] args) {
        Long[] a = new Long[]{10L, 5L, 11L};
        HashSet<Long> collection1 = new HashSet<>(Arrays.asList(a));

        Byte[] b = new Byte[]{10, 5, 11};
        TreeSet<Byte> collection2 = new TreeSet<>(Arrays.asList(b));

        Float[] c = new Float[]{10f, 5f, 10f};
        TreeSet<Float> collection3 = new TreeSet<>(Arrays.asList(c));

        System.out.println(getUnion(collection1, collection2, collection3));
        System.out.println(getCross(collection1, collection2, collection3));
    }
}