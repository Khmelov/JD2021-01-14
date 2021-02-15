package by.it.shebeko.jd01_13;


import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        for (; ; ) {
            String input = sc.nextLine();
            if (input.equals("END")) {
                break;
            }
            try {
                double number = Double.parseDouble(input);
                sum = number + sum;
                if (sum < 0) {
                    throw new ArithmeticException();
                }
                System.out.println(number + " " + sqrt(sum));
            } catch (NumberFormatException | ArithmeticException ex) {
                Class<?> cls = ex.getClass();
                String exName = cls.getName();
                StackTraceElement[] stackTrace = ex.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String methodName = stackTraceElement.getMethodName();
                    if (methodName.equals("main")) {
                        String className = stackTraceElement.getClassName();
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf(" name: %s\n class: %s\n line: %d\n", exName, className, lineNumber);
                        break;
                    }

                }

            }
        }
    }
}