package by.it.petrov.JavaVocabulary;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class TakeTask {
    public void doTask(int numberOfWordsToLearn, int numberOfRightAnswersToFinish) throws IOException {
        Scanner sc = new Scanner(System.in);
        InitialArrays ar = new InitialArrays();
        ExerciseArray ea = new ExerciseArray(numberOfWordsToLearn);
        while(ea.exerciseArrayWords.length >= 2){
            int randomTry = (int) (Math.random()*ea.exerciseArrayWords.length);
            System.out.println("Translate it: " + ea.exerciseArrayWords[randomTry]);
            String userInput = sc.nextLine().trim().toLowerCase(Locale.ROOT);
            if (userInput.equals(ea.exerciseArrayDefs[randomTry].trim().toLowerCase(Locale.ROOT))){
                System.out.println("That's right!");
                ar.ModifyInitialPointsArray(ea.indexesOfElementsFromInitialArrays[randomTry]);
                ea.ModifyNumberOfActualCorrectAnswersInExercise(randomTry);
                if (ea.numberOfActualCorrectAnswersInExercise[randomTry] >= numberOfRightAnswersToFinish){
                    ea.TrimExerciseArray(randomTry);
                    System.out.println("Remaining count of words in exercise: " + ea.exerciseArrayWords.length);
                    continue;
                }
                continue;
            }
            System.out.println("****** INCORRECT! ****** \n The right answer was \"" + ea.exerciseArrayDefs[randomTry] + "\"\n");
            if (ea.exerciseArrayDefs[randomTry].length() >= 20) {
                System.out.print("Do you agree? (type NO to take a point)");
                if (sc.nextLine().toLowerCase(Locale.ROOT).equals("no")) {
                    ar.ModifyInitialPointsArray(ea.indexesOfElementsFromInitialArrays[randomTry]);
                    ea.ModifyNumberOfActualCorrectAnswersInExercise(randomTry);
                    if (ea.numberOfActualCorrectAnswersInExercise[randomTry] >= numberOfRightAnswersToFinish) {
                        ea.TrimExerciseArray(randomTry);
                        System.out.println("Remaining count of words in exercise: " + ea.exerciseArrayWords.length);
                    }
                }
            }
        }
        System.out.println("The exercise is ended. Congratulations!");
    }
}