package by.it.voitenkov.jd01_03;

import by.it.voitenkov.lessons.lesson_jd01_01.SortingArray;

import java.util.Arrays;

public class Helper {

    static double findMin(double[] array) {
        double minNumber = Double.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minNumber) {
                minNumber = array[i];
            }
        }
        return minNumber;
    }

    static double findMax(double[] array) {
        double maxNumber = Double.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
            }
        }
        return maxNumber;
    }

    static void sort(double[] array) {
        SortingArray.sortBubble(array, true);
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] array = new double[0];
        int numberOfRowsInAMatrix = matrix.length;
        int numberOfColumnsInTheMatrix = matrix[matrix.length - 1].length;
        int linesInVector = vector.length;

        if (numberOfColumnsInTheMatrix == linesInVector) {
            array = new double[numberOfRowsInAMatrix];
            for (int j = 0; j < numberOfRowsInAMatrix; j++) {
                for (int k = 0; k < linesInVector; k++) {
                    array[j] += matrix[j][k] * vector[k];
                }
            }
        } else {
            System.out.println("Вектор посчитать невозможно!");
        }
        return array;
    }

    static double[][] mul(double[][] matrixA, double[][] matrixB) {
        double[][] matrix = new double[matrixA.length][matrixB[matrixB.length - 1].length];
        boolean isMatricesSquare = isMatricesSquare(matrixA, matrixB);

        if (matrixA.length == matrixB[matrixB.length - 1].length) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrixA.length; j++) {
                    for (int k = 0; k < matrixB.length; k++) {
                        if (isMatricesSquare) {
                            matrix[i][j] += matrixA[j][k] * matrixB[k][j];

                        } else {
                            matrix[i][j] += matrixA[i][k] * matrixB[k][j];
                        }
                    }
                }
            }
        } else {
            System.out.println("Матрица " + Arrays.deepToString(matrixA));
        }
        return matrix;
    }

    static boolean isMatricesSquare(double[][] matrixA, double[][] matrixB) {
        return matrixA.length == matrixA[matrixA.length - 1].length &&
                matrixB.length == matrixB[matrixB.length - 1].length;
    }
}