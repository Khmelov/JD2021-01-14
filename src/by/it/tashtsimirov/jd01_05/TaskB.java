package by.it.tashtsimirov.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {

        double y = 0;

        for (double a = 0; a <= 2; a = a + 0.2) {
            for (double x = 1; x <= 6; x = x+1) {
                y += ((pow(7, a) - cos(x)));
                System.out.printf("При a=%6.2f и x=%6.2f y=%g\n",a,x,y);
            }
        }
        System.out.println();



        for (double x = -6; x <= 2 ; x = x+0.5) {

            if ((x/2) > -2 && (x/2) <= -1) {
                double a = log(sin(pow(x,2)) + 2.74);
                    System.out.printf("При x/2=%8.4f a=%g\n",(x/2),a);
            }

            if ((x/2) > -1 && (x/2) <= 0.2) {
                double a = log(cos(pow(x,2)) + 2.74);
                    System.out.printf("При x/2=%8.4f a=%g\n",(x/2),a);
            }

            if ((x/2) == 0.2) {
                double a = log((1/tan(pow(x,2))) + 2.74);
                    System.out.printf("При x/2=%8.4f a=%g\n",(x/2),a);
            }
        }
    }
}
