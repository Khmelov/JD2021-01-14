package by.it.voitenkov.jd01_12;

import java.util.*;

public class TaskC1 {
    private static final List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        getList();
        Map<Integer, String> associativeArrays = getAssociativeArrays();
        System.out.println(associativeArrays);
        System.out.println(removeDuplicateValue(associativeArrays).toString());
    }

    static void getList() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.equals("end")) {
                break;
            }
            TaskC1.list.add(str);
        }
    }

    static TreeMap<Integer, String> getAssociativeArrays() {
        TreeMap<Integer, String> associativeArrays = new TreeMap<>();
        int count = 1;
        Random random = new Random();

        for (String iterator : TaskC1.list) {
            associativeArrays.put(iterator.length() + count++ * (random.nextInt() + 30), iterator);
        }
        return associativeArrays;
    }

    static Map<Integer, String> removeDuplicateValue(Map<Integer, String> associativeArrays) {
        TreeMap<String, Integer> tmp = new TreeMap<>();
        for (Map.Entry<Integer, String> entry1 : associativeArrays.entrySet()) {
            if (!tmp.containsKey(entry1.getValue())) {
                tmp.put(entry1.getValue(), entry1.getKey());
            }
        }

        associativeArrays.clear();

        for (Map.Entry<String, Integer> entry1 : tmp.entrySet()) {
            associativeArrays.put(entry1.getValue(), entry1.getKey());
        }
        return associativeArrays;
    }
}