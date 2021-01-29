package by.it.zevalich.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }
    private static void step1(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
            }
            if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] arr){
        double middle = 0;
        for (int i = 0; i < arr.length; i++) {
            middle+=arr[i];
        }
        middle/=arr.length;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < middle){
                System.out.print(arr[i] + " ");
            }
        }
    }
    private static void step3(int[] arr){
        int min =arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
        }
        for(int i = arr.length-1;i >= 0;i--){
            if(arr[i] == min){
                System.out.print(i + " ");
            }
        }
    }
}
