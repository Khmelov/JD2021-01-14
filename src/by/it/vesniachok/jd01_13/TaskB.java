package by.it.vesniachok.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>();
        String strNumber;

        while (!(strNumber = scanner.next()).equals("END")) {
            try {
                Double formatNum = Double.parseDouble(strNumber);
                numbers.add(formatNum);

            } catch (NumberFormatException e) {
                String nameClassException = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();

                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {

                        String nameClassExceptionIn = element.getClassName();
                        int lineNumberExceptionIn = element.getLineNumber();


                        System.out.println("class: " + nameClassException);
                        System.out.println("name: " + nameClassExceptionIn);
                        System.out.println("line: " + lineNumberExceptionIn);

                    }


                }
            }
        }
        System.out.println(numbers);
        double sum = 0;
        for (Double element : numbers) {
            sum = sum + element;
            try {
                if (sum < 0) {
                    throw new ArithmeticException();
                }

            } catch (ArithmeticException e) {
                String nameClassException = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement el : stackTrace) {
                    if (TaskB.class.getName().equals(el.getClassName())) {
                        String nameClassExceptionIn = el.getClassName();
                        int lineNumberExceptionIn = el.getLineNumber();

                        System.out.println("class: " + nameClassException);
                        System.out.println("name: " + nameClassExceptionIn);
                        System.out.println("line: " + lineNumberExceptionIn);

                    }
                }
            } finally {
                if (sum >= 0) {
                    double sumSqrt = Math.sqrt(sum);
                    System.out.println(sumSqrt);
                }
            }
        }
    }
}

