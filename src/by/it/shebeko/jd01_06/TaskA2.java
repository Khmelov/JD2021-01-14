package by.it.shebeko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    static String [] words = {};
    static int [] counts = {};

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(sb);
        while(matcher.find()){
            String word = matcher.group();
            counter(word);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + "=" + counts[i]);
        }
    }
    static void counter (String word){
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)){
                counts [i]++;
            }
        }
        words = Arrays.copyOf(words, words.length +1);
        counts = Arrays.copyOf(counts, counts.length +1);
        words[words.length-1] = word;
        counts[counts.length -1] =1;
    }
}
