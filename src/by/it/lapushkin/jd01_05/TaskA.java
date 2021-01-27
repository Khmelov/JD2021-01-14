package by.it.lapushkin.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        final double X = 0.3;
        final double Y = 756.13;
        double part1 = cos(pow((X * X + PI / 6), 5));
        double part2 = sqrt(X * Y * Y * Y);
        double part3 = log(abs((Y - 1.12 * X) / 4));

        double z = part1 - part2 - part3;
        System.out.println("z=" + z);
    }

    private static void step2() {
        final double X = 1.21;
        final double Z = 0.371;
        double y = tan(pow(X + Z, 2)) - cbrt(X + 1.5) + X * pow(Z, 5) - Z / log(X * X);
        System.out.println("y=" + y);
    }

    private static void step3() {
        final double X = 12.1;
        for (double a = -5; a <= 12; a = a + 3.75) {
            double f = exp(a * X) - 3.45 * a;
            System.out.printf("При a=%6.2f f=%g\n", a, f);
        }
    }
}
