package by.it.shebeko.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];                            //new.int то создаю массив array из 10 элементов  .var
        for (int i = 0; i < array.length; i++) {     // mas. fori [jxe vfccbd gtht,hfnm d wbrkt array.fori массив перебрать в цикле
            array[i] = scanner.nextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }
    private static void step1 (int[]array){
        int min = array [0];  //считаем минимумом первый эл-т массива
        int max = array [0];
        for (int element : array) { //fori зменили на foreach  for int i=0, i<array.lenth; i ++
            if (min > element) min = element; // if min> array[i]   min = array [i]
            if (max < element) max = element;
        }
        System.out.println(min + " " + max);
        }


    private static void step2(int[] array){
        double avg = 0;          //пребираем элементы массива, все складываем  и делим
        for (int element : array) {
            avg = avg + element;      //здесь сумма всех элеменов массива
        }
        avg = avg/array.length;    //выч ср арф делим сумму на кол-во элементов в массиве
        for (int element : array) {    //снова перебираем
            if (element < avg)          //эсли эмент меньше ср арифм то печатаем
                System.out.print(element + " ");
        }
    }


    private static void step3(int[] array) {
        int min = array [0];
            for (int element : array) {
            if (min > element) min = element;          //нашли самое мал число
            }
        for (int i = array.length-1; i >=0 ; i--) {
            if (array[i]== min)
                System.out.print(i + " ");

        }
    }
}
