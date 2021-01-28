package by.it.petrov.jd01_05;
import static java.lang.Math.*;

public class TaskA {

    public static void main(String[] args) {

        double a = 756.13;
        double x = 0.3;
        double left = cos(pow(x * x + PI/6, 5));
        double middle = - sqrt(x * pow(a, 3));
        double right = - log(abs((a - 1.12 * x) / 4));
        double result1 = left + middle + right;
        System.out.println(result1);

        a = 1.21;
        double b = 0.371;
        double left2 = tan(pow(a+b, 2));
        double middle21 = - cbrt(a + 1.5);
        double middle22 = a * pow(b, 5);
        double right2 = - ( b / log(pow(a, 2)));
        double result2 = left2 + middle21 + middle22 + right2;
        System.out.println(result2);

        x = 12.1;
        int aLeftInterval = - 5;
        int aRightInterval = 12;
        double step = 3.75;
        double fResult;
        for (int i = 0; i < (aRightInterval - aLeftInterval) / step; i++) {
            a = aLeftInterval + i*step;
            fResult = pow(E, (aLeftInterval + i*step) * x) - 3.45 * (aLeftInterval + i*step);
            System.out.println("A value is  " + a);
            System.out.println(fResult);

        }
    }

}
