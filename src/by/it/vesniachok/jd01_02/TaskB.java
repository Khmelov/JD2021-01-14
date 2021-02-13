package by.it.vesniachok.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    private static void step1() {

        int[][] twoDimArray = new int[5][5];

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {

                if (i == 0 && j == 0) {
                    twoDimArray[i][j] = 1;
                }

                if (i == 0 && j != 0) {
                    twoDimArray[i][j] = twoDimArray[i][j - 1] + 1;
                }

                if (i != 0 && j != 0) {
                    twoDimArray[i][j] = twoDimArray[i][j - 1] + 1;
                }

                if (i != 0 && j == 0) {
                    twoDimArray[i][j] = twoDimArray[i - 1][twoDimArray[0].length - 1] + 1;
                }

                System.out.println(Arrays.deepToString(twoDimArray));
            }
        }

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                if (j != twoDimArray[0].length - 1) {
                    System.out.print(twoDimArray[i][j] + " ");
                } else {
                    System.out.print(twoDimArray[i][j] + "\n");
                }
            }
        }
    }

    private static void step2(int month) {

        String[] months = {"январь", "февраль", "март", "апрель", "май", "июнь",
                "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};

        switch (month) {
            case 1 -> System.out.println(months[0]);
            case 2 -> System.out.println(months[1]);
            case 3 -> System.out.println(months[2]);
            case 4 -> System.out.println(months[3]);
            case 5 -> System.out.println(months[4]);
            case 6 -> System.out.println(months[5]);
            case 7 -> System.out.println(months[6]);
            case 8 -> System.out.println(months[7]);
            case 9 -> System.out.println(months[8]);
            case 10 -> System.out.println(months[9]);
            case 11 -> System.out.println(months[10]);
            case 12 -> System.out.println(months[11]);
            default -> System.out.println("нет такого месяца");
        }
    }


    private static void step3(double a, double b, double c) {
        double d = b * b - 4 * a * c;

        double result;
        double result2;

        if (d < 0) {
            System.out.println("корней нет");
        }

        if (d == 0) {
            result = (-b) / (2 * a);
            System.out.println("X = " + result);
        }
        if (d > 0) {
            result = ((-b) + Math.sqrt(d)) / (2 * a);
            result2 = ((-b) - Math.sqrt(d)) / (2 * a);
            System.out.println("X1 = " + result);
            System.out.println("X2 = " + result2);
        }
    }


    public static void main(String[] args) {
        step1();

        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        step2(month);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        step3(a, b, c);

    }
}

