package by.it.lapushkin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    private static void main(String[] args) {
        step1();
    }

    private static void step1(){
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-яЁ]{4,}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            int start=matcher.start();
            text.setCharAt(start+3,'#');
            if(matcher.group().length()>=7){
                text.setCharAt(start+6,'#');
            }

        }
        System.out.println(text);

    }
}
