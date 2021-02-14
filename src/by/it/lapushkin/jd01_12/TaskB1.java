package by.it.lapushkin.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (;;) {
            if (scanner.hasNext()){
                String next = scanner.next();
                String[] words = next.split("[-:;,.!?—()/\" ]+");

                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    if (!map.containsKey(word)){
                        map.put(word,1);
                    }else {
                        map.put(word,map.get(word) + 1);
                    }
                }
                if (next.equals("end")){
                    break;
                }


            }
        }
        System.out.println(map.toString());
    }

}
