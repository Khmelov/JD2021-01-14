package by.it.voitenkov.jd01_06;

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
            // если символ буква, значит это начало
            if (isLetter(str.charAt(i))) {
                firstLetterIndex = i;
                i++;
                // ищем последнюю букву в слове
                while (isLetter(str.charAt(i))) {
                    lastLetterIndex = i;
                    i++;
                }
                // если индекс первой буквы больше индекса второй буквы - значит это слово мин. из 2 символов
                if (firstLetterIndex < lastLetterIndex) {
                    String word = str.substring(firstLetterIndex, lastLetterIndex + 1); // получили слово

                    if (isConsonantLetter(word)) { // проверяем подходит ли слово по условию задачи
                        System.out.println(word); // если подходит, тогда выводим на консоль
                    }
                }
            }
        }
    }
    //проверяем слово
    private static boolean isConsonantLetter(String letter) {
        char[] arrayVowelsLetter = {'б', 'в', 'г', 'д', 'ж', 'з', 'й',
                'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};
        char[] arrayConsonantLetter = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};

        for (char value : arrayVowelsLetter) {
            //если первая буква согласная
            if (letter.toLowerCase(Locale.ROOT).charAt(0) == value) {
                // проверяем последнюю букву
                for (char c : arrayConsonantLetter) {
                    if (letter.charAt(letter.length() - 1) == c) {
                        return true; // первая и вторая буква подходит условию, тогда возвращаем true
                    }
                }
                return false;
            }

        }
        return false;
    }
    // проверяем является ли символ букой
    private static boolean isLetter(char letter) {
        return ('A' <= letter && letter <= 'я') || letter == 'ё';
    }
}