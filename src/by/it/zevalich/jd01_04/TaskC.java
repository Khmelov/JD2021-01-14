package by.it.zevalich.jd01_04;
import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length-1];

        mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            if(array[i] == first){
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] == last){
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }
    static void mergeSort(double[ ] array){
        if(array.length > 1){
            int div = array.length / 2;

            double[] left = Arrays.copyOfRange(array,0,div-1);
            double[] right = Arrays.copyOfRange(array,div,array.length-1);

            mergeSort(left);
            mergeSort(right);
            mergeSort(array,left,right);
        }
    }
    static void mergeSort(double[] ar,double[] left, double[] right){
        int len = left.length + right.length;
        ar = new double[len];
        int i = 0;
        int li = 0;
        int ri = 0;
        while (i < len){
            if((li < left.length) && (ri < right.length)){
                if(left[li] < right[ri]){
                    ar[i] = left[li];
                    i++;
                    li++;
                }
                else {
                    ar[i] = right[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if(li >= left.length){
                    while (ri < right.length){
                        ar[i] = right[ri];
                        i++;
                        ri++;
                    }
                }
                if(ri >= right.length) {
                    while (li < left.length){
                        ar[i] = left[li];
                        i++;
                        li++;
                    }
                }
            }
        }
        for (double a : ar) {
            System.out.print(a + " ");
        }

    }


}