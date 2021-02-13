package by.it.zevalich.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    static void readData(Scanner scanner) throws InterruptedException {
        try {
            List<Double>  numbers = new ArrayList<>();
            double number = scanner.nextDouble();
            numbers.add(number);
        }catch (Exception e){
            int countOfExceptions = 0;
            countOfExceptions++;

        }
        finally {
            Thread.sleep(100);


        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

}
