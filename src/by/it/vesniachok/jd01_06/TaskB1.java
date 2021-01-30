package by.it.vesniachok.jd01_06;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern regexp = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = regexp.matcher(text);
    }

    private static boolean IsFirstConsLastVowels(String word) {
        word=word.toLowerCase();


    }

}
