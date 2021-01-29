package by.it.abeseda.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String s = Poem.text.replaceAll("\n", " ");
        String s1 = s.replaceAll("\\.\\.\\.", "");
        Pattern pat = Pattern.compile("[.!]+");
        String[] sentences = pat.split(s1);
  //      for (int i = 0; i < sentences.length; i++) {
    //        System.out.println(sentences[i]);
  //      }
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].trim();
            sentences[i] = sentences[i].replaceAll("[,-:]", "");
 //           System.out.println(sentences[5]);
            sentences[i] = sentences[i].replaceAll(" {2,}", " ");
            System.out.println(sentences[i]);
        }
        for (int i = 0; i < sentences.length; i++) {
            for (int j = i + 1; j < sentences.length; j++) {
                if (sentences[i].length() > sentences[j].length()) {
                    String temp = sentences[i];
                    sentences[i] = sentences[j];
                    sentences[j] = temp;
                }
            }
        }
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}



//        StringBuilder sb = new StringBuilder(Poem.text);
//
//        String str = sb.toString();
//        String bez=str.replaceAll("[^а-яA-ЯёЁ!?.]", " ")
//                .replace("  "," ").replace("  "," ")
//                .replace("... ","")
//                .replace(". ",".").replace("!? ",".").trim();
//
//
//        String[] array=bez.split("\\p{Punct}");

//        System.out.println(bez);*

 //       String [] array=bez.split("\\s+");
//

//        for (String element:
//            array) {
//            System.out.println(element);
//        }
//
//
//
//        Pattern pat=Pattern.compile("[а-яА-ЯёЁ]+");

 //       Matcher matcher=pat.matcher(bez);//дана ссылка на poem для поиска по шаблону pat
//        while (matcher.find()) {//




//        for (String elem:
  //           array) {
    //        System.out.println(elem);}


