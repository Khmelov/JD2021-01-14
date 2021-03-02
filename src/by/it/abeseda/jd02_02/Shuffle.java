package by.it.abeseda.jd02_02;

import java.util.*;

public class Shuffle {

    private static Random random=new Random();
    public static void main(String[] args) {
        Map<String,Double> basket=new HashMap<>(4);
        basket.put("cottage cheese",2.11);
        basket.put("lemonade",3.0);
        basket.put("strawberry",22.89);
        basket.put("fish",9.1);

        Iterator<Map.Entry<String,Double>> iter1=basket.entrySet().iterator();

        while (iter1.hasNext()){
            System.out.println(iter1.next());}


        int min=1;
        int max=4;
        int k=random.nextInt(max - min + 1) + min;
        System.out.println(k);
        List<String> products = new ArrayList<>(basket.keySet());

        for (int i = 0; i < k; i++) {
            int randomIndex = random.nextInt(products.size());
            String randomValue = products.get(randomIndex);
            System.out.println(randomValue+" "+basket.get(randomValue));

        }










    }
}
