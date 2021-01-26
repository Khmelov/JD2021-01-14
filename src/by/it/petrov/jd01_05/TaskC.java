package by.it.petrov.jd01_05;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;

public class TaskC {

    static double[] getArray(String line){
        String[] arrayString = line.split(" ");
        double[] arrayDouble = new double[arrayString.length];
        for (int i = 0; i < arrayDouble.length; i++) {
            arrayDouble[i] = Double.parseDouble(arrayString[i]);
        }
        return arrayDouble;
    }
    public static void printArray(double[] arr, String name, int columnCount){

        int rowCount = (int) ceil(arr.length / columnCount) + 1;
        int totalCount = rowCount * columnCount;

        System.out.println("Massiv M <index to rows>");

        for (int i = 0; i < columnCount - 2; i++) {
            System.out.printf("%s","══════════════" );
        }
        System.out.printf("╦══════════════%n");
        for (int i = 0; i < arr.length; i++) {


            if((i+1) % columnCount == 0 || i+1 == arr.length){
                System.out.printf("║%-1s[%2d]=%-8.5f║", name, i, arr[i]);
            } else {
                System.out.printf("║%-1s[%2d]=%-8.5f", name, i, arr[i]);
            }
            if ((i+1) % columnCount == 0){
                System.out.println();
                System.out.printf("╠%s", "══════════════");
                for (int k = 0; k < columnCount - 2; k++) {
                    System.out.printf("╬%s","══════════════" );
                }
                System.out.printf("══════════════%n");
            }
            if (i+1 == arr.length){
                for (int j = 0; j < rowCount * columnCount - arr.length - 1; j++) {
                    System.out.print("              ║" );
                }
                System.out.printf("              ║%n" );
                System.out.printf("%s", "══════════════");
                for (int k = 0; k < columnCount - 2; k++) {
                    System.out.printf("╩%s","══════════════" );
                }
                System.out.printf("╩══════════════%n");
                break;
            }
        }
    }

    public static void printArray2(double[] arr, String name, int columnCount){
        System.out.println("Massiv M <index to rows>");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-1s[%2d]=%-10.5f", name, i, arr[i]);
            if ((i+1) % columnCount == 0 || i+1 == arr.length){
                System.out.println();
            }
        }
    }
    public static void printArray3(double[] arr, String name, int columnCount){

        int rowCount = (int) ceil(arr.length / columnCount) + 1;
        int totalCount = rowCount * columnCount;

        System.out.println("Massiv A <index to rows>");
        System.out.printf("╔%s", "══════════════");

        for (int i = 0; i < columnCount - 2; i++) {
            System.out.printf("╦%s","══════════════" );
        }
        System.out.printf("╦══════════════╗%n");
        for (int i = 0; i < arr.length; i++) {


            if((i+1) % columnCount == 0 || i+1 == arr.length){
                System.out.printf("║%-1s[%2d]=%-8.3f║", name, i, arr[i]);
            } else {
                System.out.printf("║%-1s[%2d]=%-8.3f", name, i, arr[i]);
            }
            if ((i+1) % columnCount == 0){
                System.out.println();
                System.out.printf("╠%s", "══════════════");
                for (int k = 0; k < columnCount - 2; k++) {
                    System.out.printf("╬%s","══════════════" );
                }
                System.out.printf("╬══════════════╣%n");
            }
            if (i+1 == arr.length){
                for (int j = 0; j < rowCount * columnCount - arr.length - 1; j++) {
                    System.out.print("              ║" );
                }
                System.out.printf("              ║%n" );
                System.out.printf("╚%s", "══════════════");
                for (int k = 0; k < columnCount - 2; k++) {
                    System.out.printf("╩%s","══════════════" );
                }
                System.out.printf("╩══════════════╝%n");
                break;
            }
        }
    }
    public static void printArray4(double[] arr, String name, int columnCount){

        int rowCount = (int) ceil(arr.length / columnCount) + 1;
        int totalCount = rowCount * columnCount;

        System.out.println("Massiv B <index to rows>");
        System.out.printf("╔%s", "══════════════");

        for (int i = 0; i < columnCount - 2; i++) {
            System.out.printf("╦%s","══════════════" );
        }
        System.out.printf("╦══════════════╗%n");
        for (int i = 0; i < arr.length; i++) {


            if((i+1) % columnCount == 0 || i+1 == arr.length){
                System.out.printf("║%-1s[%2d]=%-8.3f║", name, i, arr[i]);
            } else {
                System.out.printf("║%-1s[%2d]=%-8.3f", name, i, arr[i]);
            }
            if ((i+1) % columnCount == 0){
                System.out.println();
                System.out.printf("╠%s", "══════════════");
                for (int k = 0; k < columnCount - 2; k++) {
                    System.out.printf("╬%s","══════════════" );
                }
                System.out.printf("╬══════════════╣%n");
            }
            if (i+1 == arr.length){
                for (int j = 0; j < rowCount * columnCount - arr.length - 1; j++) {
                    System.out.print("              ║" );
                }
                System.out.printf("              ║%n" );
                System.out.printf("╚%s", "══════════════");
                for (int k = 0; k < columnCount - 2; k++) {
                    System.out.printf("╩%s","══════════════" );
                }
                System.out.printf("╩══════════════╝%n");
                break;
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

        double []A_array = new double[32];
        for (int i = 0; i < A_array.length; i++) {
            A_array[i] = ceil(random()*(450 - 103) + 103);
        }
        String sArrayBValues = "";
        for (int i = 0; i < A_array.length; i++) {
            if (0.1*A_array[i] > i){
                sArrayBValues = sArrayBValues.concat(String.valueOf(A_array[i]));
                sArrayBValues = sArrayBValues.concat(" ");
            }
        }
        double[]arrayB = getArray(sArrayBValues);
        Arrays.sort(arrayB);
        System.out.println(Arrays.toString(arrayB));
        printArray3(A_array, "A", 5);
        printArray4(arrayB, "B", 5);
    }
    }
