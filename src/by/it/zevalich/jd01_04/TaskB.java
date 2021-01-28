package by.it.zevalich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double middle = 0;
        int total = 0;
        int numOfPeople = sc.nextInt();
        String[] header = {"Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого"};
        String[] surname = new String[numOfPeople];
        for (int i = 0; i < surname.length; i++) {
            surname[i] = sc.next();
        }
        int[][] salary = new int[numOfPeople][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.print("Введите зарплату для " + surname[i] + ":");
            for(int j = 0; j < salary[i].length; j++){
                salary[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < header.length; i++) {
            System.out.printf("%-10s", header[i]);
            if (i == header.length - 1) {
                System.out.println();
            }
        }
        for (int i = 0; i < salary.length; i++) {
            int totalOfQuarter = 0;
            System.out.printf("%-10s", surname[i]);
            for(int j = 0; j < salary[i].length; j++){
                int count = salary[i][j];
                totalOfQuarter+=count;
                total+=totalOfQuarter;
                System.out.printf("%-10d", salary[i][j]);
            }
            System.out.printf("%-1d\n", totalOfQuarter);
            if(i == salary.length-1){
                middle = total / (double)(numOfPeople*4);
                System.out.printf("%-10s%-1d\n%-10s%-1.6f", "Итого", total, "Средняя", middle);
            }
        }
    }
}
