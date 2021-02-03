package by.it.petrov.JavaVocabulary;

import java.io.IOException;

public class ExerciseArray {
    String[] exerciseArrayDefs;
    String[] exerciseArrayWords;
    ExerciseArray (Integer numberOfWordsInExercise) throws IOException {
        String[] exerciseArraysDefs = new String[numberOfWordsInExercise];
        String[] exerciseArrayWords = new String[numberOfWordsInExercise];
        InitialArrays ar = new InitialArrays();
        int numberOfRightAnswers = 0;
        for (int i = 0; i < ar.points.length; i++) {
            numberOfRightAnswers += ar.points[i];
        }
        Double[] chanceToBeChosen = new Double[ar.points.length];
        for (int i = 0; i < ar.points.length; i++) {
            chanceToBeChosen[i] =  ((double)ar.points[i] / numberOfRightAnswers);
        }
        for (int i = 0; i < numberOfWordsInExercise; i++) {
            boolean CreationIsFinished = false;
            while(!CreationIsFinished){
                int randomNumberInGivenRange = (int) Math.ceil(Math.random()*ar.points.length);
                if (chanceToBeChosen[randomNumberInGivenRange] > Math.random()){
                    exerciseArraysDefs[i] = ar.defs[randomNumberInGivenRange];
                    exerciseArrayWords[i] = ar.words[randomNumberInGivenRange];
                    break;
                }
            }
        }
        this.exerciseArrayDefs = exerciseArraysDefs;
        this.exerciseArrayWords = exerciseArrayWords;
    }
}
