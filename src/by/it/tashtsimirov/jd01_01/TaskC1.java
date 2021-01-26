package by.it.tashtsimirov.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/

import java.util.Scanner;
class TaskC1 {
    public static void main(String[] args) {
        Scanner twonum = new Scanner(System.in);
        System.out.print("Ввод: \n");
        System.out.println("Вывод: \n" + "Sum = " + (twonum.nextInt() + twonum.nextInt()));
    }





}
