package by.it.petrov.jd01_06;

import java.util.Arrays;

public class TaskC2 {
    static String slow (String text){
        return "123";
    }
    public static void main(String[] args) {
        String formattedText = Poem.text.replace("\n", " ");
        formattedText = formattedText.replace(".", " ");
        formattedText = formattedText.replace(",", " ");
        formattedText = formattedText.replace(":", " ");
        formattedText = formattedText.replace("-", " ");
        formattedText = formattedText.replace("!", " ");
        String[] wordsArray = formattedText.split("[\\p{Blank}]+");
        int[] randomNumberInGivenRangeArray = new int[wordsArray.length];
        for (int i = 0; i < randomNumberInGivenRangeArray.length; i++){
            randomNumberInGivenRangeArray[i] = (int)Math.ceil(Math.random() * wordsArray.length);
        }

        String[] randomWordsArray = new String[wordsArray.length];
        for (int i = 0; i < wordsArray.length; i++) {
            randomWordsArray[i] = wordsArray[randomNumberInGivenRangeArray[i]];
        }
        System.out.println("Our generated initial array is " + Arrays.toString(randomWordsArray));

    }
}
