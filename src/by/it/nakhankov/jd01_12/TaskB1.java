package by.it.nakhankov.jd01_12;


import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str;
        List<String> list = new ArrayList<>();
        while (!(str = scanner.next()).equals("end")) {
            String newList = str.replaceAll("[^a-zA-Z’']", "");
            list.add(newList);
        }
        System.out.println(list);

        Map<String, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (!(valueMap.containsKey(s))) {
                valueMap.put(s, 1);
            } else {
                valueMap.put(s, valueMap.get(s) + 1);
            }

            for (Map.Entry<String, Integer> entry : valueMap.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
    }
}
