package by.it.petrov.jd01_01;

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
        System.out.println("Enter two numbers divided by whitespace  ");
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        /*String[] strToArray = twoNumbers.split("\\s");
        int firstNumber = Integer.parseInt(strToArray[0]);
        int secondNumber = Integer.parseInt(strToArray[1]);*/
        int sum = firstNumber + secondNumber;
        System.out.println("Sum = " + sum);

    }
}
