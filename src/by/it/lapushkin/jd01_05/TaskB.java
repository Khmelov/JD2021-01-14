package by.it.lapushkin.jd01_05;

import static java.lang.Math.*;
import static java.lang.Math.abs;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        double step = 0.2;
        for (double a = 0; a <= 2; a += step) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y = y + pow(7, a) - cos(x);
            }
            System.out.printf("При a=%6.2f y=%g\n", a, y);
        }
        System.out.println();
    }

    private static void step1() {
        double step = 0.5;
        for (double x = -5.5; x <= 1.5; x+= step) {
            double beta;
            double alpha;
            if (x / 2 > -2 && x / 2 <= -1)
                beta = sin(pow(x, 2));
            else if (x / 2 > -1 && x / 2 < 0.2)
                beta = cos(pow(x, 2));
            else if (x / 2 == 0.2)
                beta = 1 / (tan(pow(x, 2)));
            else {
                System.out.printf("При x/2=%6.2f вычисления не определены\n", x / 2);
                continue;
            }

            alpha = log10(abs(beta + 2.74));
            System.out.printf("При x/2=%6.2f alpha=%g\n", x / 2, alpha);
        }
    }
}
