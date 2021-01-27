package by.it.petrov.jd01_04;

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

    static int[] getArrayInt(String line){
        String[] arrayString = line.split(" ");
        int[] arrayInt = new int[arrayString.length];
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = Integer.parseInt(arrayString[i]);
        }
        return arrayInt;
    }

    static void printArray(double[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%-1d]=%-7.2f", name, i, arr[i]);
            if ((i+1) % columnCount == 0 || i+1 == arr.length){
                System.out.println();
            }
        }
    }
}
