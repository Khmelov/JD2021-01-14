package by.it.lapushkin.jd01_12;

import java.util.*;
import java.util.List;

public class TaskC1 {
    static Random random = new Random();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> listWords = new ArrayList<>();
        for (; ; ) {
            if (scanner.hasNext()) {
                String next = scanner.next();

                if (next.equals("end")) {
                    break;
                }
                listWords.add(next);
            }
        }

        Map<Integer, String> hash = new HashMap<>(sortMap(listWords));
        System.out.println(hash);
        System.out.println();
        System.out.println(makeUniq(hash));

    }

    static Map<Integer, String> sortMap(List<String> list) {
        Map<Integer, String> sortedmap = new TreeMap<>();
        for (String s : list) {
            sortedmap.put(random.nextInt(), s);
        }
        return sortedmap;
    }

    static Map<Integer, String> makeUniq(Map<Integer, String> map) {
        Collection<String> list = map.values();
        for (Iterator<String> iterator = list.iterator();iterator.hasNext();){
            if (Collections.frequency(list,iterator.next())>1){
                iterator.remove();
            }
        }
        return map;
    }
}
