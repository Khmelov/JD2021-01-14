package by.it.shebeko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();               //водим кол-во людей
        String[] surname = new String[n];   //создаем массив фамилий
        for (int i = 0; i < surname.length; i++) {   //пробегаем цикл
            surname[i] = sc.next();     //каждому итому элементу вводим фамилию
        }
        int[][] salary = new int[n][4];
        int[] total = new int[n];
        double sum = 0;
        double avg = 0;
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + surname[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = sc.nextInt();
                total[i] = total[i] + salary[i][j];
            }
            sum = sum + total[i];
        }
        avg = sum/12;

        System.out.printf("%-10s%-9s%-9s%-9s%-9s%-9s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("----------------------------------------------------------");


        int[][] out = new int[n][4];
        for (int i = 0; i < out.length; i++) {
            System.out.printf("%7s:   ", surname[i]);
            for (int j = 0; j < out[i].length; j++) {
                System.out.printf("%-9s", salary[i][j]);
            }
            System.out.print(total[i]);
            System.out.println();
        }




        System.out.println("----------------------------------------------------------");
        System.out.printf("%7s%6s%n", "Итого  ", sum);
        System.out.printf("%7s%.4f", "Средняя ", avg);
    }
}




