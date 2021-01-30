package by.it.vesniachok.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    static private String[] words = {};
    static private int[] counts = {};

    public static void main(String[] args) {

        System.out.println(Poem.text);
        Pattern pattern = Pattern.compile("[а-я-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            process(word);

        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], counts[i]);

        }
    }

    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                counts[i]++;
                return;
            }

        }
        Arrays.copyOf(words, words.length + 1);
        Arrays.copyOf(counts, counts.length + 1);
        words[words.length - 1] = word;
        counts[counts.length - 1] = 1;


    }
    private static void printResults() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d%n", words[i], counts[i]);
        }
    }
}


