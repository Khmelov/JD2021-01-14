package by.it.zevalich.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        List<String> string = new ArrayList<>();
        String s;
        while (!(s=scanner.nextLine()).equals("end")){
            String str = s.replaceAll("[^a-zA-Z’']", "");
            string.add(str);
        }
        for (int i = 0; i < string.size(); i++) {
            String str = string.get(i);
                if(!(map.containsKey(str))){
                    map.put(str,1);
                }
                else{
                    map.put(str,map.get(str)+1);
                }
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+ "=" + entry.getValue());
        }
        }
    }

