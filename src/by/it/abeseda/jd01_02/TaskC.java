package by.it.abeseda.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = step1(n);
        step2(array);
        step3(array);


    }

    private static int[][] step3(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int element : row) {
                if (max < element) {
                    max = element;
                }
            }
        }
        boolean[] skipRow = new boolean[array.length];
        boolean[] skipCol = new boolean[array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max == array[i][j]) {
                    skipRow[i] = true;
                    skipCol[j] = true;
                }
            }
        }
        int rows = 0;
        for (boolean skip : skipRow)
            if (!skip)
                rows++;


        int coln = 0;
        for (boolean skip : skipCol)
            if (!skip)
                coln++;

        int[][] res = new int[rows][coln];
        for (int i = 0, ir = 0; i < array.length; i++) {
            if (!skipRow[i]) {
                for (int j = 0, jr = 0; j < array[i].length; j++) {
                    if (!skipCol[j]) {
                        res[ir][jr++] = array[i][j];
                    }
                }
                ir++;
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.print("\n");
        }
 //       System.out.println(Arrays.deepToString(res));
        return res;
    }

    private static int step2(int[][] array) {
        int total = 0;//int total1=-9;
        for (int[] row : array) {
            int positiveCount = 0;//+1
            int sum = 0;//-5-4
            for (int element : row) {
                if (element > 0) {
                    positiveCount++;
                } else if (positiveCount == 1) {
                    sum += element;
                }
                if (positiveCount == 2) {
                    total = total + sum;
                    break;
                }
            }
        }
        System.out.println(total);
        return total;
    }

    private static int[][] step1(int n) {
        int[][] twoDimensionArray = new int[n][n];
        boolean maxOk = false;
        boolean minOk = false;
        do {

            for (int i = 0; i < twoDimensionArray.length; i++) {
                for (int j = 0; j < twoDimensionArray[i].length; j++) {
                    twoDimensionArray[i][j] = calculateRandomNumber(n);


                    if (twoDimensionArray[i][j] == n) {
                        maxOk = true;
                    }
                    if (twoDimensionArray[i][j] == -n) {
                        minOk = true;
                    }
                }
            }
        } while (!maxOk && !minOk);//повторять пока не станет minOk=true
//        System.out.println(Arrays.deepToString(twoDimensionArray));
        for (int i = 0; i < twoDimensionArray.length; i++) {
            for (int j = 0; j < twoDimensionArray[i].length; j++) {
                System.out.print(twoDimensionArray[i][j]+" ");
            }
            System.out.print("\n");
        }
        return twoDimensionArray;
    }

    private static int calculateRandomNumber(int n) {
        return -n + (int) (Math.random() * (2 * n + 1));
    }
}

