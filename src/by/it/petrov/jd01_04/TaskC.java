package by.it.petrov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class  TaskC {

    public static double[] get1DArrayFrom2DArrayByIndex(double[][] arr, int index){
        return arr[index];
    }

    public static double[] merge1DArraysWithSorting(double[] firstArray, double[] secondArray){
        double[] resultArray = new double[firstArray.length + secondArray.length];
        for (int i = 0, j = 0, k = 0; i < firstArray.length; i++) {
            while(firstArray[i] >= secondArray[j] && k < resultArray.length - 1){
                resultArray[k] = secondArray[j];
                k++;
                if (k < resultArray.length - 1){
                    j++;
                }
            }
            resultArray[k] = firstArray[i];
            if (k < resultArray.length - 1){
                resultArray[k + 1] = secondArray[j];
                k++;
            }
        }
        return resultArray;
    }

    public static double[] sortArr(double[] arr){
        double[][] dividedArrays = new double[arr.length][1];
        System.out.println(Arrays.deepToString(dividedArrays));
        for (int i = 0; i < dividedArrays.length; i++) {
            System.out.println(Arrays.toString(get1DArrayFrom2DArrayByIndex(dividedArrays,i)));
        }
        return null;
        }

    static void buildOneDimArray(String line){

        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        sortArr(array);
        InOut.printArray(array, "V", 10);
        int indexOfFirstElement = Integer.MAX_VALUE;
        int indexOfLastElement = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstElement){
                indexOfFirstElement = i;
            }
            if (array[i] == lastElement){
                indexOfLastElement = i;
            }
        }
        //System.out.println("Index of first element=" + indexOfFirstElement);
        //System.out.println("Index of last element=" + indexOfLastElement);
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String inputLineArray = sc.nextLine();
        buildOneDimArray(inputLineArray);*/

        double[] firstArray = new double[]{1, 5, 10, 555, 1000, 5000, 10000};
        double[] secondArray = new double[]{-500, 2, 12, 555, 525, 10000, 15000};
        double[] resultArray = merge1DArraysWithSorting(firstArray,secondArray);
        System.out.println(Arrays.toString(resultArray));

    }
}
