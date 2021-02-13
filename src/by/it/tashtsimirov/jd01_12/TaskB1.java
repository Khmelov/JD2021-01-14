package by.it.tashtsimirov.jd01_12;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TaskB1 {

    public static void main(String[] args) {

        Map<String, Integer> wordOftenMeets = new TreeMap<>();

        Scanner scan = new Scanner(System.in);
        String line;
        String not1 = "don't", not2 = "isn't";

        while (!(line = scan.next()).equals("end")) {
            for (String word : line.split("[(\"?!.,;*) ]"))
                //for (String word : line.replaceAll("\\W", "\\s").split("\\s"))
            {
                not1 = not2;
                wordOftenMeets.put(word, wordOftenMeets.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println(wordOftenMeets);

    }


}
