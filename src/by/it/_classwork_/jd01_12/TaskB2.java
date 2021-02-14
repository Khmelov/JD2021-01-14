package by.it._classwork_.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

public class TaskB2 {

    static String process(LinkedList<String> list) {
        String binary = Integer.toBinaryString(list.size());
        return list.get(Integer.valueOf(binary.substring(1) + binary.charAt(0), 2) - 1);
    }

    static String process(ArrayList<String> list) {
        String binary = Integer.toBinaryString(list.size());
        return list.get(Integer.valueOf(binary.substring(1) + binary.charAt(0), 2) - 1);
    }

}
