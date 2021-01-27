package by.it.voitenkov.lessons.lesson_jd01_01;

import java.util.Arrays;

public class SortingArray {

    public static void main(String[] args) {
        int[] array = {10, 2, 6, 4, 3, 1, 8, 9, 3, 4};
        boolean isSortAscending = false;
//        System.out.println(Arrays.toString(sortSelection(array, false)));
        System.out.println(Arrays.toString(sortBubble(array, isSortAscending)));
    }

    public static int[] sortBubble(int[] array, boolean isSortAscending) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array.length; j++) {
                if ((isSortAscending && array[i] < array[j]) ||
                        (!isSortAscending && array[i] > array[j])) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
        return array;
    }

    public static double[] sortBubble(double[] array, boolean isSortAscending) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array.length; j++) {
                if ((isSortAscending && array[i] < array[j]) ||
                        (!isSortAscending && array[i] > array[j])) {
                    double tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
        return array;
    }

    public static int[] sortSelection(int[] array, boolean isSortAscending) {
        for (int i = 0; i < array.length; i++) {
            int numberIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if ((isSortAscending && array[numberIndex] > array[j]) ||
                        (!isSortAscending && array[numberIndex] < array[j])) {
                    numberIndex = j;
                }
            }

            int tmp = array[numberIndex];
            array[numberIndex] = array[i];
            array[i] = tmp;
        }
        return array;
    }
}
