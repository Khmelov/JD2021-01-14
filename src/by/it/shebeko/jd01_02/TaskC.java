package by.it.shebeko.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] [] array = step1(n);
        int sum = step2 (array);
        step3(array);          //???

    }



    static int[] [] step1(int n){
        int arr [] [] = new int[n] [n];

        boolean min;
        boolean max;
        do {
            max = false;
            min = false;
            for (int i = 0; i < arr.length; i++) {     //заполним массив фор и
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = -n + (int)(Math.random() * (2 * n + 1));
                    if (arr[i] [j] == n) max = true;
                    if (arr[i] [j] == -n) min = true;

                }
                
            }

        } while (!min || !max);
        System.out.println(Arrays.deepToString(arr));
        return arr;

    }



    private static int step2(int[][] array) {
        int total = 0;      //тотал сумма всех эл
        for (int[] row : array) {      //перебираем строки в массиве
            int positiveCount = 0;
            int sum = 0;
            for (int element : row) {   // переб элементы в каждой строке
                if (element > 0) {       // если б нуля то положит
                    positiveCount++;
                }
                else if (positiveCount == 1){      //нашли один элемент
                    sum = sum + element;   //sum+=element   сам сумма эл в строке
                }
                if (positiveCount == 2){
                    total = total + sum;
                    break;
                }
            }

        }
        return total;
    }

    private static int[][] step3 (int[] [] arr){
        int max = Integer.MIN_VALUE;
        for (int[] row : arr) {
            for (int element : row) {
                if (max < element){
                    max = element;
                }
            }
        }
        boolean[] skipRow = new boolean[arr.length];
        boolean[] skipCol = new boolean[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max == arr[i] [j]) {
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

        int[] [] res = new int[rows] [cols];
        for (int i = 0, ir = 0; i < arr.length; i++) {
            if (!skipRow[i]) {
                for (int j = 0, jr = 0; j < arr[i].length; j++) {
                    if (!skipCol[j]) {
                        res[ir] [jr++] = arr[i] [j];
                    }

                }
                ir++;
            }

        }
        System.out.println(Arrays.deepToString(res));
        return res;
    }

}
