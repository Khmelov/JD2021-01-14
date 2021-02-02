package by.it.tashtsimirov.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0) { n = -1*n; } 
        int[][] arr = new int[n][n];

        step1(n);
    }

    private static int[][] step1(int n) {

        int[][] newMatrix = new int[n][n];


        boolean found = false;

        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    newMatrix[i][j] = (int) (Math.random() * (1 + n - (-1 * n))) + (-1 * n);
                    if (newMatrix[i][j] == n && newMatrix[i][j] == (n*-1)) { found = true; }
                }
            }
            System.out.println(Arrays.deepToString(newMatrix));
        } while (found);

        return newMatrix;



    }
}
