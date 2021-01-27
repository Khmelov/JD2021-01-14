package by.it.petrov.jd01_06;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskA2 {

    public static void main(String[] args) {
        String[] words = new String[]{};
        int[] wordsCount = new int[]{};
        int index_of_word_to_count = 0;
        StringBuilder dyText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]{1,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while(matcher.find()){
            String word = matcher.group();
            boolean is_in_list = false;
            for (int i = 0; i < words.length; i++) {
                if (word.equals(words[i])){
                    is_in_list = true;
                    index_of_word_to_count = i;
                    break;
                }
            }
            if(is_in_list){
                wordsCount[index_of_word_to_count] += 1;
                continue;
            }
            words = Arrays.copyOf(words, words.length + 1);
            wordsCount = Arrays.copyOf(wordsCount, wordsCount.length + 1);
            words[words.length - 1] = matcher.group();
            wordsCount[words.length - 1] += 1;

        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d%n", words[i], wordsCount[i]);
        }
    }
}
