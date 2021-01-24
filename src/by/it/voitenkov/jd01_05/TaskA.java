package by.it.voitenkov.jd01_05;

import static java.lang.Math.*;

/**
 * Задачу 1 решал специально с вызовом класса и без прямого обращения к классу Math.
 */
public class TaskA {

    public static void main(String[] args) {
        final double A = 756.13;
        final double X = 0.3;
        double z;

        double part1 = Math.cos(Math.pow(Math.pow(X, 2) + Math.PI / 6, 5));
        double part2 = Math.sqrt(X * Math.pow(A, 3));
        double part3 = Math.log(Math.abs((A - 1.12 * X) / 4));
        z = part1 - part2 - part3;

        System.out.println(z);
        System.out.println(expression());
        calculateFunction();
        tabulateFunction();
    }

    static double expression() {

        return cos(pow(pow(0.3, 2) + PI / 6, 5)) -
                sqrt(0.3 * pow(756.13, 3)) +
                log(abs((756.13 - 1.12 * 0.3) / 4));
    }

    static void calculateFunction() {
        double a = 1.21;
        double b = 0.371;
        double function = tan(pow((a + b), 2)) - cbrt((a + 1.5)) + (a * pow(b, 5)) - b / log(pow((a), 2));
        System.out.println(function);
    }

    static void tabulateFunction() {
        double x = 12.1;
        double deltaA = 3.75;

        for (double a = -5; a <= 12; a = a + deltaA) {

            double f = exp(a * x) - 3.45 * a;
            System.out.printf("При a = %6.2f f = %g\n", a, f);
        }
    }
}