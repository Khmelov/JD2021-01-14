package by.it.voitenkov.jd01_02;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        int numberMonth;
        double a;
        double b;
        double c;

        Scanner scanner = new Scanner(System.in);
        numberMonth = scanner.nextInt();
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        step1();
        step2(numberMonth);
        step3(a, b, c);
    }

    static void step1() {

        for (int number = 1; number < 26; number++) {
            System.out.print(number + " ");

            if (number % 5 == 0) {
                System.out.println();
            }
        }
    }

    static void step2(int month) {

        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }
    }

    static void step3(double a, double b, double c) {
        double discriminant;

        discriminant = Math.pow(b, 2) - 4 * a * c;
        double firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
        double secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);

        if (discriminant > 0) {
            System.out.println(firstRoot + " " + secondRoot);
        } else if (discriminant == 0) {
            System.out.println(firstRoot);
        } else {
            System.out.println("корней нет");
        }
    }
}
