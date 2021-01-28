package by.it.zevalich.jd01_02;


import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = step1(n);
        step2(array);


    }

    static int[][] step1(int n) {
        int[][] array = new int[n][n];
        Random r = new Random();
        boolean isN = false;
        boolean isM = false;
        do {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = r.nextInt((n - (-n) + 1) -n);
                    if (array[i][j] == n) {
                        isN = true;
                    }
                    if (array[i][j] == -n) {
                        isM = true;
                    }
                }
            }
        } while (isN == false && isM == false);
        for(int[] i : array){
            for(int j : i){
                System.out.print(j+ " ");
            }
        }
        return array;
    }
    static int step2(int[][] array){
        int sum = 0;
        int one = 0;
        int two = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] > 0){
                    one = j;
                    break;
                }
            }
        }
        for(int i = 0;i < array.length;i++){
            for(int j = one+1;j<array[i].length;j++){
                if(array[i][j] > 0){
                    two = j;
                    break;
                }
            }
        }
        for(int i = 0; i < array.length; i++){
            for(int j = one+1; i < two;i++){
                sum+=array[i][j];
            }
        }
        System.out.print(sum);
        return sum;

    }

}