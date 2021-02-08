package by.it.nakhankov.jd01_06;

import java.util.Locale;

public class TaskB1 {

    public static void main(String[] args) {
        replaceLetters();
    }

    private static void replaceLetters() {
        StringBuilder str = new StringBuilder(Poem.text);
        int firstLetterIndex;
        int lastLetterIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            if (isLetter(str.charAt(i))) {
                firstLetterIndex = i;
                i++;
                while (isLetter(str.charAt(i))) {
                    lastLetterIndex = i;
                    i++;
                }
                if (firstLetterIndex < lastLetterIndex) {
                    String word = str.substring(firstLetterIndex, lastLetterIndex + 1);

                    if (isConsonantLetter(word)) {
                        System.out.println(word);
                    }
                }
            }
        }
    }
    private static boolean isConsonantLetter(String letter) {
        char[] arrayVowelsLetter = {'б', 'в', 'г', 'д', 'ж', 'з', 'й',
                'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};
        char[] arrayConsonantLetter = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};

        for (char value : arrayVowelsLetter) {
            if (letter.toLowerCase(Locale.ROOT).charAt(0) == value) {
                for (char c : arrayConsonantLetter) {
                    if (letter.charAt(letter.length() - 1) == c) {
                        return true;
                    }
                }
                return false;
            }

        }
        return false;
    }
    private static boolean isLetter(char letter) {
        return ('A' <= letter && letter <= 'я') || letter == 'ё';
    }
}
