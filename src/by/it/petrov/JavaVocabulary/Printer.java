package by.it.petrov.JavaVocabulary;

import java.io.IOException;

public class Printer {
    public static void printStatistics() throws IOException {
        InitialArrays ar = new InitialArrays();
        int numberOfWordsInVocabulary = ar.words.length;
        int numberOfRightAnswers = 0;
        for (int i = 0; i < ar.points.length; i++) {
          numberOfRightAnswers += ar.points[i];
        }
        System.out.printf("Total number of words in vocabulary: %1$-6d%2$s%n",numberOfWordsInVocabulary, "words");
        System.out.printf("Total number of correct answers:     %1$-6d%2$s%n",numberOfRightAnswers, "answers");
    }
}