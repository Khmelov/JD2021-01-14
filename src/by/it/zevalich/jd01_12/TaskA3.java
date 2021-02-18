package by.it.zevalich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int pos = 0;
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
                list.add(pos, value);
            } else {
                list.add(pos++, value);
            }
        }
        System.out.println(list);
    }
}
