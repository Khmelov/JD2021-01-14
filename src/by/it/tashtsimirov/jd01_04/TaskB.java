package by.it.tashtsimirov.jd01_04;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int s = 0;


        String[] nameWork = new String[n];
        int[][] moneyKv = new int[n][4];

        for (int i = 0; i < n; i++) {
            nameWork[i] = sca.next();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + nameWork[s]);
            for (int j = 0; j < 4; j++) {
                moneyKv[s][j] = sca.nextInt();
            }
            s++;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                sum += moneyKv[i][j];
            }
        }
        double dSum = (sum / (double) n / 4);



        System.out.printf("%-20s%-12s%-12s%-12s%-12s%-10s","Фамилия","Квартал-1","Квартал-2","Квартал-3","Квартал-4","Итого");
        System.out.println("\n-------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s%-12s%-12s%-12s%-12s%n",nameWork[i],moneyKv[i][0],moneyKv[i][1],moneyKv[i][2],moneyKv[i][3]);
        }

        System.out.println();


        System.out.printf("%-20s%-12s%-12s%-12s%-12s%-10s","Фамилия","Квартал-1","Квартал-2","Квартал-3","Квартал-4","Итого");
        System.out.println("\n-------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s%-12s%-12s%-12s%-12s%-12s%n",nameWork[i],moneyKv[i][0],moneyKv[i][1],moneyKv[i][2],moneyKv[i][3],moneyKv[i][0]+moneyKv[i][1]+moneyKv[i][2]+moneyKv[i][3]);
        }
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.printf("%-20s%-12d%n","Итого",sum);
        System.out.printf("%-20s%-12.6f","Средняя",dSum);


    }


}
