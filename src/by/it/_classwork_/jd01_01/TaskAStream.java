package by.it._classwork_.jd01_01;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TaskAStream {
    public static void main(String[] args) {
        //TASKA2

        /*public static void main(String[] args) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Я начинаю изучать Java!");
            }
        }*/
        Integer [] arr = new Integer[]{1, 2, 3, 4, 5, 1};
        System.out.println(Stream.of(arr).filter(i -> i == 1).count());
        
    }
}
