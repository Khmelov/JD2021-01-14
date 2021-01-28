package by.it.zevalich.jd01_05;


import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1(){
        for (double a = 0; a <= 2; a+=0.2){
            double sum = pow(7,a)*6;
            for(int i = 1; i <= 6; i++){
                sum-=cos(i);
            }
            System.out.printf("При a = %1.2f Сумма y =%e\n", a, sum);
        }
    }

    private static void step2(){
        double a;
        double b;
        for(double x = -6;x < 2;x += 0.5){
           if(x/2 > -2 && x/2 <= -1){
               b = sin(pow(x,2));
               a = log10(abs(b+2.74));
               System.out.printf("При x/2 = %-6.2f a= %e \n", x, a);
           }
           else if(x / 2 > - 1 && x / 2 < 0.2){
               b = cos(pow(x,2));
               a = log10(abs(b+2.74));
               System.out.printf("При x/2 = %-6.2f a= %e \n", x, a);
           }
           else if(x / 2 == 0.2){
               b = cos(pow(x,2))/sin(pow(x,2));
               a = log10(abs(b+2.74));
               System.out.printf("При x/2 = %-6.2f a= %e \n", x, a);
           }
           else{
               System.out.printf("При x/2= %-6.2f вычисления не возможны\n", x/2);
           }
        }
    }
}
