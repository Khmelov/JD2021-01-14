package by.it.petrov.JavaVocabulary;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class MainConsole {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numberOfWordsInTry = 50;
        ExerciseArray firstArray = new ExerciseArray(numberOfWordsInTry);
        System.out.println(Arrays.toString(firstArray.exerciseArrayDefs));
        System.out.println(Arrays.toString(firstArray.exerciseArrayWords));
    }
}
