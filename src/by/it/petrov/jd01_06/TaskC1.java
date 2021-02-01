package by.it.petrov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static String getSpacedObject(int numberOfSpaces){
        String initialObject = "";
        for (int i = 0; i < numberOfSpaces; i++) {
            initialObject = initialObject + " ";
        }
        return  initialObject;
    }

    static int getMaximumValue(int[] array) {
        int maximumValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maximumValue) {
                maximumValue = array[i];
            }
        }
        return maximumValue;
    }
    public static int getArraySum(int[] array){
        int arraySum = 0;
        for (int i = 0; i < array.length; i++) {
            arraySum += array[i];
        }
        return arraySum;
    }
    public static int[] getArrayWithSpacesIndexes(int numberOfCharsToAdd, int numberOfSpacesInInitialSentence){

        //First test
        int [] FirstTestArray = new int [numberOfSpacesInInitialSentence];
        int INumberFromFirstTest = 0;

        while (getArraySum(FirstTestArray) < numberOfCharsToAdd){
            for (int i = 0; i < FirstTestArray.length; i++) {
                FirstTestArray[i] += 1;
            }
            if (getArraySum(FirstTestArray) == numberOfCharsToAdd){
                return  FirstTestArray;
            }
            if (getArraySum(FirstTestArray) > numberOfCharsToAdd){
                INumberFromFirstTest = FirstTestArray[0];
                break;
            }
        }

        //Second Test
        int []SecondTestArray = new int [numberOfSpacesInInitialSentence];
        int bodyElement = INumberFromFirstTest;
        int tailElement = INumberFromFirstTest - 1;

        //Array initialization [Body elements and the last one is Tail]
        for (int i = 0; i < SecondTestArray.length - 1; i++) {
            SecondTestArray[i] = INumberFromFirstTest;
        }
        SecondTestArray[SecondTestArray.length - 1] = tailElement; // Задали конечный элемент, который на единицу меньше чем все
        while (getArraySum(SecondTestArray) >= numberOfCharsToAdd && SecondTestArray[SecondTestArray.length - 1] > 0) {

            if (getArraySum(SecondTestArray) == numberOfCharsToAdd) {
                return SecondTestArray;
            }
            break;

        }

        //Third Test
        int[]ThirdTestArray = new int [numberOfSpacesInInitialSentence];
        tailElement = INumberFromFirstTest - 1;

        //Array initialization [Body elements except last two]
        for (int i = 0; i < SecondTestArray.length - 2; i++) {
            ThirdTestArray[i] = bodyElement;
        }

        ThirdTestArray[(ThirdTestArray.length - 1) - 1] = tailElement;
        ThirdTestArray[ThirdTestArray.length - 1] = tailElement;

        if (getArraySum(ThirdTestArray) == numberOfCharsToAdd){
            return ThirdTestArray;
        }

        ThirdTestArray[(ThirdTestArray.length - 1) - 2] = tailElement;

        if (getArraySum(ThirdTestArray) == numberOfCharsToAdd){
            return ThirdTestArray;
        }

        ThirdTestArray[(ThirdTestArray.length - 1) - 3] = tailElement;
        if (getArraySum(ThirdTestArray) == numberOfCharsToAdd){
            return ThirdTestArray;
        }

        ThirdTestArray[(ThirdTestArray.length - 1) - 4] = tailElement;
        return ThirdTestArray;
    }

    static String addBackspacesToSentence(String sentence, int setCharsValueInSentence){

        int sentenceLength = sentence.length();                        // определили длину
        int backspacesToAdd = setCharsValueInSentence - sentenceLength;// определили необходимое количество пробелов для добавления
        int numberOfBackSpacesInInitialSentence = 0;

        StringBuilder Sentence = new StringBuilder(sentence);
        Pattern pattern = Pattern.compile("[\\p{Blank}]");
        Matcher matcher = pattern.matcher(Sentence);
        Matcher matcher2 = pattern.matcher(Sentence);

        while(matcher.find()){
            numberOfBackSpacesInInitialSentence += 1;
        }

        int[] arrayWithSpacesIndexes = getArrayWithSpacesIndexes(backspacesToAdd, numberOfBackSpacesInInitialSentence);
        int backspacesToAddInTheBody = arrayWithSpacesIndexes[0];

        int addToStartIndexDueToExpanding = 0;
        int indexToAddBackSpace = 0;

        StringBuilder sentenceCopy = new StringBuilder(sentence);
        int numberOfCycles = 0;

        while(matcher2.find()){

            //основной блок (без учёта остатка от деления)
            indexToAddBackSpace = matcher2.start() + addToStartIndexDueToExpanding;
            sentenceCopy.insert(indexToAddBackSpace, getSpacedObject(arrayWithSpacesIndexes[numberOfCycles]));
            addToStartIndexDueToExpanding += arrayWithSpacesIndexes[numberOfCycles];
            numberOfCycles += 1;

        }

        return sentenceCopy.toString();
    }

        public static void main (String[] args){
            String initialText = Poem.text;
            String[] sentences = initialText.split("\n");
            int[] charCountInSentences = new int[sentences.length];
            for (int i = 0; i < sentences.length; i++) {
                charCountInSentences[i] = sentences[i].length();
            }

            int charsMaximumCount = getMaximumValue(charCountInSentences);

            for (int i = 0; i < sentences.length; i++) {
                System.out.println(addBackspacesToSentence(sentences[i],charsMaximumCount));
            }
        }
    }
