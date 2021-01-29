package by.it.abeseda.jd01_01;

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
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int j=sc.nextInt();
        int g=r+j;
        System.out.println("DEC:"+r+"+"+j+"="+g);
        System.out.println("BIN:"+Integer.toBinaryString(r)+"+"+Integer.toBinaryString(j)+"="+Integer.toBinaryString(g));
        System.out.println("HEX:"+Integer.toHexString(r)+"+"+Integer.toHexString(j)+"="+Integer.toHexString(g));
        System.out.println("OCT:"+Integer.toOctalString(r)+"+"+Integer.toOctalString(j)+"="+Integer.toOctalString(g));
    }


}
