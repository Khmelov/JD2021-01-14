package by.it.petrov.jd01_04;

import java.util.Arrays;

public class TaskCtesting {

    public static int[] merge(int [] initialArray, int size) {

        int index1 = 0;
        int index2 = index1 + size;
        int leftArrayEnd = size - 1;
        int rightArrayStart = leftArrayEnd + 1;
        int rightArrayEnd = rightArrayStart + size - 1;
        int[] sortedArray = Arrays.copyOf(initialArray, initialArray.length);

        if (size * 2 > initialArray.length) {
            rightArrayEnd = rightArrayStart + initialArray.length - size - 1;
        }

        int leftArrayLength = size;
        int rightArrayLength = rightArrayEnd - rightArrayStart + 1;
        int iterationCount = leftArrayLength + rightArrayLength;
        int breakLoop = 0;

        for (int i = index1; i < iterationCount; i++) {

            while (index2 == rightArrayLength + rightArrayStart && i < iterationCount) {
                sortedArray[i] = initialArray[index1];
                i++;
                index1++;
                breakLoop += 1;
            }
            while (index1 == leftArrayLength && i < iterationCount) {
                sortedArray[i] = initialArray[index2];
                i++;
                index2++;
                breakLoop += 1;
            }
            if(breakLoop > 0){
                break;
            }
            if ((initialArray[index1] >= initialArray[index2]) && (breakLoop == 0) && (index1 < leftArrayLength && index2 < rightArrayLength + rightArrayStart)) {
                sortedArray[i] = initialArray[index2];
                index2++;
                continue;
            }
            if (initialArray[index1] < initialArray[index2] &&  (breakLoop == 0) && (index1 < leftArrayLength && index2 < rightArrayLength + rightArrayStart)) {
                sortedArray[i] = initialArray[index1];
                index1++;
            }
        }
        return sortedArray;
    }

    public static int[] merge(int [] initialArray, int size, int left) {

        int index1 = left;
        int index2 = index1 + size;
        int leftArrayStart = index1;
        int leftArrayEnd = index1 + size - 1;
        int rightArrayStart = leftArrayEnd + 1;
        int rightArrayEnd = rightArrayStart + size - 1;
        if(rightArrayEnd > initialArray.length - 1 ){
            rightArrayEnd = initialArray.length - 1;
        }
        int[] sortedArray = Arrays.copyOf(initialArray, initialArray.length);

        if (size * 2 > initialArray.length) {
            rightArrayEnd = rightArrayStart + initialArray.length - size - 1;
        }

        int leftArrayLength = size;
        int rightArrayLength = rightArrayEnd - rightArrayStart + 1;
        int iterationCount = leftArrayLength + rightArrayLength;
        int breakLoop = 0;

        for (int i = leftArrayStart; i < iterationCount + leftArrayStart; i++) {

            while (index2 == rightArrayLength + rightArrayStart && i < iterationCount + leftArrayStart) {
                sortedArray[i] = initialArray[index1];
                i++;
                index1++;
                breakLoop += 1;
            }
            while (index1 == leftArrayLength + rightArrayStart && i < iterationCount + leftArrayStart) {
                sortedArray[i] = initialArray[index2];
                i++;
                index2++;
                breakLoop += 1;
            }
            if(breakLoop > 0){
                break;
            }
            if ((initialArray[index1] >= initialArray[index2]) && (breakLoop == 0) && (index1 < leftArrayLength + leftArrayStart && index2 < rightArrayLength + rightArrayStart)) {
                sortedArray[i] = initialArray[index2];
                index2++;
                continue;
            }
            if (initialArray[index1] < initialArray[index2] &&  (breakLoop == 0) && (index1 < leftArrayLength + leftArrayStart && index2 < rightArrayLength + rightArrayStart)) {
                sortedArray[i] = initialArray[index1];
                index1++;
            }
        }
        return sortedArray;
    }

