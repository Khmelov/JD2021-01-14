package by.it.shebeko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);

    }
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        double indexFirst = binarySearch(array, firstElement);
        double indexLast = binarySearch(array, lastElement);
        System.out.println("Index of first element=" + indexFirst);
        System.out.println("Index of last element=" + indexLast);
    }

    static void mergeSort(double[] array, int left, int right) {
        if (left < right){
            int p = partition(array, left, right);
            mergeSort(array,left, p-1);
            mergeSort(array,p+1,right);
        }
    }

    private static int partition(double[] array, int left, int right) {
        double k = array[right];
        int j = left;              //wall
        for (int i = left; i < right; i++) {
            if (array[i]<k){
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }

        }
        double temp = array[right];
        array[right] = array[j];
        array[j] = temp;

        return j;
    }
    static void mergeSort(double [] arr){
        mergeSort(arr,0, arr.length-1);
    }


    static int binarySearch(double[] array, double value){
        int l=0;
        int r = array.length-1;
        while(l<=r){
            int middle = (l+r)/2;
            if (array[middle] == value){
                return middle;
            }
            else if (value < array[middle]){
              r = middle-1;
            }
            else l = middle + 1;
        }
        return 0;
    }
}
