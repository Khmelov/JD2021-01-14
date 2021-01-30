package by.it.abeseda.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Experience {
    public static void main(String[] args) {
        String str1="                                рыба                 ";
        System.out.println("1 "+str1);
        System.out.println("1 "+str1.trim());
        String s = Poem.text.replaceAll("\n", " ");;
        System.out.println(s);
        String s1 = s.replaceAll("\\.\\.\\.", "");
        System.out.println(s1);

    }
}
