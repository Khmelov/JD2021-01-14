package by.it.petrov.JavaVocabulary;

import java.io.IOException;

public class InitialArrays {
    String[] defs = FileOperator.readFileIntoStringArray("def.txt");
    String[] words = FileOperator.readFileIntoStringArray("words.txt");
    Integer[] points = FileOperator.readFileIntoIntegerArray("points.txt");
    public InitialArrays() throws IOException {
    }
    public void ModifyInitialPointsArray(int numberOfElementToModify) throws IOException {
        this.points[numberOfElementToModify] += 1;
        FileOperator.writePointsIntoFile(this.points);
    }
}