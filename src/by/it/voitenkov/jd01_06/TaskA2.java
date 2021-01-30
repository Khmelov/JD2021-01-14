package by.it.voitenkov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    public static void main(String[] args) {
        result();
    }

    public static void result() {
        String[] words = {};
        int[] numberRepeatedWords = {};
        Pattern pattern = Pattern.compile("([А-Яа-яёЁ]+)");
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
            String word = matcher.group();
            boolean isArrayContainsWord = false;

            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word)) {
                    numberRepeatedWords[i]++;
                    isArrayContainsWord = true;
                }
            }

            if (words.length == 0) {
                words = new String[1];
                numberRepeatedWords = new int[1];
                words[0] = word;
                numberRepeatedWords[0] = 1;

            } else if (!isArrayContainsWord) {
                words = Arrays.copyOf(words, words.length+1);
                words[words.length-1] = word;
                numberRepeatedWords = Arrays.copyOf(numberRepeatedWords, numberRepeatedWords.length+1);
                numberRepeatedWords[numberRepeatedWords.length-1] = 1;
            }
        }

        for (int i = 0; i < words.length; i++) {
            System.out.printf("%-1s=%-1d\n", words[i], numberRepeatedWords[i]);
        }
    }
}