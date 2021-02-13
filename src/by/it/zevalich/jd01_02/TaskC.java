package by.it.zevalich.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = step1(n);

    }

    private static int[][] step1(int n) {
        int[][] res = new int[n][n];
        boolean max;
        boolean min;
        do {
            max = false;
            min = false;
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                    if (res[i][j] == -n) min = true;
                    if (res[i][j] == n) max = true;
                }
            }
        } while (!max || !min);
        System.out.println(Arrays.deepToString(res));
        return res;
    }



}