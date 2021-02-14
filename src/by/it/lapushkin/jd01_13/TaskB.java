package by.it.lapushkin.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> doubleList = new ArrayList<>();
        for (; ; ) {
            String next = scanner.next();
            double sqrt = 0;
            double sum = 0;
            if (next.equals("END")) {
                break;
            }
            try {

                double number = Double.parseDouble(next);
                if (number < 0){
                    throw new ArithmeticException();
                }
                doubleList.add(number);
                for (Double aDouble : doubleList) {
                    sum += aDouble;
                }
                sqrt = sqrt(sum);


            } catch (NumberFormatException | ArithmeticException e) {
                String name = e.getClass().getName();
                String myMain = TaskB.class.getName();

                StackTraceElement[] elements = e.getStackTrace();
                for (StackTraceElement element : elements) {
                    String classNameElement = element.getClassName();
                    if (classNameElement.equals(myMain)) {
                        int lineNumber = element.getLineNumber();
                        System.out.printf("name: %s\n" +
                                        "class: %s\n" +
                                        "line: %d\n"
                                , name, classNameElement, lineNumber);
                        break;
                    }
                }
            }
            System.out.println(sqrt);


        }
    }
}
