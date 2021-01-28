package by.it.lapushkin.jd01_04;


public class TaskC {
    public static void main(String[] args) {

        String line = "1.3 2.3 3.1 4.4 5.5 6.7 7.34 8.2 9.4 0.5";

        buildOneDimArray(line);


    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);

        double firstIndex = array[0];
        double lastIndex = array[array.length - 1];

        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);

        System.out.println("first element=" + binarySearch(array, firstIndex));
        System.out.println("last element=" + binarySearch(array, lastIndex));
    }

    static void mergeSort(double[] array) {
        mergeSort(array,0,array.length -1);
    }

    private static void mergeSort(double[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);

            merge(array, l, m, r);
        }
    }

    private static void merge(double[] array, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;


        double[] L = new double[n1];
        double[] R = new double[n2];


        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];


        int i = 0, j = 0;


        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }

    }

    static int binarySearch(double[] array, double key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            double midValue = array[mid];
            if (midValue < key)
                low = mid + 1;
            else if (midValue > key)
                high = mid - 1;
            else {
                long midBits = Double.doubleToLongBits(midValue);
                long keyBits = Double.doubleToLongBits(key);
                if (midBits == keyBits)
                    return mid;
                else if (midBits < keyBits)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -(low + 1);

    }


}



