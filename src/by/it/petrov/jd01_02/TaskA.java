package by.it.petrov.jd01_02;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }

    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int value : array) {
            if (value>max){
                max=value;
            }
            if (value<min){
                min=value;
            }
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        double avg = (double) sum / array.length;
        for (int value : array) {
            if(value<avg){
                System.out.println(value);
            }
        }

    }

    private static void step3(int[] array) {
        String values ="";
        int min = array[0];
        for (int value : array) {
            if (value<min){
                min = value;
            }
        }

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i]==min){
                values += Integer.toString(i);
            }
        }
        String str = new String(values);
        System.out.println(str.replace("", " "));
    }
}