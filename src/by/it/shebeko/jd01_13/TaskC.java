package by.it.shebeko.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    private static Scanner sc;

    public static void main(String[] args) throws InterruptedException {
        sc = new Scanner(System.in);
        readData();
    }

    static void readData() throws InterruptedException {
        List<Double> list = new ArrayList<>();
        int count = 0;
        for (; ; ) {
            String number = sc.nextLine();
            try {
                double p = Double.parseDouble(number);
                list.add(p);
            }catch (NumberFormatException e){
                count++;
                Thread.sleep(100);
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i) + " ");
                }
            if (count >= 5)
                throw new RuntimeException();
            }
        }
    }
}
