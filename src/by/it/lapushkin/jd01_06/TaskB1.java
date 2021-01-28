package by.it.lapushkin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern regexp  = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = regexp.matcher(text);
        while(matcher.find()) {
            String word = matcher.group();
            if (isTrueWord(word))
                System.out.println(word);
        }
    }

    private static boolean isTrueWord(String word) {
        word = word.toLowerCase();
        char startChar = word.charAt(0);
        char endChar = word.charAt(word.length()-1);
        return consChar(startChar) && vowChar(endChar);
    }

    private static boolean consChar(char ch) {
        char [] consArray = {'й', 'ц', 'к', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ъ', 'ф',
                'в', 'п', 'р', 'л', 'д', 'ж', 'ч',  'с', 'м', 'т','б'};
        for(char i: consArray)
            if (ch == i)
                return true;
        return false;
    }

    private static boolean vowChar(char  ch) {
        char [] vowelArray = {'у', 'е', 'ы', 'а', 'о', 'э', 'я', 'и', 'ю', 'ё'};
        for(char i: vowelArray)
            if (ch == i)
                return true;
        return false;
    }
}