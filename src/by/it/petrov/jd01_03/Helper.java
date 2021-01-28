package by.it.petrov.jd01_03;

import java.util.Arrays;

public class Helper {

    /**
     *
     * @param arr исходный массив
     * @return resultMin вывод минимального значения в исходном массиве
     */
    public static double findMin(double[ ] arr){
        double resultMin = Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < resultMin){
                resultMin = arr[i];
            }
        }
        return resultMin;
    }

    /**
     *
     * @param arr исходный массив
     * @return resultMax вывод максимального значения в исходном массиве
     */
    public static double findMax(double[ ] arr){
        double resultMax = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > resultMax){
                resultMax = arr[i];
            }
        }
        return resultMax;
    }

    /**
     *
     * @param arr исходный массив
     */
    public static void sort(double[ ] arr){
        int length = arr.length - 1;
        while (length > 1){
            for (int i = 0; i < length; i++) {
                if (arr[i] > arr[i + 1]){
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                }
            }
            length--;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param matrix исходная матрица
     * @param vector вектор
     * @return mulVectorArray результат умножения исходной матрицы на вектор
     */
    public static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] mulVectorArray = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                mulVectorArray[i] = mulVectorArray[i] + matrix[i][j] * vector[j];
            }
        }
        return mulVectorArray;
    }

    /**
     *
     * @param matrixLeft левая матрица
     * @param matrixRight правая матрица
     * @return multipliedMatrix получение результата умножения двух матриц
     */
    public static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        if (matrixLeft[0].length != matrixRight.length){
            System.out.println("Matriсes are not compatible and multiplication is not possible");
        }
        double [][] multipliedMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixLeft[0].length; k++) {
                    multipliedMatrix[i][j] = multipliedMatrix[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return multipliedMatrix;
    }

}


