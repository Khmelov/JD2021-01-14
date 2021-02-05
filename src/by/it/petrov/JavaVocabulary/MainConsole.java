package by.it.petrov.JavaVocabulary;

import java.io.IOException;
import java.util.Scanner;

public class MainConsole {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Printer.printStatistics();
        System.out.print("Enter number of words you want to learn: ");
        int numberOfWordsInTry = sc.nextInt();
        System.out.print("Enter number of needed right answers to a certain word or expression: ");
        int numberOfNeededRightAnswers = sc.nextInt();
        System.out.println("Okay, let's have started!");
        TakeTask tt = new TakeTask();
        tt.doTask(numberOfWordsInTry, numberOfNeededRightAnswers);
    }
}