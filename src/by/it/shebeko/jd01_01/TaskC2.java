package by.it.shebeko.jd01_01;

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
        System.out.println("Введите два числа:");
        int i = sc.nextInt();
        int k = sc.nextInt();
        int j = i + k;
        System.out.println("DEC:" + i + "+" + k + "=" + j);
        System.out.println("BIN:"+Integer.toBinaryString(i)+"+"+Integer.toBinaryString(k)+"="+Integer.toBinaryString(j));
        System.out.println("HEX:"+Integer.toHexString(i)+"+"+Integer.toHexString(k)+"="+Integer.toHexString(j));
        System.out.println("OCT:"+Integer.toOctalString(i)+"+"+Integer.toOctalString(k)+"="+Integer.toOctalString(j));
    }


}
