package by.it.petrov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1$2d*%2$d=%3$-2d",i, j, i*j);
                if(j%9==0){
                    System.out.println();
                }
            }
        }
    }

    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        InOut.printArray(array,"V",5);
        array = Helper.sortArr(array);
        InOut.printArray(array, "V", 4);
        System.out.println(Arrays.toString(array));
        int indexOfFirstElement = Integer.MAX_VALUE;
        int indexOfLastElement = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstElement){
                indexOfFirstElement = i;
            }
            if (array[i] == lastElement){
                indexOfLastElement = i;
            }
        }
        System.out.println("Index of first element=" + indexOfFirstElement);
        System.out.println("Index of last element=" + indexOfLastElement);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        printMulTable();
        buildOneDimArray(line);
    }
}