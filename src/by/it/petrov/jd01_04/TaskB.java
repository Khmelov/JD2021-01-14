package by.it.petrov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        int numberOfEmployees;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество сотрудников");
        numberOfEmployees = sc.nextInt();
        String[] surnames = new String[numberOfEmployees];

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.printf("Введите фамилию сотрудника №%d\n", i + 1);
            surnames[i] = sc.next();
        }

        int[][] salaries = new int[numberOfEmployees][4];

        sc.nextLine();

        for (int i = 0; i < salaries.length; i++) {
            System.out.printf("Введите зарплату для %s\n", surnames[i]);
            int[] onesSalaries = InOut.getArrayInt(sc.nextLine());
            for (int j = 0; j < salaries[0].length; j++) {
                salaries[i][j] = onesSalaries[j];
            }
        }

        int[] sumOfSalaries = new int[numberOfEmployees]; // Сумма зарплат работников по месяцам
        for (int i = 0; i < numberOfEmployees; i++) {
            for (int j = 0; j < 4; j++) {
                sumOfSalaries[i] = sumOfSalaries[i] + salaries[i][j];
            }
        }

        int wholeSumOfSalaries = 0; // Общая сумма зарплат работников за весь период
        for (int i = 0; i < numberOfEmployees; i++) {
            wholeSumOfSalaries  += sumOfSalaries[i];
        }
        double averageSalary = (double) wholeSumOfSalaries / (numberOfEmployees * 4); // Средняя заработная плата на сотрудника

        // Вывод результата по полученным данным

        System.out.printf("------------------------------------------------------%n");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-8s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.printf("------------------------------------------------------%n");
        for (int i = 0; i < salaries.length; i++) {
            System.out.printf("%-9s%-10d%-10d%-10d%-10d%-8d%n", surnames[i], salaries[i][0], salaries[i][1], salaries[i][2],
                    salaries[i][3], sumOfSalaries[i]);
        }
        System.out.printf("------------------------------------------------------%n");
        System.out.printf("%-9s%-10d%n", "Итого", wholeSumOfSalaries);
        System.out.printf("%-9s%-10.6f%n", "Средняя", averageSalary);
    }
}
