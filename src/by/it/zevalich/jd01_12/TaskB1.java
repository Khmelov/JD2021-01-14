package by.it.zevalich.jd01_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String str;
        List<String> list = new ArrayList<>() ;
        HashMap<String, Integer> map = new HashMap<>();
        while (true){
            str = scanner.nextLine();
            count++;
            list.add(str);
            if(str.equals("end") && count == 100){
                break;
            }
        }

    }
}
