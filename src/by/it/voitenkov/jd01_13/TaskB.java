package by.it.voitenkov.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    static List<Double> listNumbers;
    static Scanner scanner;
    public static void main(String[] args) {
        double sum = 0;
        scanner = new Scanner(System.in);
        listNumbers = new ArrayList<>();

        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (str.equals("END")) {
                break;
            }
            try {
                double number = Double.parseDouble(str);
                listNumbers.add(number);
            } catch (NumberFormatException e) {
                StackTraceElement[] elements = e.getStackTrace();
                for (StackTraceElement element : elements) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        System.out.printf("name:  %s\nclass: %s\nline:  %d\n",
                                e.getClass().getName(),
                                element.getClassName(),
                                element.getLineNumber());
                        scanner.close();
                        break;
                    }
                }
            }
        }


        for (Double listNumber : listNumbers) {
            sum += listNumber;

            if (sum >= 0) {
                String s = (((int) (Math.sqrt(sum) * 100)) / 100.0) + "";
                System.out.printf("%s\n", s);
            } else {
                try {
                    throw new ArithmeticException();
                } catch (ArithmeticException e) {
                    StackTraceElement[] elements = e.getStackTrace();
                    for (StackTraceElement element : elements) {
                        if (TaskB.class.getName().equals(element.getClassName())) {
                            System.out.printf("name:  %s\nclass: %s\nline:  %d\n",
                                    e.getClass().getName(),
                                    element.getClassName(),
                                    element.getLineNumber());
                            break;
                        }
                    }
                }
            }
        }
    }
}


