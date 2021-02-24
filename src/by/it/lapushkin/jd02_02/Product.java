package by.it.lapushkin.jd02_02;

import static by.it.lapushkin.jd02_02.Helper.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Product {
    private static final Random random = new Random();
    static final HashMap<String, Integer> productMap = new HashMap<>();

    static {
        productMap.put("CPU", 112);
        productMap.put("RAM4GB", 11);
        productMap.put("RAM8GB", 20);
        productMap.put("Mouse", 3);
        productMap.put("GPU", 666);
        productMap.put("MotherBoard", 60);
        productMap.put("Keyboard", 1);
        productMap.put("SSD", 40);
        productMap.put("HDD", 33);

    }

    private Product() {
    }

    public static Map.Entry<String, Integer> getOneRandomProduct() {
        int numRndEntry = random.nextInt(random(productMap.entrySet().size(),true));
        int count = 0;
        for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
            if (count == numRndEntry) {
               return entry;
            }
            count++;
        }
        //stub
       return null;
    }
}
