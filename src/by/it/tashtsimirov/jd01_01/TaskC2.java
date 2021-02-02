package by.it.tashtsimirov.jd01_01;

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

import java.math.BigInteger;
import java.util.Scanner;

class TaskC2 {
    public static void main(String[] args) {

        Scanner num = new Scanner(System.in);
        int dec1 = num.nextInt();
        int dec2 = num.nextInt();
        int sumdec = dec1 + dec2;


        System.out.println("DEC:" + dec1 + "+" + dec2 + "=" + sumdec);
        System.out.println("BIN:" + Integer.toBinaryString(dec1) + "+" + Integer.toBinaryString(dec2) + "=" + Integer.toBinaryString(sumdec));
        System.out.println("HEX:" + Integer.toHexString(dec1) + "+" + Integer.toHexString(dec2) + "=" + Integer.toHexString(sumdec));
        System.out.println("OCT:" + Integer.toOctalString(dec1) + "+" + Integer.toOctalString(dec2) + "=" + Integer.toOctalString(sumdec));
    }

}
