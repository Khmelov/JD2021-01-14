

package by.it.abeseda.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String str= scanner.nextLine();
        double[] array=InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"V",3);
        System.out.println("Минимальный элемент в массиве равен: "+Helper.findMin(array));
        System.out.println("Максимальный элемент в массиве равен: "+Helper.findMax(array));
        Helper.sort(array);
        double[][]matrixForMul={{1.2,3.3,33,0,55,100},{33,43,4.55,500,0,0.1}};
        double[]vector={33,4,5,6,7,1};
        Helper.mul(matrixForMul,vector);
        Helper.mul(matrixForMul,array);
    }
}
