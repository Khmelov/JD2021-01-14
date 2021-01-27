package by.it.vesniachok.jd01_05;

import static java.lang.Math.cos;
import static java.lang.Math.pow;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();

    }

    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            for (double x = 1; x <= 6; x++) {

                double y = (pow(7, a) - cos(x));

                System.out.printf("При а=%6.2f y=%g\n", a, y);
                break;
            }

        }
    }

    private static void step2() {
        for (double x = -5; x <= 2; x = x + 0.5) {
        }

    }
}
