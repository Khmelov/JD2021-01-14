package by.it.voitenkov.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    static private int countError = 0;
    static Scanner scanner;
    static List<Double> number;

    public static void main(String[] args) {
        number = new ArrayList<>();
        scanner = new Scanner(System.in);

        while (countError < 5) {
            try {
                readData();
            } catch (Exception e) {
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
    }

    static void readData() throws Exception {
        while (true) {
            String str = scanner.nextLine();

            try {
                number.add(Double.parseDouble(str));
            } catch (Exception e) {
                try {
                    Thread.sleep(100);
                    for (int index = number.size() - 1; index >= 0; index--) {
                        if (index != 0) {
                            System.out.print(number.get(index) + " ");
                        } else {
                            System.out.println(number.get(index));
                        }
                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                countError++;
                throw new Exception();
            }
        }
    }
}