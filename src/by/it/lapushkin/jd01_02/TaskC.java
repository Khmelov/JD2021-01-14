package by.it.lapushkin.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        int[][] matrix;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        matrix = step1(n);

        step2(matrix);

        step3(matrix);
    }


    private static int[][] step1(int n) {
        int[][] matrix;

        do {
            matrix = generateMatrix(n);

        } while (!checkMatrix(matrix));

        printMatrix(matrix);

        return matrix;
    }

    private static int step2(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] posIndex = new int[]{-1, -1};
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > 0) {
                    if (posIndex[0] == -1) {
                        posIndex[0] = j;

                    } else {
                        posIndex[1] = j;
                        break;
                    }
                }
            }

            if (posIndex[0] != -1 && posIndex[1] != -1) {
                for (int k = posIndex[0] + 1; k < posIndex[1]; k++) {
                    sum += matrix[i][k];
                }
            }
        }

        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] matrix) {

        int max = findMax(matrix);

        //for columns
        int[][] tempMatrix = matrix;

        while (findRow(matrix, max) >= 0) {
            matrix = removeRow(matrix, findRow(matrix, max));
        }
        while (findColumns(tempMatrix, max) >= 0) {
            tempMatrix = matrix = removeColumn(matrix, findColumns(tempMatrix, max));
        }

        printMatrix(matrix);

        return matrix;
    }


    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //System.out.print(matrix[i][j] + "\t");
                System.out.printf("%5d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean checkMatrix(int[][] matrix) {
        boolean checkPos = false;
        boolean checkCon = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == matrix.length) {
                    checkPos = true;
                }
                if (matrix[i][j] == -matrix.length) {
                    checkCon = true;
                }
            }
        }
        return checkPos && checkCon;
    }

    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * (n * 2 + 1)) - n;
            }
        }
        return matrix;
    }

    private static int[][] removeColumn(int[][] matrix, int column) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length - 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, k = 0; j < matrix[i].length; j++) {
                if (column != j && j != matrix[i].length) {
                    newMatrix[i][k++] = matrix[i][j];
                }
            }
        }

        return newMatrix;
    }

    private static int[][] removeRow(int[][] matrix, int row) {
        int[][] newMatrix = new int[matrix.length - 1][matrix.length];

        for (int i = 0; i < newMatrix.length; i++) {
            if (i < row) {
                newMatrix[i] = matrix[i];
            }
            if (i >= row) {
                newMatrix[i] = matrix[i + 1];
            }
        }

        return newMatrix;
    }

    private static int findRow(int[][] matrix, int max) {
        int index = -1;
        boolean find = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == max) {
                    index = i;
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }
        return index;
    }

    private static int findColumns(int[][] matrix, int max) {
        int index = -1;
        boolean find = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == max) {
                    index = j;
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }
        return index;
    }

    private static int findMax(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }
}
