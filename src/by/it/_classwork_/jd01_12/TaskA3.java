package by.it._classwork_.jd01_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int posZero = 0;
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String str = scanner.next();
            if (str.equals("end")) {
                break;
            }
            Integer value = Integer.valueOf(str);
            if (value < 0) {
                list.add(value);
            } else if (value == 0) {
                list.add(posZero, value);
            } else {
                list.add(posZero++, value);
            }
        }
        System.out.println(list);
    }
}
