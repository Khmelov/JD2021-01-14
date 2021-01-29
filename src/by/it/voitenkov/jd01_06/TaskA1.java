package by.it.voitenkov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {

    public static void main(String[] args) {
        result();
    }

    private static void result() {
        StringBuilder str = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("([A-яёЁ]{4,})");
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
            int start = matcher.start();
            str.setCharAt(start + 3, '#');
            if (matcher.group().length() >= 7) {
                str.setCharAt(start + 6, '#');
            }
        }
        System.out.println(str);
    }
}