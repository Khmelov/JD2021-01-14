package by.it.lapushkin.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String [] words = new String[0];
    private static int [] countWord = new int[0];

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern regexp  = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = regexp.matcher(text);
        while(matcher.find()) {
            processWord(matcher.group());
        }
        printResults();
    }

    private static void printResults() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d%n", words[i], countWord[i]);
        }
    }

    private static void processWord(String str) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(str)) {
                countWord[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length+1);
        countWord = Arrays.copyOf(countWord, countWord.length + 1);
        words[words.length-1] = str;
        countWord[countWord.length-1] = 1;
    }
}