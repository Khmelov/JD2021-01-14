package by.it.petrov.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static int getRandomNumberInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, (max + 1)).findFirst().getAsInt();
    }

    public static int[][] step1(int n) {

        int n_count_positive = 0;
        int n_count_negative = 0;
        int[][] twoDimArray = new int[n][n];

        while((n_count_negative == 0 | n_count_positive == 0)){

            for (int i = 0; i < twoDimArray.length; i++) { // Цикл генерации матрицы
                for (int j = 0; j < twoDimArray[0].length; j++) {
                    twoDimArray[i][j] = getRandomNumberInts(-n, n);
                }
            }
            for (int i = 0; i < twoDimArray.length; i++) { //Цикл вывода результата
                for (int j = 0; j < twoDimArray[0].length; j++) {
                    if (j != twoDimArray[0].length - 1) {
                        System.out.print(twoDimArray[i][j] + " ");
                    } else {
                        System.out.print(twoDimArray[i][j] + "\n");
                    }
                }
            }
            // запустим проверку матрицы на обязательное наличие -n и n элементов

            for (int i = 0; i < twoDimArray.length; i++) {
                for (int j = 0; j < twoDimArray[0].length; j++) {
                    if (twoDimArray[i][j] == n){
                        n_count_positive += 1;
                    }
                    if(twoDimArray[i][j] == -n){
                        n_count_negative += 1;
                    }
                }
            }
        }

        return twoDimArray;
    }

    private static int step2(int[][] arr) {
        int sum_of_two_numbers = 0;
        System.out.println("Okay, here we are ...");
        for (int i = 0; i < arr.length; i++) { //Ввод исходных данных для первой строки
            int quantityOfPN = 0;
            int j_first_PN = -1;
            int j_second_PN = -1;
            int check_for_positive_numbers = 0;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 0) {
                    check_for_positive_numbers += 1;
                }
            }
            if (check_for_positive_numbers < 2) {
                System.out.println("Not enough positive number for computing in row number  " + i);
            }
            if (check_for_positive_numbers == 0) {
                System.out.println("There are no any possible numbers in row number  " + i);
            }
            if (check_for_positive_numbers >= 2) {
                System.out.println("Checks have completed successfully");
                while (quantityOfPN < 2){
                    while(j_first_PN < 0){
                        for (int j = 0; j < arr[0].length; j++) {
                            if(arr[i][j] >= 0){
                                j_first_PN = j;
                                quantityOfPN += 1;
                                break;
                            }
                        }
                    }
                    while(j_second_PN < 0){
                        for (int j = j_first_PN + 1; j < arr[0].length; j++) {
                            if(arr[i][j] >= 0){
                                j_second_PN = j;
                                quantityOfPN += 1;
                                break;
                            }
                        }
                    }
                    System.out.println("i of first number is " + j_first_PN + " i of second number is " + j_second_PN);
                }
                if (j_second_PN - j_first_PN == 1){
                    System.out.println("The sum equals to zero due to difference between 1st and 2nd positive element equals to 0");
                }
                if (j_second_PN - j_first_PN > 1){
                    for (int j = j_first_PN + 1; j < j_second_PN; j++) {
                        sum_of_two_numbers += arr[i][j];
                        System.out.println("Accumulated value of sum is " + sum_of_two_numbers);
                    }
                }
            }
        }
        System.out.println(sum_of_two_numbers);
        return sum_of_two_numbers;
    }

    private static int[][] step3(int[][] arr) {
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > maxElement) {
                    maxElement = arr[i][j];
                }
            }
        }

        boolean[] checkRows = new boolean[arr.length];
        boolean[] checkColumns = new boolean[arr[0].length];
        int newRowsCount = 0;
        int newColumnsCount = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == maxElement) {
                    checkRows[i] = true;
                    checkColumns[j] = true;
                }
            }
        }

        for (boolean num : checkRows) {
            if (!num) {
                newRowsCount += 1;
            }
        }

        for (boolean num : checkColumns) {
            if (!num) {
                newColumnsCount += 1;
            }
        }

            int[][] newArray = new int[newRowsCount][newColumnsCount];
            for (int i = 0, ir = 0; i < arr.length; i++) {
                if (!checkRows[i]) {
                    for (int j = 0, jr = 0; j < arr[0].length; j++) {
                        if (!checkColumns[j]) {
                            newArray[ir][jr] = arr[i][j];
                            jr++;
                        }
                    }
                    ir++;
                }
            }
            return newArray;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] twoDimArray = step1(n);
        System.out.println(Arrays.deepToString(twoDimArray));
        /*int[][] twoDimArrayTest = new int[][]{{9, -1, 5, 2}, {0, 9, 1, 2}, {0, 0, 1, 1}, {1, 9, 0, 0}};
        step2(twoDimArray);
        System.out.println(Arrays.deepToString(step3(twoDimArray)));*/
    }
}