package by.it.voitenkov.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner scanner = new Scanner(System.in);

        for (int index = 0; index < array.length; index++) {
            array[index] = scanner.nextInt();
        }

        step1(array);
        step2(array);
        step3(array);
    }

    static void step1(int[] array) {
        int minNumber = Integer.MIN_VALUE;
        int maxNumber = Integer.MAX_VALUE;

        for (int index = 0; index < array.length; index++) {
            if (index == 0) {
                minNumber = array[0];
                maxNumber = array[0];
            } else if (array[index] > maxNumber) {
                maxNumber = array[index];
            }

            if (array[index] < minNumber) {
                minNumber = array[index];
            }
        }
        System.out.println(minNumber + " " + maxNumber);
    }

    static void step2(int[] array) {
        double arithmeticMean;
        int sumNumber = 0;

        for (int index = 0; index < array.length; index++) {
            sumNumber += array[index];
        }

        if (array.length == 0) {
            arithmeticMean = 0.0;
        } else {
            arithmeticMean = sumNumber / (double) array.length;
        }

        for (int index = 0; index < array.length; index++) {
            if (array[index] < arithmeticMean) {
                System.out.print(array[index] + " ");
            }
        }
        System.out.println();
    }

    static void step3(int[] array) {
        int minNumber = Integer.MIN_VALUE;

        for (int index = 0; index < array.length; index++) {
            if (index == 0) {
                minNumber = array[index];
            } else if (array[index] < minNumber) {
                minNumber = array[index];
            }
        }

        for (int index = array.length - 1; index >= 0; index--) {
            if (array[index] == minNumber) {
                System.out.print(index + " ");
            }
        }
    }
}