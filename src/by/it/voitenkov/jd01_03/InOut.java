package by.it.voitenkov.jd01_03;

import java.util.Arrays;

public class InOut {

    static double[] getArray(String line) {
        String[] arrayString = line.split(" ");
        double[] array = new double[arrayString.length];

        for (int i = 0; i < arrayString.length; i++) {
            array[i] = Double.parseDouble(arrayString[i]);
        }
        return array;
    }

    static void printArray(double[] arr) {
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%d] = %-12.2f", name, i, arr[i]);

            if ((i + 1) % columnCount == 0 || i + 1 == arr.length) {
                System.out.printf("\n");
            }
        }
        System.out.println();
    }
}