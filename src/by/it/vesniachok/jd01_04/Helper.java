package by.it.vesniachok.jd01_04;

public class Helper {
    static double findMax(double[] arr) {
        if (arr.length == 0) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double i : arr) {
                if (max < i) {
                    max = i;
                }
            }
            return max;
        }

    }

    static double findMin(double[] arr) {
        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double i : arr) {
                if (min > i) min = i;
            }

            return min;

        }
    }

    static void sort(double[] array) {
        boolean swap;
        int last = array.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (array[i] > array[i + 1]) {
                    double buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;

        } while (swap);
        printArray(array);
    }

    static private void printArray(double[] array) {
        for (double i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

