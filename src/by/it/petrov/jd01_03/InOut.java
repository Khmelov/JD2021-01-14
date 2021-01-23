package by.it.petrov.jd01_03;

import java.util.Arrays;

public class InOut {
    static double[] getArray(String line){
        String[] arrayString = line.split(" ");
        double[] arrayDouble = new double[arrayString.length];
        for (int i = 0; i < arrayDouble.length; i++) {
            arrayDouble[i] = Double.parseDouble(arrayString[i]);
        }
        return arrayDouble;
    }

    static void printArray(double[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%-1d] = %-10.2f", name, i, arr[i]);
            if ((i+1) % columnCount == 0 || i+1 == arr.length){
                System.out.println();
            }
        }
    }
}
