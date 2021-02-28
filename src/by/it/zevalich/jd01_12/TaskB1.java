package by.it.zevalich.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        String s;
        while (!(s = scanner.nextLine()).equals("end")) {
            String[] str = s.split("[-:;,.!?—()/\" ]+");
            for (int i = 0; i < str.length; i++) {
                String element = str[i];
                if (map.containsKey(element) == false) {
                    map.put(element, 1);
                } else {
                    map.put(element, map.get(element) + 1);
                }
            }
        }

        System.out.println(map.toString());
    }
}