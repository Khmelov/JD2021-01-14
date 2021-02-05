package by.it.petrov.JavaVocabulary;

import java.io.File;
import java.io.IOException;

public class InitialArrays {

    String[] defs = FileOperator.readFileIntoStringArray("def.txt");
    String[] words = FileOperator.readFileIntoStringArray("words.txt");
    Integer[] points = FileOperator.readFileIntoIntegerArray("points.txt");

    public InitialArrays() throws IOException {
    }
}
