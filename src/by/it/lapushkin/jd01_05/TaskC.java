package by.it.lapushkin.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {

        double a = 5.33;
        double b = 9;

        int arraySizeOne = 28;
        int arraySizeTwo = 0;

        double step = abs(a - b) / (arraySizeOne - 1);
        double[] arrayOne = new double[arraySizeOne];

        for (double x = a, j = 0; x < b; x += step, j++) {
            double funcResult = cbrt(pow(x, 2) + 4.5);
            arrayOne[(int) j] = funcResult;
            if (funcResult > 3.5) {
                arraySizeTwo++;
            }
        }
        System.out.print("Массив A[] \n");
        InOut.printArray(arrayOne, "Z1", 5);
        System.out.println();

        double[] arrayTwo = new double[arraySizeTwo];

        for (int i = 0; i < arrayTwo.length; i++) {
            arrayTwo[i] = arrayOne[arrayOne.length - arrayTwo.length + i];
        }
        System.out.println("Массив B[] из элементов массива A > 3.5");
        InOut.printArray(arrayTwo, "Z2", 5);
        System.out.println();

        double avgGeometric = 1;

        for (int i = 0; i < arrayTwo.length; i++) {
            avgGeometric *= arrayTwo[i];
        }
        avgGeometric = pow(avgGeometric, 1.0 / arrayTwo.length);

        System.out.println("Среднее геометрическое чисел массива B=" + avgGeometric);
        System.out.println();

    }

    private static void step2() {
        int[] arrayOne = new int[31]; // array A
        int[] arrayTwo; // array B
        int arrayTwoSize = 0;
        for (int i = 0; i < arrayOne.length; i++) {
            arrayOne[i] = ((int) (random() * 348 + 103));
            if (arrayOne[i] * 0.1 > i)
                arrayTwoSize++;
        }
        Helper.printArrayC3(arrayOne, "A",true);
        Arrays.sort(arrayOne);
        arrayTwo = new int[arrayTwoSize];
        for (int i = 0; i < arrayTwo.length; i++) {
            arrayTwo[i] = arrayOne[arrayOne.length - arrayTwo.length + i];
        }
        Helper.printArrayC3(arrayTwo, "B",false);


    }

}
