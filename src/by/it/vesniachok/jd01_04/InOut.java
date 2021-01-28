package by.it.vesniachok.jd01_04;

public class InOut {
    static double[] getArray(String line) {
        String[] strArray = line.split(" ");
        double[] result = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
        }

        return result;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.println(element + " ");

        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%10.4f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == arr.length)
                System.out.println();
        }
    }

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
    static void sort(double[ ] arr){
        boolean swap;
        int last = arr.length-1;

        do {
            swap=false;
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
        printArray(arr);

    }

}
