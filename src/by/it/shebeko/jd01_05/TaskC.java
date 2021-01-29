package by.it.shebeko.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        int size = (int)(Math.random()* 20 +20);
        double[] arrA = new double[size];
        double delta = (9-5.33)/(size-1);
        int i = 0;
        int sizeB = 0;
        for (double x = 5.33; x<=9; x = x + delta) {
            arrA[i] = pow((pow(x, 2) + 4.5), 1/3.0);
            if (arrA[i] > 3.5){
                sizeB ++;
            }
            i++;
        }
        System.out.println(Arrays.toString(arrA));
        double [] arrB = new double[sizeB];
        int k = 0;
        for (int j = 0; j < arrA.length; j++) {
            if (arrA[j]> 3.5){
                arrB[k] = arrA[j];
                k++;
            }
        }
        for (int t = 0; t < arrA.length; t++) {
            System.out.printf(" V [% -3d] =%-10.4f ", t, arrA[t]);
        }
        System.out.println();
        for (int g = 0; g < arrB.length; g++) {
            double middle = pow(g * g,1.0/ arrB.length);
            System.out.printf(" V [% -3d] =%-10.4f ", g, arrB[g]);
            System.out.println(middle);

        }
        }
    }