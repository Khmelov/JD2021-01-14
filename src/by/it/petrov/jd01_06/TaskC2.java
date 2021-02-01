package by.it.petrov.jd01_06;

import java.util.Arrays;

public class TaskC2 {
    static String[] randomWordsArray;
    static String[] getSequence (String text){
        String formattedText = text.replace("\n", " ");
        formattedText = formattedText.replace(".", " ");
        formattedText = formattedText.replace(",", " ");
        formattedText = formattedText.replace(":", " ");
        formattedText = formattedText.replace("-", " ");
        formattedText = formattedText.replace("!", " ");

        String[] wordsArray = formattedText.split("[\\p{Blank}]+");
        int[] randomNumberInGivenRangeArray = new int[100000];
        for (int i = 0; i < 100000; i++){
            randomNumberInGivenRangeArray[i] = (int)(Math.random() * wordsArray.length);
        }

        String[] randomWordsArray = new String[100000];
        for (int i = 0; i < 100000; i++) {
            randomWordsArray[i] = wordsArray[randomNumberInGivenRangeArray[i]];
        }
        return randomWordsArray;
    }
    static String slow (String text){

        String finalTextIs = "";

        for (int i = 0; i < randomWordsArray.length; i++) {
            finalTextIs = finalTextIs  + randomWordsArray[i] + " ";
        }

        return finalTextIs;
    }
    static String fast (String text){

        StringBuilder finalTextIs = new StringBuilder();

        for (int i = 0; i < randomWordsArray.length; i++){
            finalTextIs = finalTextIs.append(randomWordsArray[i]).append(" ");
        }
        return finalTextIs.toString();
    }

    public static void main(String[] args) {

        randomWordsArray = getSequence(Poem.text);
        long timeCounter1 = System.nanoTime()/ 10000000;
        String text = slow(" ");
        System.out.println(text);
        long timeCounter2 = System.nanoTime()/ 10000000;
        System.out.println(timeCounter2 - timeCounter1);

        long timeCounter3 = System.nanoTime()/ 10000000;
        String text2 = fast(" ");
        System.out.println(text2);
        long timeCounter4 = System.nanoTime() / 10000000;
        System.out.println(timeCounter4 - timeCounter3);

    }
}