    public static void mergeSort(int [] initialArray){
        int size = 1;
        int arrayLength = initialArray.length;
        int iterationsCount = (int) Math.ceil(Math.log(arrayLength));
        int[] sortedArray = Arrays.copyOf(initialArray, initialArray.length);

        for (int i = 0; i <= iterationsCount; i++) {
            for (int j = 0; j < Math.pow(2, iterationsCount - i - 1); j++) {
                sortedArray = merge(sortedArray, (int) (size * Math.pow(2, i)), 2*j);
            }
        }

        System.out.println("Final array is  " + Arrays.toString(sortedArray));
    }

    public static void mrgsort(double[] arr) {
        int n = arr.length;
        boolean c = true;
        int i = 0;
        int i1 = 0;
        int i2 = 0;
        int n1 = 0;
        int n2 = 0;
        double[] barr = new double[n];
        int mergelen = 0;

        barr = new double[n];
        mergelen = 1;
        while (mergelen < n) {
            if (c) {
                i = 0;
                while (i + mergelen <= n) {
                    i1 = i + 1;
                    i2 = i + mergelen + 1;
                    n1 = i + mergelen;
                    n2 = i + 2 * mergelen;
                    if (n2 > n) {
                        n2 = n;
                    }
                    while (i1 <= n1 | i2 <= n2) {
                        if (i1 > n1) {
                            while (i2 <= n2) {
                                i = i + 1;
                                barr[i - 1] = arr[i2 - 1];
                                i2 = i2 + 1;
                            }
                        } else {
                            if (i2 > n2) {
                                while (i1 <= n1) {
                                    i = i + 1;
                                    barr[i - 1] = arr[i1 - 1];
                                    i1 = i1 + 1;
                                }
                            } else {
                                if (arr[i1 - 1] > arr[i2 - 1]) {
                                    i = i + 1;
                                    barr[i - 1] = arr[i2 - 1];
                                    i2 = i2 + 1;
                                } else {
                                    i = i + 1;
                                    barr[i - 1] = arr[i1 - 1];
                                    i1 = i1 + 1;
                                }
                            }
                        }
                    }
                }
                i = i + 1;
                while (i <= n) {
                    barr[i - 1] = arr[i - 1];
                    i = i + 1;
                }
            } else {
                i = 0;
                while (i + mergelen <= n) {
                    i1 = i + 1;
                    i2 = i + mergelen + 1;
                    n1 = i + mergelen;
                    n2 = i + 2 * mergelen;
                    if (n2 > n) {
                        n2 = n;
                    }
                    while (i1 <= n1 | i2 <= n2) {
                        if (i1 > n1) {
                            while (i2 <= n2) {
                                i = i + 1;
                                arr[i - 1] = barr[i2 - 1];
                                i2 = i2 + 1;
                            }
                        } else {
                            if (i2 > n2) {
                                while (i1 <= n1) {
                                    i = i + 1;
                                    arr[i - 1] = barr[i1 - 1];
                                    i1 = i1 + 1;
                                }
                            } else {
                                if (barr[i1 - 1] > barr[i2 - 1]) {
                                    i = i + 1;
                                    arr[i - 1] = barr[i2 - 1];
                                    i2 = i2 + 1;
                                } else {
                                    i = i + 1;
                                    arr[i - 1] = barr[i1 - 1];
                                    i1 = i1 + 1;
                                }
                            }
                        }
                    }
                }
                i = i + 1;
                while (i <= n) {
                    arr[i - 1] = barr[i - 1];
                    i = i + 1;
                }
            }
            mergelen = 2 * mergelen;
            c = !c;
        }
        if (!c) {
            i = 1;
            do {
                arr[i - 1] = barr[i - 1];
                i = i + 1;
            } while (i <= n);
        }
        System.out.println(Arrays.toString(barr));
    }

    public static void main(String[] args) {
        double [] array = new double[]{0, -50, 70, -100, 1000, -3000, 700, -5000, 500};
        mrgsort(array);
    }
}
