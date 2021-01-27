package by.it._akhmelov_.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        buildOneDimArray(s);
    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double firstElement = array[0]; //10
        double lastElement = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstElement) {
                System.out.printf("Index of first element=%d\n", i);
                break;
            }

        }
        int indexLast = Arrays.binarySearch(array, lastElement);
        System.out.printf("Index of last element=%d\n", indexLast);
        double[] a=new double[array.length];
        System.arraycopy(array,0,a,0,array.length);

    }
}
