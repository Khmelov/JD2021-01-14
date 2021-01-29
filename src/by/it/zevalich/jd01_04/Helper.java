package by.it.zevalich.jd01_04;


public class Helper {
    static double findMin(double[ ] arr){
        if(0 == arr.length){
            return Double.MIN_VALUE;
        }
        else{
            double min = arr[0];
            for(double element : arr ){
                if(min > element) min = element;
            }
            return min;
        }
    }
    static double findMax(double[ ] arr){
        if(0 == arr.length){
            return Double.MAX_VALUE;
        }
        else {
            double max = arr[0];
            for(double element : arr){
                if(max < element) max = element;
            }
            return max;
        }
    }
    static void sort(double[ ] arr){
        boolean isSorted = false;
        double buf;
        while(!isSorted){
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                }
            }
        }
    }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];
            }
        }
        return  z;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    z[i][j] = z[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return z;
    }
}
