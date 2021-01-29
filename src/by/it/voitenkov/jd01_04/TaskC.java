package by.it.voitenkov.jd01_04;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        String[] arrayLine = line.split(" ");
        double firstNumberBeforeSortingTheArray;
        double lastNumberBeforeSortingTheArray;
        double[] arrayNumbers = new double[arrayLine.length];

        for (int i = 0; i < arrayLine.length; i++) {
            arrayNumbers[i] = Double.parseDouble(arrayLine[i]);
        }

        firstNumberBeforeSortingTheArray = arrayNumbers[0];
        lastNumberBeforeSortingTheArray = arrayNumbers[arrayNumbers.length - 1];

        InOut.printArray(arrayNumbers, "V", 5);
        mergeSort(arrayNumbers);
        InOut.printArray(arrayNumbers, "V", 4);

        System.out.println("Index of first element=" + binarySearch(arrayNumbers, firstNumberBeforeSortingTheArray));
        System.out.println("Index of last element=" + binarySearch(arrayNumbers, lastNumberBeforeSortingTheArray));
    }

    static void mergeSort(double[] array) {
        int l = 0;
        int r = array.length - 1;
        mergeSort(array, l, r);
    }

    private static void mergeSort(double[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(double[] array, int left, int middle, int right) {
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;

        double[] leftArray = new double[leftArraySize];
        double[] rightArray = new double[rightArraySize];

        //копируем данные во временные массивы
        for (int i = 0; i < leftArraySize; ++i) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < rightArraySize; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int insertIndex = left;
        while (leftArrayIndex < leftArraySize && rightArrayIndex < rightArraySize) {
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                array[insertIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                array[insertIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            insertIndex++;
        }

        while (leftArrayIndex < leftArraySize) {
            array[insertIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            insertIndex++;
        }

        while (rightArrayIndex < rightArraySize) {
            array[insertIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            insertIndex++;
        }
    }

    static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            int middle = left + (right - left) / 2;

            if (value < array[middle]) {
                right = middle - 1;
            } else if (value > array[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
