package by.it.lapushkin.jd01_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String line = scanner.nextLine();
        String line = "12 32 54 63 12 1 4 6 7 3 57";
        double[] array = InOut.getArray(line);


        InOut.printArray(array);

        InOut.printArray(array,"V",2);

        System.out.println(Helper.findMax(array));

        System.out.println(Helper.findMin(array));

        Helper.sort(array);


    }
}
