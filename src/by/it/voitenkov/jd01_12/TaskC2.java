package by.it.voitenkov.jd01_12;

import by.it.voitenkov.jd01_11.Has;

import java.util.*;

public class TaskC2 {

    public static void main(String[] args) {
        Set<Long> a = new HashSet<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        Set<Integer> b = new HashSet<Integer>(Arrays.asList(4, 3, 5, 6, 7, 8));
        Set<Double> c = new HashSet<Double>(Arrays.asList(0., 1., 2., 3., 4., 5.));
        Set<Double> d = new HashSet<Double>(Arrays.asList(2., 3., 4., 9.));

        System.out.printf("union = %s\n", getUnion(a, b, b, c, c, d));
        System.out.printf("cross = %s\n", getCross(a, a, b, c, c, d));
    }

    private static Set<?> getUnion(Set<? extends Number>... a) {
        HashSet<Number> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {

            if (set.isEmpty()) {
                set.addAll(a[i]);
            } else {
                for (Iterator<? extends Number> it = a[i].iterator(); it.hasNext(); ) {
                    Number num = it.next();
                    boolean bool = false;

                    for (Iterator<Number> iter = set.iterator(); iter.hasNext(); ) {
                        Number numberSet = iter.next();
                        if (numberSet.doubleValue() == num.doubleValue()) {
                            bool = false;
                            break;
                        } else {
                            bool = true;
                        }
                    }

                    if (bool) {
                        set.add(num);
                    }
                }
            }
        }
        return set;
    }

    private static Set<Number> getCross(Set<? extends Number>... a) {
        HashSet<Number> set = new HashSet<>();
        for (int i = 0; i < a.length - 1; i++) {

            for (Iterator<? extends Number> it1 = a[i].iterator(); it1.hasNext(); ) {
                Number number1 = it1.next();
                boolean bool = false;
                int count = 1;
                for (int j = i + 1; j < a.length; j++) {
                    for (Iterator<? extends Number> it2 = a[j].iterator(); it2.hasNext(); ) {
                        Number number2 = it2.next();
                        if (number1.doubleValue() == number2.doubleValue()) {
                            bool = true;
                            count++;
                        }

                    }
                }
                if (bool && count / a.length == 1) {
                    set.add(number1);
                }
            }
        }
        return set;
    }
}