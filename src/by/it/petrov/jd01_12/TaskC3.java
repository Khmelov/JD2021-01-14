package by.it.petrov.jd01_12;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// {[{()}][()]{()}}

public class TaskC3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder sb = new StringBuilder(line);
        Pattern pattern = Pattern.compile("[\\[\\](){}]");
        Matcher matcher = pattern.matcher(line);
        HashMap<String, Integer> bracketsMap = new HashMap<>();

        boolean internalError = false;

        while (matcher.find()) {
            System.out.println(matcher.group());
            if (!bracketsMap.containsKey(matcher.group())) {
                bracketsMap.put(matcher.group(), 0);

            } else if (matcher.group().equals("}") && !bracketsMap.containsKey("{")){
                System.out.println(false);
                internalError = true;
                break;

            } else if (matcher.group().equals("]") && !bracketsMap.containsKey("[")){
                System.out.println(false);
                internalError = true;
                break;

            } else if (matcher.group().equals(")") && !bracketsMap.containsKey("(")){
                System.out.println(false);
                internalError = true;
                break;

            } else {
                bracketsMap.replace(matcher.group(), bracketsMap.get(matcher.group()) + 1);
            }
        }


        while (!internalError){
            if ((bracketsMap.get("{") + bracketsMap.get("}")) % 2 != 0){
                System.out.println(false);
                break;
            } else if ((bracketsMap.get("[") + bracketsMap.get("]")) % 2 != 0){
                System.out.println(false);
                break;
            } else if ((bracketsMap.get("(") + bracketsMap.get(")")) % 2 != 0){
                System.out.println(false);
                break;
            } else { System.out.println(true); break;}
        }

        System.out.println(bracketsMap);
    }
}
