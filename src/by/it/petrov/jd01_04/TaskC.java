package by.it.petrov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class  TaskC {

    public static void mergeSort(double[] arr) {
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

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        System.out.println(Arrays.toString(array));
        int indexOfFirstElement = Integer.MAX_VALUE;
        int indexOfLastElement = Integer.MIN_VALUE;

        indexOfFirstElement = binarySearch(array,firstElement);
        indexOfLastElement = binarySearch(array,lastElement);

        System.out.println("Index of first element=" + indexOfFirstElement);
        System.out.println("Index of last element=" + indexOfLastElement);

    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1$2d*%2$d=%3$-2d", i, j, i * j);
                if (j % 9 == 0) {
                    System.out.println();
                }
            }
        }
    }

    static int binarySearch(double[] arr, double value){
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] < value) {
                low = mid + 1;
            }
                else if (arr[mid] > value){
                    high = mid - 1;
                }
                else if (arr[mid] == value){
                    index = mid;
                    break;
                }
            }
            return index;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);

    }
}
