package by.it.petrov.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuffer sb=new StringBuffer();
        HashMap<String, Integer> wordsMap = new HashMap<>();
        String str;
        while (!((str = sc.next()).equals("end"))){
            str = str.replaceAll("[\\d.,;!? ]+", "");
            if((str.equals("don’t") || str.equals("isn't"))
                    && (wordsMap.containsKey("don’t") || wordsMap.containsKey("isn't"))){
                if(wordsMap.containsKey("don’t")){
                    wordsMap.replace("don’t", wordsMap.get("don’t"),wordsMap.get("don’t") + 1 );
                } else {
                    wordsMap.replace("isn't", wordsMap.get("isn't"),wordsMap.get("isn't") + 1 );
                }
                continue;
            }
            if(!wordsMap.containsKey(str) && !str.equals("")){
                wordsMap.put(str, 1);
                continue;
            }
            if(!(str.equals(""))){
                wordsMap.replace(str,wordsMap.get(str), wordsMap.get(str) + 1);
            }
        }
        System.out.println(wordsMap);
    }
}
