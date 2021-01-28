package by.it.lapushkin.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrayInt[] = new int[10];


        for (int i = 0; i < arrayInt.length; i++) {

            arrayInt[i] = scanner.nextInt();

        }

        step1(arrayInt);
        System.out.println();
        step2(arrayInt);
        System.out.println();
        step3(arrayInt);
        System.out.println();
        scanner.close();

    }

    private static void step1(int[] arrayInt) {
        int min = 0;
        int max = 0;
        for (int a : arrayInt) {
            if (a > max) {
                max = a;
            }
            if (a < min) {
                min = a;
            }
        }
        System.out.println(min + " " + max);

    }

    private static void step2(int[] arrayInt) {
        double avg = 0;
        for (int a : arrayInt) {
            avg += a;
        }
        avg = avg / arrayInt.length;
        for (int a : arrayInt) {
            if (a < avg) {
                System.out.println(a);
            }
        }
    }

    private static void step3(int[] arrayInt) {
        int min = 0;
        int[] indexArray = new int[10];
        for (int a = 0; a < arrayInt.length; a++) {
            if (arrayInt[a] <= min) {
                indexArray[a] = a;
            }
        }
        for (int i = indexArray.length - 1; i >= 0; i--) {
            System.out.print(indexArray[i]+" ");
        }
    }

}
