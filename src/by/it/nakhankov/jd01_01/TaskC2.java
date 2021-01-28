package by.it.nakhankov.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74

Допускается свободное использование любых методов стандартной библиотеки
*/
class TaskC2 {
    public static void main(String[] args) {

        int number1;
        int number2;

        Scanner scanner = new Scanner(System.in);

        number1 = scanner.nextInt();
        number2 = scanner.nextInt();
        System.out.println("DEC:" + number1 + "+" + number2 + "=" + (number1 + number2));
        System.out.println("BIN:" + Integer.toBinaryString(number1) + "+" + Integer.toBinaryString(number2) + "=" + Integer.toBinaryString(number1 + number2));
        System.out.println("HEX:" + Integer.toHexString(number1) + "+" + Integer.toHexString(number2) + "=" + Integer.toHexString(number1 + number2));
        System.out.println("OCT:" + Integer.toOctalString(number1) + "+" + Integer.toOctalString(number2) + "=" + Integer.toOctalString(number1 + number2));



    }


}
