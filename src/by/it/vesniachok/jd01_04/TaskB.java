package by.it.vesniachok.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество работников:");
        int a = scan.nextInt();
        System.out.println("Введите фамилии работников:");
        String[] surname = new String[a];
        for (int i = 0; i < surname.length; i++) {
            surname[i] = scan.next();
        }
        int[][] salary = new int[a][4];
        int[] total = new int[a];
        double average = 0;
        double avg = 0;
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + surname[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = scan.nextInt();
                total[i] = total[i] + salary[i][j];
            }
            average = average + total[i];
        }
        avg = average/12;

        System.out.printf("%-10s%-9s%-9s%-9s%-9s%-9s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("----------------------------------------------------------");


        int[][] out = new int[a][4];
        for (int i = 0; i < out.length; i++) {
            System.out.printf("%7s:   ", surname[i]);
            for (int j = 0; j < out[i].length; j++) {
                System.out.printf("%-9s", salary[i][j]);
            }
            System.out.print(total[i]);
            System.out.println();
        }




        System.out.println("----------------------------------------------------------");
        System.out.printf("%7s%6s%n", "Итого  ", average);
        System.out.printf("%7s%.4f", "Средняя ", avg);
    }
}




