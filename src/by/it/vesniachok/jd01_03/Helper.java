package by.it.vesniachok.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double i : arr) {
                if (min > i) min = i;
            }
            System.out.println("Index of Min: " + min);
            return min;

        }


    }

    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double i : arr) {
                if (max < i) max = i;
            }
            System.out.println("Index of Max: " + max);
            return max;
        }

    }

    static void sort(double[] arr) {
        boolean swap;
        int last = arr.length - 1;

        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;

                }
            }

            last--;
        }
        while (swap);
        InOut a = new InOut();
        a.printArray(arr);

    }
}

