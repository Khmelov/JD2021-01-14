package by.it.nakhankov.jd01_06;



import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
    String s = Poem.text.replaceAll("\n", " ");
    String s1 = s.replaceAll("\\.\\.\\.", "");
    Pattern pat = Pattern.compile("[.!]+");
    String[] sentences = pat.split(s1);

    for (int i = 0; i < sentences.length; i++) {
        sentences[i] = sentences[i].trim();
        sentences[i] = sentences[i].replaceAll("[,-:]", "");
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

