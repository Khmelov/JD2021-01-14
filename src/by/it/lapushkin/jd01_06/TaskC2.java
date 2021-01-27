package by.it.lapushkin.jd01_06;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.lapushkin.jd01_06.Poem.*;

public class TaskC2 {
    static int[] sequence;
    static String[] words;

    public static void main(String[] args) {
        words  = getWords();
        sequence = getSequence(words);

        slow("");

        fast("");
    }

    private static String[] getWords(){
        String[] words = {};
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            words = Arrays.copyOf(words, words.length+1);
            words[words.length-1] = matcher.group();
        }
        return words;
    }

    private static int[] getSequence(String[] words){
        int [] sequence = {};
        int charLength = 0;
        while (charLength < 100000){
            int index = (int)(Math.random()*words.length);
            charLength += words[index].length()+1;
            sequence = Arrays.copyOf(sequence, sequence.length+1);
            sequence[sequence.length-1] = index;

        }

        return sequence;
    }

    private static String slow(String word){
        String bigString = "";
        double slowTimeStart = System.currentTimeMillis();
        for (int i : sequence){
            bigString = bigString.concat(words[i]).concat(" ");
        }
        double time =System.currentTimeMillis()-slowTimeStart;
        System.out.println(time);
        return bigString;
    }
    private static String fast(String word){
        StringBuilder bigString = new StringBuilder();
        double slowTimeStart = System.currentTimeMillis();
        for (int i : sequence){
            bigString = bigString.append(words[i]).append(" ");
        }
        double time =System.currentTimeMillis()-slowTimeStart;
        System.out.println(time);
        return bigString.toString();
    }
}
