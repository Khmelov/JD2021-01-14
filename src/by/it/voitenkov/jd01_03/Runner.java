package by.it.voitenkov.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        double[] array;
        double minimumArrayNumber;
        double maximumArrayNumber;
        double[] vector = {1, 2, 3};
        double[][] matrixA = {{1, 2, 3}, {4, 5, 6}};
        double[][] matrixB = {{22.0, 22.0}};
        double[][] matrixA2 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        double[][] matrixB2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Scanner scanner = new Scanner(System.in);

        array = InOut.getArray(scanner.nextLine());
        InOut.printArray(array);
        InOut.printArray(array, "array", 3);
        minimumArrayNumber = Helper.findMin(array);
        maximumArrayNumber = Helper.findMax(array);
        Helper.mul(matrixA, vector);
        Helper.mul(matrixA, matrixB);
        System.out.println(Arrays.deepToString(Helper.mul(matrixA2, matrixB2)));
    }
}