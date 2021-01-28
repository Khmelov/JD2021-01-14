package by.it.petrov.jd01_01;

/*
Выводим квадрат числа
Напишите программу, которая считывает с клавиатуры целое число a и выводит квадрат этого числа (a * a).
Для считывания данных с клавиатуры используйте метод nextInt() объекта класса Scanner.

Создать Scanner можно так:
Scanner sc=new Scanner(System.in);

Прочитать число можно так:
int i=sc.nextInt();

Требования:
1. Программа должна выводить текст.
2. В программе необходимо создать объект типа Scanner.
3. Программа должна считывать число типа Int с клавиатуры.
4. Программа должна выводить квадрат считанного числа.

 */

import java.util.Scanner;

class TaskB1 {
    public static int pow(int value, int powValue){
        return (int) Math.pow(value, powValue);
    }

    public static int pow(int value, int powValue, int type){
        int result = 1;
        for (int i = 0; i < powValue; i++) {
            result = result * value;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Enter an integer  ");
        Scanner sc=new Scanner(System.in);
        int number_one = sc.nextInt();
        int square = pow(number_one,2);
        int square1 = pow(number_one,2, 1);
        System.out.println("The answer is  " + square);
        System.out.println("\nSecond method");
        System.out.println("The answer is  " + square1);
    }
}
