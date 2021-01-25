package by.it.voitenkov.jd01_05;

import java.util.Arrays;

public class TaskC {

    public static void main(String[] args) {
        String nameArrayA = "A";
        String nameArrayB = "B";

        //task 1
        double[] array;
        double numberMin = 5.33;
        double numberMax = 9;
        double argument = 0.09;

        array = getArray(numberMin, numberMax, argument);
        printingArrayToString(array, nameArrayA);
        array = getArrayWithBigElement(array);
        printingArrayToColumn(array, nameArrayB);

        //task 2
        int[] arrayA;
        double[] arrayB;
        int sizeArray = 31;
        int startOfRangeOfNumbers = 103;
        int endOfRangeOfNumbers = 450;

        arrayA = getArrayA(sizeArray, startOfRangeOfNumbers, endOfRangeOfNumbers);
        printingArrayToStringTable(arrayA, nameArrayA);
        arrayB = getArrayB(arrayA);
        printingArrayToColumnTable(arrayB, nameArrayB);
    }

    static double[] getArray(double numberMin, double numberMax, double argument) {
        int sizeArray = (int) Math.floor((numberMax - numberMin) / 0.09);
        double[] arrayA = new double[sizeArray];
        int countIndex = 0;

        for (double i = numberMin; i < numberMax; i += argument) {
            if (countIndex < arrayA.length) {
                double z = Math.cbrt(Math.pow(i, 2) + 4.5);
                arrayA[countIndex++] = z;
            }
        }
        return arrayA;
    }

    static double[] getArrayWithBigElement(double[] array) {
        double bigElement = 3.5;
        double[] arrayB = new double[array.length];
        int countIndexArrayB = 0;

        for (double v : array) {
            if (v > bigElement) {
                arrayB[countIndexArrayB++] = v;
            }
        }
        arrayB = Arrays.copyOfRange(arrayB, 0, countIndexArrayB);
        return arrayB;
    }

    static int[] getArrayA(int sizeArray, int startOfRangeOfNumbers, int endOfRangeOfNumbers) {
        int[] array = new int[sizeArray];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * ((endOfRangeOfNumbers - startOfRangeOfNumbers) + 1) + startOfRangeOfNumbers);
        }
        return array;
    }

    static double[] getArrayB(int[] array) {
        double[] arrayB = new double[array.length];
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            double a = array[i] / 100.0 * 10;
            if (a > i) {
                arrayB[count++] = a;
            }
        }
        arrayB = Arrays.copyOfRange(arrayB, 0, count);
        Arrays.sort(arrayB);
        return arrayB;
    }

    static void printingArrayToString(double[] array, String nameArray) {
        int countColumn = 3;

        System.out.println("Array " + nameArray + " <index to rows>");

        for (int i = 0; i < array.length; i++) {
            if (i != 0 && i % countColumn == 0) {
                System.out.print("\n");
            }
            System.out.printf("%2s[ %-2d] = %-8.5f", nameArray, i, array[i]);
        }
        System.out.print("\n\n");
    }

    static void printingArrayToColumn(double[] array, String nameArray) {
        int countColumn = 5;
        int numberOfLines = (int) Math.ceil(array.length / (countColumn + 0.0));

        System.out.println("Array " + nameArray + " <index to cols>");

        for (int lines = 0; lines < numberOfLines; lines++) {
            for (int j = lines, countColumns = 0; countColumns < countColumn; j += numberOfLines, countColumns++) {
                if (lines != 0 && countColumns % countColumn == 0) {
                    System.out.print("\n");
                }
                System.out.printf("%2s[ %-2d] = %-8.5f", nameArray, j, array[j]);
            }
        }
        System.out.print("\n\n");
    }

    static void printingArrayToStringTable(int[] array, String nameArray) {
        int countColumn = 5;
        int numberOfLines = (int) Math.ceil(array.length / (countColumn + 0.0));
        int numberOfCharactersInACell = 18;
        String a = "═";
        a = a.repeat(numberOfCharactersInACell);

        System.out.println("Array " + nameArray + " <index to rows>");

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            //шапка
            if (i == 0) {
                System.out.printf("╔%s", a);
                while (count < countColumn - 1) {
                    System.out.printf("╦%s", a);
                    count++;
                }
                System.out.print("╗\n║");
            }
            //середина
            if (i != 0 && i % countColumn == 0) {
                System.out.printf("\n╠%s", a);

                while (count < countColumn - 1) {
                    System.out.printf("╬%s", a);
                    count++;
                }
                System.out.print("╣\n║");
                count = 0;
            }
            System.out.printf("%2s[ %-2d] = %-8d", nameArray, i, array[i]);
            System.out.print("║");
            // конец
            if (i == array.length - 1 && (countColumn * numberOfLines) != array.length) {
                while (count < (countColumn * numberOfLines) - array.length) {
                    System.out.printf("%s║", " ".repeat(numberOfCharactersInACell));
                    count++;
                    i++;
                }
                count = 0;
                System.out.printf("\n╚%s", a);

                while (count < countColumn - 1) {
                    System.out.printf("╩%s", a);
                    count++;
                }
                System.out.print("╝\n");
            }
        }
        System.out.print("\n");
    }

    static void printingArrayToColumnTable(double[] array, String nameArray) {
        int countColumn = 5;
        int numberOfLines = (int) Math.ceil(array.length / (countColumn + 0.0));
        int numberOfCharactersInACell = 18;
        String a = "═";
        a = a.repeat(numberOfCharactersInACell);

        System.out.println("Array " + nameArray + " <index to cols>");

        int count = 0;
        for (int lines = 0; lines < numberOfLines; lines++) {
            //шапка
            if (lines == 0) {
                System.out.printf("╔%s", a);
                while (count < countColumn - 1) {
                    System.out.printf("╦%s", a);
                    count++;
                }
                System.out.print("╗\n║");
                count = 0;
            }

            if (lines != 0 && (lines * countColumn) % countColumn == 0) {
                System.out.printf("\n╠%s", a);

                while (count < countColumn - 1) {
                    System.out.printf("╬%s", a);
                    count++;
                }
                System.out.print("╣\n║");
                count = 0;
            }

            for (int j = lines, countColumns = 0; countColumns < countColumn; j += numberOfLines, countColumns++) {
                if (j < array.length) {
                    System.out.printf("%2s[ %-2d] = %-8.5f", nameArray, j, array[j]);
                    System.out.print("║");
                } else {
                    while (countColumns < countColumn) {
                        System.out.printf("%s║", " ".repeat(numberOfCharactersInACell));
                        countColumns++;
                    }
                }
            }
            // конец
            if (lines == numberOfLines - 1) {
                System.out.printf("\n╚%s", a);
                while (count < countColumn - 1) {
                    System.out.printf("╩%s", a);
                    count++;
                }
                System.out.print("╝\n");
            }
        }
        System.out.print("\n");
    }
}