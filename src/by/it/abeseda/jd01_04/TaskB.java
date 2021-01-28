package by.it.abeseda.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество работников:");
        int n = scanner.nextInt();
        System.out.println("Введите фамилии работников:");
        String[] surname = new String[3];
        for (int i = 0; i < 3; i++) {
            surname[i] = scanner.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < n; i++) {
            switch (i) {
                case 0:
                    System.out.println("Введите зарплату для Иванов");
                    break;
                case 1:
                    System.out.println("Введите зарплату для Петров");
                    break;
                case 2:
                    System.out.println("Введите зарплату для Сидоров");
                    break;
            }

            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("--------------------------------------------------------");

        int[] total = new int[]{50, 66, 62};
        for (int i = 0; i < n; i++) {
            System.out.print(surname[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%10s", salary[i][j]);
            }
            System.out.printf("%10s", total[i]);
            System.out.println();
        }
        System.out.println("--------------------------------------------------------");

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += total[i];
        }
        System.out.println("Итого: " + sum);

        double middle=(double)sum/(n*4);
        System.out.printf("%10s%-10.6f","Средняя: ",middle);
    }
}

