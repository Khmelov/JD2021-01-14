package by.it.tashtsimirov.jd01_05;

import static java.lang.Math.*;


public class TaskA {
    
    public static void main(String[] args) {

        Step1();
        Step2();
        Step3();
    }


    private static void Step1() {

        double a = 756.13;
        double x = 0.3;

        double zA = cos(pow((x*x+PI/6),5));
        double zB = sqrt(x*pow(a,3));
        double zC = log((a-1.12*x)/4);
        double z = zA - zB - zC;

        double zall = (cos(pow((x*x+PI/6),5))) - (sqrt(x*pow(a,3))) - (log((a-1.12*x)/4));

        System.out.println("z = " + z);
        System.out.println("z = " + zall);

    }


    private static void Step2() {

        double a = 1.21;
        double b = 0.371;

        double y = tan(pow(a+b,2)) - cbrt(a+1.5) + a*pow(b,5) - b/log(a*a);

        System.out.println(y);

    }


    private static void Step3() {

        double x = 12.1;
         for (double a = -5; a <= 12; a = a + 3.75) {
             double f = exp(a*x)-3.45*a;
             System.out.printf("При a=%6.2f f=%g\n",a,f);
         }

    }




}
