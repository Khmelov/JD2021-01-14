package by.it.khmelov.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        final double A = 756.13;
        final double X = 0.3;
        double part1 = cos(pow(pow(X, 2) + PI / 6, 5));
        double part2 = sqrt(X * A * A * A);
        double part3 = log(abs((A - 1.12 * X) / 4));
        double z=part1-part2-part3;
        System.out.println(z);
    }
}
