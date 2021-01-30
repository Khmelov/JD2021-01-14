package by.it.shebeko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            String word = matcher.group();
        if (checkWord(word)){
                System.out.println(word);
            }
        }
    }
    private  static final String vowels = "аеиоуыюэяАЕИОУЫЮЭЯёЁ";

    private static boolean checkWord(String word){
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        boolean first1 = vowels.indexOf(first)<0;
        boolean last1 = vowels.indexOf(last)>=0;
        return first1 && last1;
    }

}

