package by.it.nakhankov.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TaskB {

        public static void main (String[]args) {

            Scanner scan = new Scanner(System.in);
            List<Double> doubleList = new ArrayList<>();
            for (;;) {
                String next = scan.next();
                double sqrt = 0;
                double sum = 0;
                if (next.equals("END")) {
                    break;
                }
                try {
                    double number = Double.parseDouble(next);
                    if (number < 0) {
                        throw new ArithmeticException();
                    }
                    doubleList.add(number);
                    for (Double nDouble : doubleList) {
                        sum = sum + nDouble;
                    }
                    sqrt = sqrt(sum);
                } catch (NumberFormatException | ArithmeticException e) {
                    String name = e.getClass().getName();
                    String clname = TaskB.class.getName();

                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement element : stackTrace) {
                        String classNameElement = element.getClassName();
                        if (classNameElement.equals(clname)) {

                            int number = element.getLineNumber();
                            System.out.printf(
                                    "name: %s\n" +
                                            "class: %s\n" +
                                            "line: %d\n",
                                    name,classNameElement,number);
                            break;
                        }
                    }
                }
                System.out.println(sqrt);
            }
        }
}

