package by.it.voitenkov.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {
        task1();
        task2();
    }

    static void task1() {

        for (double a = 0.0; a <= 2; a += 0.2) {
            double summa = 0;

            for (int j = 1; j < 7; j++) {
                summa = summa + pow(7, a) - cos(j);
            }
            System.out.printf("При a=%-9.2fСумма y=%e\n", a, summa);
        }
        System.out.println();
    }

    static void task2() {
        double divider = 2.0;

        for (double x = -6; x < 2; x = x + 0.5) {
            if (x > -6) {
                if (-2 < x / divider && x / divider <= -1) {
                    printTask2(x / divider, log10(abs(sin(pow(x, 2)) + 2.74)));
                } else if (-1 < x / divider && x / divider < 0.2) {
                    printTask2(x / divider, log10(abs(cos(pow(x, 2)) + 2.74)));
                } else if (x / divider == 0.2) {
                    printTask2(x / divider, log10(abs(cos(pow(x, 2)) / sin(pow(x, 2)) + 2.74)));
                } else {
                    System.out.printf("При x/2 = %-9.2f a = %s\n", x / divider, "вычисления не определены");
                }
            }
        }
    }

    static void printTask2(double magnitude, double number) {
        System.out.printf("При x/2 = %-9.2f a = %e\n", magnitude, number);
    }
}