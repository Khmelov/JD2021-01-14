package by.it.tashtsimirov.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        System.out.println("Введите ряд произвольных чисел через пробел:");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);

        InOut.printArray(array);
        InOut.printArray(array,"Nazva",2);

        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);




        System.out.println("\n\n-- Задание С --");

        System.out.println("Введите через пробел четыре числа, где первое число это количество \n" +
                "строк матрицы А, второе число - кол. столбцов матрицы А, третье число - кол. строк \n" +
                "матрицы (вектора) Б, четвёртое число будет количеством столбцов матрицы Б (если вектор, то = 1):");

        Scanner sc = new Scanner(System.in);
        int leftI = sc.nextInt();
        int leftJ = sc.nextInt();
        int rightI = sc.nextInt();
        int rightJ = sc.nextInt();

        if (leftI <= 0) { leftI = -1*leftI; }
        if (leftI <= 0) { leftJ = -1*leftJ; }
        if (rightI <= 0) { rightI = -1*leftI; }
        if (rightJ <= 0) { rightJ = -1*leftI; }

        double[][] matrixLeft = new double[leftI][leftJ];
        double[][] matrixRight = new double[rightI][rightJ];
        double[] vector = new double[rightI];

        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixLeft[i].length; j++) {
                matrixLeft[i][j] = (leftI + Math.random()*leftJ);
            }
        }

        for (int i = 0; i < matrixRight.length; i++) {
            for (int j = 0; j < matrixRight[i].length; j++) {
                matrixRight[i][j] = (rightI + Math.random()*rightJ);
            }
        }

        for (int j = 0; j < vector.length; j++) {
                vector[j] = (rightI + Math.random()*rightJ);
        }

        System.out.println("Это вектор: " + Arrays.toString(vector));

        System.out.println("Ваша первая матрица размерностью " + leftI + "x" + leftJ + ": " + Arrays.deepToString(matrixLeft));
        System.out.println("Ваша вторая матрица размерностью " + rightI + "x" + rightJ + ": " + Arrays.deepToString(matrixRight));

        System.out.println("Произведение матриц А и Б - матрица размерностью " + leftI + "x" + rightJ + ": " + Arrays.deepToString(Helper.mul(matrixLeft, matrixRight)));

        System.out.println("Произведение матрицы и вектора: " + Arrays.toString(Helper.mul(matrixLeft, vector)));

    }




}
