package by.it.lapushkin.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    private static String[] sentences = new String[0];

    private static void main(String[] args) {
        String text = Poem.text;
        text = text.replaceFirst("\\.\\.\\.","");
        Pattern regexp = Pattern.compile("[^.]*[.]+");
        Matcher matcher = regexp.matcher(text);

        while (matcher.find()) {
            String sentence = matcher.group();

            sentence = sentence.replaceAll("[^а-яА-ЯёЁ]", " ").replaceAll(" {2,}", " ").trim();
            sentences = Arrays.copyOf(sentences, sentences.length + 1);
            sentences[sentences.length - 1] = sentence;
        }

        boolean isSorted = false;
        String a;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < sentences.length - 1; i++) {
                if (sentences[i].length() > sentences[i + 1].length()) {
                    isSorted = false;
                    a = sentences[i];
                    sentences[i] = sentences[i + 1];
                    sentences[i + 1] = a;
                }

            }

        }
        for (String sentence : sentences) {
            System.out.printf("%s\n", sentence);
        }


    }
}
