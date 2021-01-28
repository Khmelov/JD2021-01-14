package by.it.abeseda.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = pow(7, a) * 6;
            double z = 0;
            for (int x = 1; x <= 6; x++) {
                z = z + cos(x);
            }


            y = y - z;
            System.out.printf("При a=%6.2f y=%g\n", a, y);
        }
    }

    private static void step2() {
        double b = 0;

        for (double x = -6+0.5; x < 2;x+=0.5) {//тут 6 не включая! можно использовать префиксную форму!

            if (-2 < x/2 && x/2 <= -1) {
                b = sin(x * x);
                double a = log10(abs(b + 2.74));
                System.out.println("Величина b=" + b + "Величина a=" + a);
            } else if (-1 < x/2 && x/2 < 0.2) {
                b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.println("Величина b=" + b + "Величина a=" + a);
            } else if (x/2 == 0.2) {
                b = tanh(x * x);
                double a = log10(abs(b + 2.74));
                System.out.println("Величина b=" + b + "Величина a=" + a);
            } else {
                System.out.println("При данном значение " + x/2 + " вычисление  невозможно.");
            }
        }
    }
}


