package by.it.tashtsimirov.jd01_13;

import java.util.Scanner;

public class TaskB {

    public static double a = 0, b = 0, c = 0;

    public static void scanDoub(Scanner scaN) {

        for (;;) {
            String line = scaN.nextLine();
            if (!line.equals("end")) {
                a = Double.parseDouble(line);
                c = c + a;
                if (c<=0) { throw new ArithmeticException(); }
                b = Math.sqrt(c);
                System.out.println(a + " " + b);
            }
            else { break; }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        try {

        scanDoub(scan);

        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName()) && !(element.getLineNumber() > 23)) {
                    String name = e.getClass().getTypeName();
                    String className = element.getClassName();
                    int numberLine = element.getLineNumber();
                    System.out.printf("name: %s\n" +  "class: %s\n" + "line: %s\n",name,className,numberLine);
                }
                //break;
            }
        }


    }
}
