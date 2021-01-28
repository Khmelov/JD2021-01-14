package by.it.petrov.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

        double resultB1 = 0;

        for (double a = 0; a <= 2; a += 0.2) {
            System.out.println("For a = " + a + " result is " + resultB1);
            for (int x = 1; x <= 6; x++) {
                resultB1 = resultB1 + pow(7, a) - cos(x);
            }
        }

        double beta;
        double alpha;

        for (double x = -5.5; x < 2; x += 0.5) {
            if (x/2 > -2 && x/2 <=  -1){
                beta = sin(pow(x, 2));
                alpha = log10(abs(beta + 2.74));
                System.out.printf("For x/2=%.3f the result is %.10f%n", x/2, alpha);
                continue;
            }
            if (x/2 > -1 && x/2 <0.2){
                beta = cos(pow(x, 2));
                alpha = log10(abs(beta + 2.74));
                System.out.printf("For x/2=%.3f the result is %.10f%n", x/2, alpha);
                continue;
            }
            if (x == 0.2){
                beta = 1 / tan(pow(x, 2));
                alpha = log10(abs(beta + 2.74));
                System.out.printf("For x/2=%.3f the result is %.10f%n", x/2, alpha);
                continue;
            }
            if (x/2 <= -2 || x/2 > 0.2){
                System.out.printf("For x/2=%.3f computing is impossible%n", x/2);
            }
        }
    }
}
