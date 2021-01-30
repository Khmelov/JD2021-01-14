package by.it.voitenkov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {
        getOffers(Poem.text);
    }

    public static void getOffers(String text) {
        String[] line = {};
        Pattern pattern = Pattern.compile("" +
                "([А-ЯЁ].*\\n.*[.!?])|" +
                "([А-ЯЁ].*\\n.*\\n.*[.!?])|" +
                "([А-ЯЁ].*\\n.*\\n.*\\n.*[.!?])|" +
                "([А-ЯЁ].*\\n.*\\n.*\\n.*\\n.*\\n.*[.!?])");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            line = Arrays.copyOfRange(line, 0, line.length + 1);
            line[line.length - 1] = matcher.group();
        }
        removeAllCharacters(line);
        sortingLines(line);
    }

    public static void removeAllCharacters(String[] str) {
        Pattern pattern = Pattern.compile("[^А-яёЁ]+");

        for (int i = 0; i < str.length; i++) {
            Matcher matcher = pattern.matcher(str[i]);

            while (matcher.find()) {
                str[i] = matcher.replaceAll(" ");
            }
            str[i] = str[i].trim();
        }
    }

    static void sortingLines(String[] str) {
        for (int i = 0; i < str.length; i++) {
            for (int j = i; j < str.length; j++) {
                if (str[i].length() > str[j].length()) {
                    String tmp = str[j];
                    str[j] = str[i];
                    str[i] = tmp;
                }
            }
        }
        for (String s : str) {
            System.out.println(s);
        }
    }
}