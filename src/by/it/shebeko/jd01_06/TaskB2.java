package by.it.shebeko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    private static String [] sentences={};
    private static int [] count = {};
    public static void main(String[] args) {
        StringBuilder text= new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("([^.!?]+(.{2,}[а-яё])?[^.!?]+)[.!?]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String sentence = matcher.group();
            sentence = sentence.replaceAll("\n", " ");
            sentence = sentence.replaceAll("\\s*[.,;:?!-]+", "");
            sentence = sentence.trim();
            sentences = Arrays.copyOf(sentences, sentences.length + 1);
            count = Arrays.copyOf(count, count.length + 1);
            sentences[sentences.length - 1] = sentence;
            count[count.length - 1] = sentence.length();
        }
        Arrays.sort(count);
        numberOfSymbols();
    }
    private static void numberOfSymbols(){
        for (int k : count) {
            for (int i = 0; i < sentences.length; i++) {
                if (k == sentences[i].length()) {
                    System.out.println(sentences[i]);
                    sentences[i] = "a";
                    i = sentences.length - 1;
                }
            }
        }
    }
}