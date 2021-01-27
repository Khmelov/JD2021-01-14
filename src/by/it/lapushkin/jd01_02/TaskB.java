package by.it.lapushkin.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        double arrayABC[] = new double[3];

        for (int i = 0; i < arrayABC.length; i++) {
            arrayABC[i] = scanner.nextInt();
        }
        step1();
        step2(month);
        step3(arrayABC[0],arrayABC[1],arrayABC[2]);
    }

    private static void step1() {
        int index = 0;
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                //int c = (int) (1 + Math.random() * 25);
                index++;
                System.out.print(index + " ");
            }
            System.out.println();
        }

    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                mySout("январь");
                break;
            case 2:
                mySout("февраль");
                break;
            case 3:
                mySout("март");
                break;
            case 4:
                mySout("апрель");
                break;
            case 5:
                mySout("май");
                break;
            case 6:
                mySout("июнь");
                break;
            case 7:
                mySout("июль");
                break;
            case 8:
                mySout("август");
                break;
            case 9:
                mySout("сентябрь");
                break;
            case 10:
                mySout("октябрь");
                break;
            case 11:
                mySout("ноябрь");
                break;
            case 12:
                mySout("декабрь");
                break;
            default:
                mySout("нет такого месяца");
                break;
        }
    }

    private static void mySout(String month) {
        System.out.println(month);
    }


    private static void step3(double a, double b, double c) {
        double D = ((b*b) - 4*(a*c));
        if (D == 0){
            double x = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println(x);

        }else {
            if (D > 0){
                double x1 = (-b - Math.sqrt(D)) / (2 * a);
                double x2 = (-b + Math.sqrt(D)) / (2 * a);
                System.out.println(x1+" "+x2);

            }else {
                System.out.println("корней нет");
            }
        }
    }
}
