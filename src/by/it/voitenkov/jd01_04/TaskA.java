package by.it.voitenkov.jd01_04;

import by.it.voitenkov.lessons.lesson_jd01_01.SortingArray;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        int sum = 0;
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                sum = i * j;
                if (j % 9 != 0) {
                    System.out.printf("%d*%d=%-2d%1s", i, j, sum, "");
                } else {
                    System.out.printf("%d*%d=%-2d", i, j, sum);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static void buildOneDimArray(String line) {
        String[] arrayLine = line.split(" ");
        double firstNumberBeforeSortingTheArray;
        double lastNumberBeforeSortingTheArray;
        double[] arrayNumbers = new double[arrayLine.length];

        for (int i = 0; i < arrayLine.length; i++) {
            arrayNumbers[i] = Double.parseDouble(arrayLine[i]);
        }

        firstNumberBeforeSortingTheArray = arrayNumbers[0];
        lastNumberBeforeSortingTheArray = arrayNumbers[arrayNumbers.length - 1];

        InOut.printArray(arrayNumbers, "V", 5);
        Helper.sort(arrayNumbers);
        InOut.printArray(arrayNumbers, "V", 4);

        for (int i = 0; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i] == firstNumberBeforeSortingTheArray) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }

        for (int i = 0; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i] == lastNumberBeforeSortingTheArray) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }
}
