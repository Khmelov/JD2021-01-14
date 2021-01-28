package by.it.abeseda.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
/*    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String s=scanner.nextLine();

        double [] array=buildOneDimArray(s);
        mergeSort(array);}



       static double[] buildOneDimArray(String line){
            line = line.trim();
            String[] strArr = line.split(" ");
            double[] res = new double[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                res[i] = Double.parseDouble(strArr[i]);
            }
            return res;
    }


    private static void mergeSort(double[ ] array){

        if (array.length<=1){
            System.out.println("Массив отсортирован. Длина массива 1.");
        }
        int midpoint=array.length/2;
        double [] left=new double [midpoint];
        double [] right;

        if (array.length%2==0){
            right=new double [midpoint];
        }else{
        right=new double[midpoint+1];}

            for (int i = 0; i <midpoint; i++) {
                left[i]=(int)array[i];
            }
                for (int j = 0; j < right.length; j++) {
                    right[j]=(int)array[midpoint+j];
                }
                double [] result=new double[array.length];

 //               left=mergeSort(left);
//                right=mergeSort(right); 
//                result=
                merge(left,right);



        private static double[] merge (double[ ] part1, double[ ] part2){
            double [] result=new double[left.length+ right.length];

            int leftPointer, rightPointer, resultPointer;
            leftPointer=rightPointer=resultPointer=0;

            while (leftPointer<left.length || rightPointer<right.length){

                if (leftPointer<left.length && rightPointer<right.length){

                    if (left[leftPointer]<right[rightPointer]){
                        result[resultPointer++]=left[leftPointer++];
                    }else{
                        result[resultPointer++]=right[rightPointer++];
                    }
                }
                else if (leftPointer<left.length){
                    result[resultPointer++]=left[leftPointer++];
                }
                else if (rightPointer<right.length){
                    result[resultPointer++]=right[rightPointer++];
                }
            }
            return result;
        }





                }
*/
}

