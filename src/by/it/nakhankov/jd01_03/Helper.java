package by.it.nakhankov.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Double.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            return min;
        }
    }

    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Double.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    static void sort(double[] arr) {
        sort (arr, true);
    }
    static void sort(double[ ] arr, boolean upDirection) {
        for (int start = 0; start < arr.length-1; start++) {
            double least = start;
            for (int j = start + 1; j < arr.length; j++) {
                if ((upDirection && arr[j] < arr[(int) least]) ||
                        (!upDirection && arr[j] > arr[(int) least]))
                {
                    least = j;
                }
            }
            double tmp = arr[start];
            arr[start] = arr[(int) least];
            arr[(int) least] = tmp;
        }
    }
}
