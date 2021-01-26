package by.it.petrov.jd01_05;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;

public class TaskC {

    public static void printArray(double[] arr, String name, int columnCount){
        System.out.printf("Массив %-1s[]%n", name);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-1s[%2d]=%-10.5f", name, i, arr[i]);
            if ((i+1) % columnCount == 0 || i+1 == arr.length){
                System.out.println();
            }
        }
    }
    public static void printArray2(double[] arr, String name, int columnCount){
        System.out.printf("Массив %-1s[] из элементов массива А > 3.5%n", name);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-1s[%2d]=%-10.5f", name, i, arr[i]);
            if ((i+1) % columnCount == 0 || i+1 == arr.length){
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        double xLeftInterval = 5.33;
        double xRightInterval = 9;
        int numberOfElementsInArray = 28;
        double step = (xRightInterval - xLeftInterval) / numberOfElementsInArray;
        double[] array = new double[numberOfElementsInArray];
        for (int i = 0; i < array.length; i++) {
            double x = xLeftInterval + i*step;
            array[i] = cbrt(pow(x, 2) + 4.5);
            }
        printArray(array,"A", 5);
        System.out.println();

        int array2Count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > 3.5){
                array2Count++;
            }
        }
        double[] array2 = new double[array2Count];
        for (int i = 0, k = 0; i < array.length; i++) {
            if(array[i] > 3.5){
                array2[k] = array[i];
                k++;
            }
        }

        printArray2(array2,"B", 5);

        double geomAverage = 0;
        double geomAverageMul = 1;
        for (int i = 0; i < array2.length; i++) {
            geomAverageMul = geomAverageMul*array2[i];
        }
        geomAverage = pow(geomAverageMul, (double) 1 / array2.length);
        System.out.println();
        System.out.println("Our geometric average is equal to " + geomAverage);
    }
    }
