package by.it.lapushkin.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа: прим. 34 26");

        while (scanner.hasNext()) {
            int b = scanner.nextInt();
            int a = scanner.nextInt();
            if (a != 0 && b != 0) {
                System.out.println("Sum = " + (a + b));
                break;
            }

        }
        scanner.close();


    }
}
