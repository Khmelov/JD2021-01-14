package by.it.zevalich.jd01_01;

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
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a + b;
        System.out.println("DEC:" + a + "+" + b + "=" + sum);
        System.out.println("BIN:" + Integer.toString(a,2) + "+" + Integer.toString(b,2) + "=" + Integer.toString(sum,2));
        System.out.println("HEX:" + Integer.toString(a,16) + "+" + Integer.toString(b,16) + "=" + Integer.toString(sum,16));
        System.out.println("OCT:" + Integer.toString(a,8) + "+" + Integer.toString(b,8) + "=" + Integer.toString(sum,8));
    }


}
