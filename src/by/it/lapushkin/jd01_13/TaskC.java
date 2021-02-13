package by.it.lapushkin.jd01_13;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    static Scanner scanner;
    static int counter = 0;
    static List<Double> list = new LinkedList<>();
    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        readData();
    }

    static void readData()throws InterruptedException{
        while (scanner.hasNext()){
            if (counter < 5){
                String s = scanner.next();
                try {
                    double number = Double.parseDouble(s);
                    list.add(number);
                }catch (NumberFormatException e){
                    Thread.sleep(100);
                    counter++;
                    for (int i = list.size()-1; i>=0; i--) {
                        Double aDouble = list.get(i);
                        System.out.print(aDouble+" ");
                    }
                    System.out.println();
                }
            }else {
                throw new NumberFormatException();
            }
        }

    }
}
