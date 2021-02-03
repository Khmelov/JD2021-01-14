package by.it.petrov.JavaVocabulary;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class MainConsole {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of words you want to learn: ");
        int numberOfWordsInTry = sc.nextInt();
        ExerciseArray firstArray = new ExerciseArray(numberOfWordsInTry);
        System.out.println("Not trimmed version is  " + Arrays.toString(firstArray.exerciseArrayDefs));
        System.out.println("Not trimmed version is  " + Arrays.toString(firstArray.exerciseArrayWords));
        System.out.println("Not trimmed version is  " + Arrays.toString(firstArray.indexesOfElementsFromInitialArrays));
        firstArray.TrimExerciseArray(0);
        System.out.println("Trimmed version is  " + Arrays.toString(firstArray.exerciseArrayDefs));
        System.out.println("Trimmed version is  " + Arrays.toString(firstArray.exerciseArrayWords));
        System.out.println("Trimmed version is  " + Arrays.toString(firstArray.indexesOfElementsFromInitialArrays));

    }
}
