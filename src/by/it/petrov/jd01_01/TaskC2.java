package by.it.petrov.jd01_01;

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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers divided by whitespace  ");
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        /*String[] strToArray = twoNumbers.split("\\s");
        int firstNumber = Integer.parseInt(strToArray[0]);
        int secondNumber = Integer.parseInt(strToArray[1]);*/
        int sum = firstNumber + secondNumber;

        String firstNumberBin = Integer.toBinaryString(firstNumber);
        String secondNumberBin = Integer.toBinaryString(secondNumber);
        String sumBin = Integer.toBinaryString(sum);

        String firstNumberOct = Integer.toOctalString(firstNumber);
        String secondNumberOct = Integer.toOctalString(secondNumber);
        String sumOct = Integer.toOctalString(sum);

        String firstNumberHex = Integer.toHexString(firstNumber);
        String secondNumberHex = Integer.toHexString(secondNumber);
        String sumHex = Integer.toHexString(sum);

        System.out.println("DEC:" + firstNumber + "+" + secondNumber + "=" + sum);
        System.out.println("BIN:" + firstNumberBin + "+" + secondNumberBin + "=" + sumBin );
        System.out.println("HEX:" + firstNumberHex + "+" + secondNumberHex + "=" + sumHex );
        System.out.println("OCT:" + firstNumberOct + "+" + secondNumberOct + "=" + sumOct );

    }

}
