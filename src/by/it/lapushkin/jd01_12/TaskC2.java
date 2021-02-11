package by.it.lapushkin.jd01_12;

import java.math.BigDecimal;
import java.util.*;

public class TaskC2 {

    public static void main(String[] args) {
        Set<Long> a = new HashSet<Long>(Arrays.asList       (1L, 2L, 3L, 4L, 5L, 6L));
        Set<Integer> b = new HashSet<Integer>(Arrays.asList (4, 3, 5, 6, 7, 8));
        Set<Double> c = new HashSet<Double>(Arrays.asList   (0., 1., 2., 3., 4., 5.));
        Set<Double> d = new HashSet<Double>(Arrays.asList   (2., 3., 4., 9.));
        System.out.println(getUnion(a, b, b, c, c, d));
        System.out.println(getCross(a, a, b, c, c, d));
    }

    @SafeVarargs
    private static Set<?> getUnion(Set<? extends Number>... args){
        Set<Number> newSet = new TreeSet<>((o1, o2) -> {
            BigDecimal b1 = new BigDecimal(""+o1);
            BigDecimal b2 = new BigDecimal(""+o2);
            return b1.compareTo(b2);
        });
        for (Set<? extends Number> arg : args) {
            newSet.addAll(arg);
        }
        return newSet;
    }

    @SafeVarargs
    private static Set<?extends Number> getCross(Set<? extends Number>... args) {
        Set<Number> newSet = new TreeSet<>(args[0]);
        for (Set<? extends Number> arg : args) {
            Set<Number> tempSet = new TreeSet<>((o1, o2) -> {
                BigDecimal b1 = new BigDecimal("" + o1);
                BigDecimal b2 = new BigDecimal("" + o2);
                return b1.compareTo(b2);
            });
            tempSet.addAll(arg);
            newSet.retainAll(tempSet);
        }

        return newSet;
    }
}
