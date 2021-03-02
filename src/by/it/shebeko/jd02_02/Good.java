package by.it.shebeko.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Good {
    static Map<String, Integer> goods(){
        Map<String , Integer> good = new HashMap<>();
        good.put("bread", 5);
        good.put("potato", 4);
        good.put("eggs", 2);
        good.put("meat", 10);
        return good;
    }
}
