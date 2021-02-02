package by.it.petrov.jd01_06;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {

        StringBuilder InitialText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[\\p{Punct}&&[^.!]]+");
        Pattern patternWithOutBackspaces = Pattern.compile("[\\p{Blank}]{2,}");
        Matcher matcher = pattern.matcher(InitialText);

        while(matcher.find()) {
            InitialText.replace(matcher.start(), matcher.start() + 1, " ");
        }

        String formattedText = InitialText.toString().replace('\n', ' ');
        formattedText = formattedText.replaceAll("\\.\\.\\.", " ");
        formattedText = formattedText.replaceAll("[\\p{Blank}]{2,}", " ");

        System.out.println(formattedText);

        String[] sentences = formattedText.split("[.!]{1}");
        System.out.println(Arrays.toString(sentences));

        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].trim();
        }

        int[] charsCounts = new int[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            charsCounts[i] = sentences[i].length();
        }

        // запустим пузырьковую сортировку для двух массивов
        for (int i = 0; i < charsCounts.length; i++) {
            for (int j = 0; j < charsCounts.length - i; j++) {
                if (j + 1 == charsCounts.length){
                    continue;
                }
                if (charsCounts[j] > charsCounts[j + 1]){
                    int intBuffer = charsCounts[j];
                    String strBuffer = sentences[j];
                    charsCounts[j] = charsCounts[j+1];
                    charsCounts[j+1] = intBuffer;
                    sentences[j] = sentences[j+1];
                    sentences[j+1] = strBuffer;
                }
            }
        }
        for (int i = 0; i < sentences.length; i++) {
            System.out.println(sentences[i]);
        }
    }
}

