package by.it.tashtsimirov.jd01_03;

public class Helper {

    static double findMin(double[ ] arr) {
        if (0 == arr.length) { return Double.MIN_VALUE; }
        else { double min = arr[0];
            for ( double n : arr ) {
                if ( min > n ) { min = n; }
            }
            System.out.println("Это минимум: " + min);
            return min;
        }
    }


    static double findMax(double[ ] arr) {
        if (0 == arr.length) { return Double.MAX_VALUE; }
        else { double max = arr[0];
                for ( double x : arr ) {
                    if ( max < x ) { max = x; }
                }
                System.out.println("Это максимум: " + max);
                return max;
        }
    }

    static void sort(double[ ] arr) {
        boolean swap;
        double last = arr.length-1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        for (double element : arr) { System.out.print(element + " "); }
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {

    int ai = matrixLeft.length;
    int aj = matrixLeft[0].length;
    int bi = matrixRight.length;
    int bj = matrixRight[0].length;

    int ci = ai, cj = bj;
        if (aj != bi && bj != ai) { System.out.println("Матрицы не согласованные, умножение невозможно!"); }
        if (bj == ai && bi != aj) { System.out.println("Для умножения матриц их необходимо поменять местами!"); }
        if (bj == 1) { System.out.println("Вы умножаете матрицу на вектор."); }

    double[][] matrixX = new double[ci][cj];



        for (int z = 0; z < ai; z++) {
        int k = 0;
        for (int m = 0; m < bj; m++) {
            for (int n = 0; n < aj; n++) {
                matrixX[z][m] += ((matrixLeft[z][n]) * (matrixRight[n][k]));
            }
            k++;
        }
        }
        return matrixX;
    }

    static double[] mul(double[][] matrix, double[] vector) {

        int mi = matrix.length;
        int mj = matrix[0].length;
        int vj = vector.length;

        double[] matrixRes = new double[mi];


        int x=0;
        for (int j = 0; j < mi; j++) {
            for (int i = 0; i < mj; i++) {
                matrixRes[x] += (matrix[x][i] * vector[i]);
            }
            x++;
        }

        return matrixRes;
    }


}
