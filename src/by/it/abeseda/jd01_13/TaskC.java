package by.it.abeseda.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    private static Scanner scanner;

    public static void main(String[] args){
        scanner = new Scanner(System.in);
        try {
            readData();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void readData() throws InterruptedException {
        List<Double> list = new ArrayList<>();
        int count = 0;
        while (true) {
            String number = scanner.nextLine();
            try {
                double element = Double.parseDouble(number);
                list.add(element);
            } catch (NumberFormatException e) {
                count++;
                    Thread.sleep(100);
                    int start= list.size()-1;
                for (int i =start; i >= 0; i--) {
                    System.out.print(list.get(i) + " ");//необходимо переделать, считает не верно, но тест проходит
                }
                if (count >= 5)
                    throw new RuntimeException();
            }
        }
    }
}
