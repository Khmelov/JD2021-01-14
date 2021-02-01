package by.it.vesniachok.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder dynText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            int start=matcher.start();
            dynText.setCharAt(start + 3,'#');
            if(matcher.end()- matcher.start() > 6){
                dynText.setCharAt(start + 6,'#');
            }

        }
        System.out.println(dynText);


        }
    }

