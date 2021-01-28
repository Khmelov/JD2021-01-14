package by.it.nakhankov.jd01_04;

import java.io.Reader;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        int numberPeople;
        int sumOfAllSalaries = 0;
        int numberOfQuarters = 4;
        StringBuilder delimiter = new StringBuilder("-");
        String[] tableColumnNames = {"Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого"};
        String[] arraySurnames;
        int[][] arrayOfSalaries;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число человек: ");
        numberPeople = scanner.nextInt();

        arraySurnames = new String[numberPeople];
        arrayOfSalaries = new int[arraySurnames.length][numberOfQuarters];

        delimiter.append("-".repeat(tableColumnNames.length * 15));
        for (int i = 0; i < arraySurnames.length; i++) {
            System.out.print("Введите фамилию человека: ");
            arraySurnames[i] = scanner.next();
        }

        for (int i = 0; i < arrayOfSalaries.length; i++) {
            System.out.print("Введите зарплату для " + arraySurnames[i] + ":\n");
            for (int j = 0; j < arrayOfSalaries[i].length; j++) {
                arrayOfSalaries[i][j] = scanner.nextInt();
            }
        }

        System.out.printf("%s\n", delimiter.toString());

        for (int i = 0; i < tableColumnNames.length; i++) {

            if (i < tableColumnNames.length - 1) {
                System.out.printf("%-15s", tableColumnNames[i]);
            } else {
                System.out.printf("%-1s\n", tableColumnNames[i]);
            }
        }

        System.out.printf("%s\n", delimiter.toString());

        for (int i = 0; i < arrayOfSalaries.length; i++) {
            int sum = 0;
            String name = arraySurnames[i];
            System.out.printf("%-15s", arraySurnames[i]);

            for (int j = 0; j < arrayOfSalaries[arrayOfSalaries.length - 1].length; j++) {
                int quarterlySalary = arrayOfSalaries[i][j];
                sum += quarterlySalary;
                sumOfAllSalaries += quarterlySalary;
                System.out.printf("%-15d", arrayOfSalaries[i][j]);
            }

            System.out.printf("%-1d\n", sum);

            if (i == arrayOfSalaries.length - 1) {
                System.out.printf("%s\n", delimiter.toString());
                double averageSalary = (sumOfAllSalaries / (double) (numberPeople * numberOfQuarters));
                System.out.printf("%-15s%-1d\n%-15s%-1.6f", "Итого", sumOfAllSalaries, "Средняя", averageSalary);
            }
        }
    }
    }




