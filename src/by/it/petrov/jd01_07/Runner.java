package by.it.petrov.jd01_07;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.14);
        System.out.println(v1);

        double[] mass = new double[]{1, 2, 3};
        Var v2 = new Vector(mass);
        System.out.println(v2);

        Var v4 = new Vector("{0, 10, 15.04}");
        System.out.println(v4);

        Var v5 = new Matrix("{1, 2, 3}, {4, 5.0, 6.76}}");
        System.out.println(v5);
    }
}