package by.it._classwork_.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = step1(n);
        int sum = step2(array);

    }

    private static int step2(int[][] array) {
        int total = 0;
        for (int[] row : array) {
            int positiveCount = 0;
            int sum = 0;
            for (int element : row) {
                if (element > 0) {
                    positiveCount++;
                } else {
                    if (positiveCount == 1) {
                        sum += element;
                    }
                }

                if (positiveCount == 2) {
                    total += sum;
                    break;
                }

            }
        }
        return total;
    }

    private static int[][] step1(int n) {
        int[][] res = new int[n][n];
        boolean maxOk;
        boolean minOk;
        do {
            maxOk = false;
            minOk = false;
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                    if (res[i][j] == -n) minOk = true;
                    if (res[i][j] == n) maxOk = true;
                }
            }
        } while (!maxOk || !minOk);
        System.out.println(Arrays.deepToString(res));

        return res;
    }

    static int[][] step3(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int[] row : arr) {
            for (int element : row) {
                if (max < element) {
                    max = element;
                }
            }
        }
        boolean[] skipRow = new boolean[arr.length];
        boolean[] skipCol = new boolean[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max == arr[i][j]) {
                    skipRow[i] = true;
                    skipCol[j] = true;
                }
            }
        }

        int rows = 0;
        for (boolean skip : skipRow)
            if (!skip)
                rows++;

        int cols = 0;
        for (boolean skip : skipCol)
            if (!skip)
                cols++;

        int[][] res = new int[rows][cols];
        for (int i = 0, ir = 0; i < arr.length; i++) {
            if (!skipRow[i]) {
                for (int j = 0, jr = 0; j < arr[i].length; j++) {
                    if (!skipCol[j]) {
                        res[ir][jr++] = arr[i][j];
                    }
                }
                ir++;
            }
        }

        return res;
    }
}
