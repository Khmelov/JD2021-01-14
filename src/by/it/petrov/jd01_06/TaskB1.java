package by.it.petrov.jd01_06;

import java.util.Arrays;
import java.util.regex.*;

public class TaskB1 {

    private static boolean checkForTheLetters(String word, int length){

        boolean firstLetterIsConsonant = false;
        boolean lastLetterIsVowel = false;

        char[] vowelLetters = new char[]{'А', 'а', 'Е', 'е', 'Ё', 'ё', 'И', 'и',  'О',
                'о', 'У', 'у', 'Ы', 'ы', 'Э', 'э', 'Ю', 'ю', 'Я', 'я'};

        char[] consonantLetters = new char[]{'Б', 'б', 'В', 'в', 'Г', 'г', 'Д', 'д', 'Ж', 'ж', 'З', 'з',
                'К', 'к', 'Л', 'л', 'М', 'м', 'Н', 'н', 'П', 'п', 'Р', 'р', 'С', 'с', 'Т', 'т', 'Ф', 'ф'
                , 'Х', 'х', 'Ц', 'ц', 'Ч', 'ч', 'Ш', 'ш', 'Щ', 'щ', 'Й', 'й',};

        char[] wordInChars = word.toCharArray();

        for (char consonantLetter : consonantLetters) {
            if (wordInChars[0] == consonantLetter) {
                firstLetterIsConsonant = true;
                break;
            }
        }

        for (char vowelLetter : vowelLetters) {
            if (wordInChars[length - 1] == vowelLetter) {
                lastLetterIsVowel = true;
                break;
            }
        }

        return firstLetterIsConsonant && lastLetterIsVowel;
    }
    public static void main(String[] args) {
        StringBuilder Text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]{3,}");
        Matcher matcher = pattern.matcher(Text);
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            int wordLength = end - start;
            boolean Check = checkForTheLetters(matcher.group(), matcher.group().length());
            if (Check){
                System.out.println(matcher.group());

            }
        }
    }
}