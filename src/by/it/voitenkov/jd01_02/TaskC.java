package by.it.voitenkov.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        int[][] matrix;
        int sizeMatrix;

        Scanner scanner = new Scanner(System.in);
        sizeMatrix = scanner.nextInt();
        matrix = step1(sizeMatrix);
        System.out.println(step2(matrix));
        matrix = step3(matrix);
    }

    static int[][] step1(int sizeMatrix) {
        int[][] matrix = new int[sizeMatrix][sizeMatrix];
        boolean negativeNumber = false;
        boolean positiveNumber = false;
        int randomNumber;

        while (!negativeNumber || !positiveNumber) {
            negativeNumber = false;
            positiveNumber = false;

            for (int lineIndex = 0; lineIndex < matrix.length; lineIndex++) {
                for (int columnIndex = 0; columnIndex < matrix[lineIndex].length; columnIndex++) {
                    randomNumber = getRandomNumber(sizeMatrix);
                    matrix[lineIndex][columnIndex] = randomNumber;

                    if (randomNumber == sizeMatrix) {
                        negativeNumber = true;
                    } else if (randomNumber == (sizeMatrix * -1)) {
                        positiveNumber = true;
                    }
                }
            }
        }
        printMatrix(matrix);
        return matrix;
    }

    static int step2(int[][] matrix) {
        int summaElements = 0;

        for (int lineIndex = 0; lineIndex < matrix.length; lineIndex++) {
            boolean isFirstPositiveElement = false;

            for (int columnIndex = 0; columnIndex < matrix[lineIndex].length; columnIndex++) {
                int number = matrix[lineIndex][columnIndex];

                if (number > 0 && !isFirstPositiveElement) {
                    isFirstPositiveElement = true;
                } else if (number < 0 && isFirstPositiveElement) {
                    summaElements += number;
                } else if (number > 0) {
                    isFirstPositiveElement = false;
                    break;
                }
            }
        }
        return summaElements;
    }

    static int[][] step3(int[][] matrix) {
        int[][] newMatrix;
        int[] arrayLine1 = new int[matrix.length];
        int[] arrayColumns1 = new int[matrix.length];
        int maximumElement = Integer.MIN_VALUE;
        int numberOfLines = 0;
        int numberOfColumns = 0;

        //находим максимальное число в массиве
        for (int lineIndex = 0; lineIndex < matrix.length; lineIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[lineIndex].length; columnIndex++) {
                int number = matrix[lineIndex][columnIndex];

                if (number > maximumElement) {
                    maximumElement = number;
                }
            }
        }

        // находим номер строки с максимальным числом и добавляем в массив строк.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int number = matrix[i][j];

                if (number == maximumElement) {
                    arrayLine1[numberOfLines] = i;
                    numberOfLines++;
                    break;
                }
            }
        }

        // находим номер столбца с максимальным числом и добавляем в массив столбцов.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int number = matrix[j][i];

                if (number == maximumElement) {
                    arrayColumns1[numberOfColumns] = i;
                    numberOfColumns++;
                    break;
                }
            }
        }
        //создаем новую матрицу
        newMatrix = new int[matrix.length - numberOfLines][matrix.length - numberOfColumns];

        // создаем новый массив со строками (т.к. arrayLine1 имеет пустые ячейки)
        int[] arrayLine2 = new int[numberOfLines];
        for (int i = 0; i < numberOfLines; i++) {
            arrayLine2[i] = arrayLine1[i];
        }

        // создаем новый массив со строками (т.к. arrayColumns1 имеет пустые ячейки)
        int[] arrayColumns2 = new int[numberOfColumns];
        for (int i = 0; i < numberOfColumns; i++) {
            arrayColumns2[i] = arrayColumns1[i];
        }
        //счетчик индексов для копирования чисел в массив matrix2
        int indexLineNewMatrix = 0;
        int indexColumnNewMatrix = 0;

        for (int i = 0; i < matrix.length; i++) {
            boolean validString = true;    //в строке имеется максимальное число?

            for (int i2 = 0; i2 < arrayLine2.length; i2++) {    // проверка
                if (i == arrayLine2[i2]) {
                    validString = false;
                }
            }

            if (validString) {
                for (int j = 0; j < matrix[i].length; j++) {
                    boolean validColumn = true;   //в столбце имеется максимальное число?

                    for (int j2 = 0; j2 < arrayColumns2.length; j2++) {     //проверка
                        if (j == arrayColumns2[j2]) {
                            validColumn = false;
                        }
                    }

                    if (validColumn) {
                        newMatrix[indexLineNewMatrix][indexColumnNewMatrix] = matrix[i][j];
                        indexColumnNewMatrix++;
                    }
                }
                indexLineNewMatrix++;
                indexColumnNewMatrix = 0;
            }
        }
        printMatrix(newMatrix);
        return newMatrix;
    }

    static int getRandomNumber(int sizeMatrix) {
        int maximumRange = (int) (Math.random() * (sizeMatrix + 1));
        int minimumRange = (int) (Math.random() * (sizeMatrix + 1));
        return maximumRange - minimumRange;
    }

    static void printMatrix(int[][] matrix) {
        for (int lineIndex = 0; lineIndex < matrix.length; lineIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[lineIndex].length; columnIndex++) {
                System.out.print(matrix[lineIndex][columnIndex] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}