package by.it.voitenkov.lessons.lesson_jd01_03;

import java.util.Arrays;

public class Matrices {

    public static void main(String[] args) {
        int[][] matrix1 = {{0, 1, -2}, {3, 2, 5}, {-1, 6, 0}};
        int[][] vector1 = {{2}, {4}, {1}};

        int[][] matrix2 = {{0, -5, 1}};
        int[][] vector2 = {{1}, {-1}, {3}};

        int[][] matrix3 = {{1}, {-1}, {3}};
        int[][] vector3 = {{0, -5, 1}};

        int[][] matrixA = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] matrixB = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[][] matrixA2 = {{1, 1, 1}, {2, 2, 2}};
        int[][] matrixB2 = {{1, 1}, {2, 2}, {3, 3}};

        int[][] matrixA3 = {{1, 1}, {2, 2}, {3, 3}};
        int[][] matrixB3 = {{1, 1, 1}, {2, 2, 2}};

        getMatrixMultipliedByMatrix(matrixA, matrixB);
        getMatrixMultipliedByMatrix(matrixA2, matrixB2);
        getMatrixMultipliedByMatrix(matrixA3, matrixB3);
        getMatrixMultipliedByVector(matrix1, vector1);
        getMatrixMultipliedByVector(matrix2, vector2);
        getMatrixMultipliedByVector(matrix3, vector3);
        getVector(matrix1, vector1);


    }

    static void getMatrixMultipliedByMatrix(int[][] matrixA, int[][] matrixB) {
        int[][] matrix = new int[matrixA.length][matrixB[matrixB.length - 1].length];
        boolean isMatricesSquare = isMatricesSquare(matrixA, matrixB);

        if (matrixA.length == matrixB[matrixB.length - 1].length) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrixA.length; j++) {
                    for (int k = 0; k < matrixB.length; k++) {
                        if (isMatricesSquare) {
                            matrix[i][j] += matrixA[j][k] * matrixB[k][j];

                        } else {
                            matrix[i][j] += matrixA[i][k] * matrixB[k][i];
                        }
                    }
                }
            }
            System.out.println(Arrays.deepToString(matrix));
        } else {
            System.out.println("Матрица " + Arrays.deepToString(matrixA));
        }
    }

    static int[][] getMatrixMultipliedByVector(int[][] matrix, int[][] vector) {
        int[] array;
        int[][] newVector;
        boolean isVectorColumn = false;
        int numberOfRowsInAMatrix = matrix.length;
        int numberOfColumnsInTheMatrix = matrix[matrix.length - 1].length;
        int linesInVector = vector.length;
        int columnsInVector = vector[vector.length - 1].length;


        if (columnsInVector == 1 && numberOfColumnsInTheMatrix == linesInVector) {
            newVector = new int[numberOfRowsInAMatrix][columnsInVector];
            array = new int[numberOfRowsInAMatrix];
            isVectorColumn = true;
        } else if (linesInVector == 1 && numberOfColumnsInTheMatrix == linesInVector) {
            newVector = new int[numberOfRowsInAMatrix][columnsInVector];
        } else {
            newVector = null;
            System.out.println("Вектор посчитать невозможно!");
        }

        if (newVector != null) {
            if (isVectorColumn) {
                for (int i = 0; i < columnsInVector; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        for (int k = 0; k < linesInVector; k++) {
                            newVector[j][i] += matrix[j][k] * vector[k][i];
                        }
                    }
                }
            } else {
                for (int i = 0; i < linesInVector; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        for (int k = 0; k < columnsInVector; k++) {
                            newVector[j][k] += matrix[j][i] * vector[i][k];
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(newVector));

        return vector;
    }

    static int[] getVector(int[][] matrix, int[][] vector) {
        int[] array;
        boolean isVectorColumn;
        int numberOfRowsInAMatrix = matrix.length;
        int numberOfColumnsInTheMatrix = matrix[matrix.length - 1].length;
        int linesInVector = vector.length;
        int columnsInVector = vector[vector.length - 1].length;

        if (columnsInVector == 1 && numberOfColumnsInTheMatrix == linesInVector) {
            array = new int[numberOfRowsInAMatrix];
            isVectorColumn = true;
        } else {
            isVectorColumn = false;
            array = null;
            System.out.println("Вектор посчитать невозможно!");
        }

        if (isVectorColumn) {
            for (int i = 0; i < columnsInVector; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    for (int k = 0; k < linesInVector; k++) {
                        array[j] += matrix[j][k] * vector[k][i];
                    }
                }
            }

        }

        System.out.println(Arrays.toString(array));

        return array;
    }

    static boolean isMatricesSquare(int[][] matrixA, int[][] matrixB) {
        return matrixA.length == matrixA[matrixA.length - 1].length &&
                matrixB.length == matrixB[matrixB.length - 1].length;
    }
}