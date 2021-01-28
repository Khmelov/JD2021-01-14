package by.it.zevalich.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"V",3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        double[][] matrix = {{2,5},{3,2}};
        double[] vector = {5};
        Helper.mul(matrix,vector);
        double[][] matrixTwo = {{2,3},{3,4}};
        Helper.mul(matrix,matrixTwo);
    }
}
