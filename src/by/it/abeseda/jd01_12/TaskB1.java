package by.it.abeseda.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str;
        List<String> text = new ArrayList<>();
        while (!(str=scanner.next()).equals("end")) {
            String newText=str.replaceAll("[^a-zA-Z’']", "");
            text.add(newText);
        }
        System.out.println(text);

        Map<String,Integer> integerMap=new HashMap<>();

        for (int i = 0; i < text.size(); i++) {

            String s = text.get(i);

            if (!(integerMap.containsKey(s))){
                integerMap.put(s, 1);//в данном случае ключ это string
                //integerMap.get(s) возвращает ключ и мы при его повторении прибавляем единицу
            }else {integerMap.put(s, integerMap.get(s)+1);}
        }

        //здесь делаем обход итератором и выводим значения
        for (Map.Entry<String, Integer> entry : integerMap.entrySet()) {

 //          System.out.println("Слово = " + entry.getKey() + ", Повторений = " + entry.getValue());
            System.out.println( entry.getKey() + "=" + entry.getValue());
        }
    }
}
