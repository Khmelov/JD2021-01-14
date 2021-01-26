package by.it.petrov.jd01_06;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder dyText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while(matcher.find()){
            String word = matcher.group();
            if (matcher.end() - matcher.start())
            int start = matcher.start();
            dyText.setCharAt(start + 3, '#');
        }
        System.out.println(dyText);
    }
}

