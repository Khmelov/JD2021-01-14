package by.it.petrov.JavaVocabulary;

import java.io.IOException;

public class ExerciseArray {
    String[] exerciseArrayDefs;
    String[] exerciseArrayWords;
    int[] indexesOfElementsFromInitialArrays;
    int[] numberOfActualCorrectAnswersInExercise;
    ExerciseArray (Integer numberOfWordsInExercise) throws IOException {
        String[] exerciseArraysDefs = new String[numberOfWordsInExercise];
        String[] exerciseArrayWords = new String[numberOfWordsInExercise];
        int[] indexesOfElementsFromInitialArrays = new int[numberOfWordsInExercise];
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
                int randomNumberInGivenRange = (int) (Math.random()*ar.points.length);
                if (chanceToBeChosen[randomNumberInGivenRange] < Math.random()){
                    exerciseArraysDefs[i] = ar.defs[randomNumberInGivenRange];
                    exerciseArrayWords[i] = ar.words[randomNumberInGivenRange];
                    indexesOfElementsFromInitialArrays[i] = randomNumberInGivenRange;
                    CreationIsFinished = true;
                }
            }
        }
        this.numberOfActualCorrectAnswersInExercise = new int [numberOfWordsInExercise];
        this.exerciseArrayDefs = exerciseArraysDefs;
        this.exerciseArrayWords = exerciseArrayWords;
        this.indexesOfElementsFromInitialArrays = indexesOfElementsFromInitialArrays;
    }
    public void TrimExerciseArray(int indexOfElementToTrim){
        String[] trimmedExerciseArrayDefs = new String[exerciseArrayWords.length - 1];
        String[] trimmedExerciseArrayWords = new String[exerciseArrayWords.length - 1];;
        int[] trimmedIndexesOfElementsFromInitialArrays = new int[exerciseArrayWords.length - 1];
        int[] trimmedNumberOfActualCorrectAnswersInExercise = new int[exerciseArrayWords.length - 1];
        for (int i = 0; i < indexOfElementToTrim; i++) {
            trimmedExerciseArrayDefs[i] = this.exerciseArrayDefs[i];
            trimmedExerciseArrayWords[i] = this.exerciseArrayWords[i];
            trimmedIndexesOfElementsFromInitialArrays[i] = this.indexesOfElementsFromInitialArrays[i];
            trimmedNumberOfActualCorrectAnswersInExercise[i] = this.numberOfActualCorrectAnswersInExercise[i];
        }
        for (int i = indexOfElementToTrim + 1; i < exerciseArrayWords.length ; i++) {
            trimmedExerciseArrayDefs[i-1] = this.exerciseArrayDefs[i];
            trimmedExerciseArrayWords[i-1] = this.exerciseArrayWords[i];
            trimmedIndexesOfElementsFromInitialArrays[i-1] = this.indexesOfElementsFromInitialArrays[i];
            trimmedNumberOfActualCorrectAnswersInExercise[i-1] = this.numberOfActualCorrectAnswersInExercise[i];
        }
        this.exerciseArrayWords = trimmedExerciseArrayWords;
        this.exerciseArrayDefs = trimmedExerciseArrayDefs;
        this.numberOfActualCorrectAnswersInExercise = trimmedNumberOfActualCorrectAnswersInExercise;
        this.indexesOfElementsFromInitialArrays = trimmedIndexesOfElementsFromInitialArrays;
    }
    public void ModifyNumberOfActualCorrectAnswersInExercise(int numberOfElementToModify){
        this.numberOfActualCorrectAnswersInExercise[numberOfElementToModify] += 1;
    }
}