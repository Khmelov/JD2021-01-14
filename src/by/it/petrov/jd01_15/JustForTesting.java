package by.it.petrov.jd01_15;

import java.util.HashMap;
import java.util.Map;

public class JustForTesting {

    static private Map<String, Integer> mapOfThings = new HashMap<>();

    public static void main(String[] args) {
        String one = "one";
        Integer two = 2;
        mapOfThings.put(one, two);
        System.out.println(mapOfThings);

    }
}