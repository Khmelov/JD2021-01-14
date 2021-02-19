package by.it.shebeko.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskC1 {
    private static Map<Integer, String> words = new HashMap<>();
    private static Map<Integer, String> newWords = new HashMap<>();

    public static void main(String[] args) {
        associatedArray1();
    }

    private static void associatedArray1() {
        Scanner sc = new Scanner(System.in);
        String line;
        int i = 0;
        for (;;){
            line = sc.nextLine();
            if (line.equals("end"))
                break;
            words.put(i++, line);
            if (!newWords.containsValue(line)){
                newWords.put(i - 1, line);
            }
        }
        System.out.println(words);
        System.out.println(newWords);
    }
}
