package by.it.petrov.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double[] doubleArray = InOut.getArray(line);
        InOut.printArray(doubleArray);
        InOut.printArray(doubleArray, "V", 5);
        double [] newDoubleArray = new double[]{9, 5, 55, 71, -100, 15, -105};
        System.out.println(Helper.findMin(newDoubleArray));
        System.out.println(Helper.findMax(newDoubleArray));
        Helper.sort(newDoubleArray);

        double[][] matrix = new double[][]{{1, 2}, {3, 4}};
        double[] vector = new double[]{10, 10};
        System.out.println(Arrays.toString(Helper.mul(matrix, vector)));

        double [][] leftMatrix = new double[][]{{1, 2, 3}, {4, 5, 6}};
        double [][] rightMatrix = new double[][]{{1, 2}, {3, 4}, {5, 6}};
        double [][] multipliedMatrix = Helper.mul(leftMatrix, rightMatrix);
        System.out.println(Arrays.deepToString(multipliedMatrix));

    }
}
