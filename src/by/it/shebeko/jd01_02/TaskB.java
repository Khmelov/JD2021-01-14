package by.it.shebeko.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        step1();
        step2(i);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);
    }
    private static void step1 () {
        for (int i = 1; i <26 ; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0)
                System.out.println();
        }
    }
    private static void step2 (int month) {
        int m = 12;
        switch (month) {
            case 1:
                System.out.println("январь");
            case 2:
                System.out.println("февраль");
            case 3:
                System.out.println("март");
            case 4:
                System.out.println("апрель");
            case 5:
                System.out.println("май");
            case 6:
                System.out.println("июнь");
            case 7:
                System.out.println("июль");
            case 8:
                System.out.println("август");
            case 9:
                System.out.println("сентябрь");
            case 10:
                System.out.println("октябрь");
            case 11:
                System.out.println("ноябрь");
            case 12:
                System.out.println("декабрь");
            default:
                System.out.println("нет такого месяца");


        }
    }


    private static void step3 (double a, double b, double c) {
    double D;
        D = (b * b) - (4 * a * c);
        if (D > 0) {
            double x1;
            double x2;
        x1 = (-b + Math.sqrt(D)) / (2 * a);
        x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("корни уравнения" + x1 + x2);
        }
        else if (D == 0) {
            double x0;
        x0 = -b / (2* a);
            System.out.println("корень уравнения" + x0);
        }
        else {
            System.out.println("корней нет");
        }
        }
    }
