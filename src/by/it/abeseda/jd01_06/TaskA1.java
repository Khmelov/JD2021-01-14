package by.it.abeseda.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder dynTex=new StringBuilder(Poem.text);
        Pattern pattern=Pattern.compile("[а-яА-яёЁ]{4,}");
        Matcher matcher =pattern.matcher(dynTex);
        while(matcher.find()){
            String word= matcher.group();
            int start= matcher.start();
            dynTex.setCharAt(start+3,'#');
            if (matcher.end()-matcher.start()>6){
                dynTex.setCharAt( );
            }
        }
        System.out.println(dynTex);
    }
}
