package by.it.lapushkin.jd01_04;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMulTable();

        String line = scanner.nextLine();

        System.out.println();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);

        double firstIndex = array[0];
        double lastIndex = array[array.length - 1];

        InOut.printArray(array, "V", 5);

        Helper.sort(array);
        InOut.printArray(array, "V", 4);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstIndex) {
                System.out.println("first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == lastIndex) {
                System.out.println("last element=" + i);
                break;
            }
        }


    }
}
