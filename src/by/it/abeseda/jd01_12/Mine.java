package by.it.abeseda.jd01_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mine {
    public static void main(String[] args) {
        String h="кот столб мышь рысь кот лебедь";
        List<String> text = new ArrayList<>();

        text.add(h);
        System.out.println(text);

        Map<String,Integer> integerMap=new HashMap<>();

        integerMap.put("медведь", 1);
        integerMap.put("рыба", 2);
        integerMap.put("креветка", 3);
        integerMap.put("мурзик", 4);
        integerMap.put("кот", 6);
        System.out.println(integerMap.get("креветка"));//ключ это string!




    }

}
