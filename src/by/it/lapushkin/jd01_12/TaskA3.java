package by.it.lapushkin.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int posZero =0;
        for (;;){
            if (scanner.hasNext()){
                String next = scanner.next();
                if (next.equals("end")){
                 break;
                }
                Integer value = Integer.valueOf(next);


                if (value < 0) {
                    list.add(value);
                } else if (value == 0) {
                    list.add(posZero, value);
                } else {
                    list.add(posZero++, value);
                }

            }
        }
        System.out.println(list);
    }
}
