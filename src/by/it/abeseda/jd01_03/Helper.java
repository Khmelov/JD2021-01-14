package by.it.abeseda.jd01_03;

import java.util.Arrays;

public class Helper {
    static double findMin(double[] arr) {
        double min;
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            min = arr[0];
            for (double element : arr) {
                if (element < min)
                    min = element;
            }
            return min;
        }
    }

    static double findMax(double[] arr) {
        double max;
        if (0 == arr.length) {//не понимаюсмысл данного условия, если весь класс сразу выдает ошибку, если не создать матрицу
            return Integer.MAX_VALUE;
        } else {
            max = arr[0];
            for (double element : arr) {
                if (element > max)
                    max = element;
            }
            return max;
        }
    }

    static void sort(double[] arr){
        boolean isSorted=false;
        double buf;

        while(!isSorted){//выполнять пока isSorted не станет не истина
            isSorted=true;
            for(int i=0;i <arr.length-1;i++){
                if(arr[i]>arr[i+1]){

                    isSorted=false;//0

                    buf=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=buf;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static double[] mul(double[][]matrix,double[]vector){
        double[] z=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i]=z[i]+matrix[i][j]*vector[j];
            }
        }
        System.out.println(Arrays.toString(z));
        return z;
    }

    static double[][] mul(double[][]matrixLeft, double[][]matrixRight){
        double [][] z=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    z[i][j]=z[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        System.out.println(Arrays.toString(z));
        return z;
    }


}
