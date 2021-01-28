package by.it.shebeko.jd01_04;

public class Helper {
    static double findMax(double[]arr){
       double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    static double findMin(double[]arr){
        double min = arr [0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
            min = arr[i];
            }
        }
        return min;
        }

    static void sort(double[]arr) {
        boolean iteration = true;
        while (iteration) {
            iteration = false;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr [i + 1] = temp;
                    iteration = true;
                }

            }
        }
    }

    static double[] mul(double[][] matrix, double[]vector){
        double[] mv = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mv[i] = mv[i] + matrix[i] [j] * vector[j];
            }
        }
        return mv;
    }
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double[] [] mm = new double[matrixLeft.length] [matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    mm [i] [j] = mm[i] [j] + matrixLeft[i] [k] * matrixRight [k] [j];
                }
            }
        }
       return mm;
    }
    }

