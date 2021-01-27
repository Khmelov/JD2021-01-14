package by.it.shebeko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }


    private static void step1() {
        double y = 0.0;
        double a = 0.0;
    while (a <= 2) {
        for (int x = 0; x <= 6; x++) {
            y = y + ((pow(7, a)) - cos(x));
        }
        a = a + 0.2;
        System.out.printf("При а = %6.2f  y = %g\n", a, y);
    }
    }




    private static void step2() {
        double beta = 0.0;
        for (double x = -5.5; x < 2; x = x + 0.5) {
            if (x/2 > -2 && x/2<= -1){
                beta = sin(x * x);
            }
            else if (x/2 > -1 && x/2 < 0.2){
                 beta = cos(x *x);
            }
            else if (x/2 == 0.2){
                 beta = 1/ tan(x);
            }
            else {
                System.out.println("нет решений");
            }
             double alfa = log10(abs(beta + 2.74));
            System.out.println("При x =" + x +" alfa = " + alfa);
        }
    }
}
