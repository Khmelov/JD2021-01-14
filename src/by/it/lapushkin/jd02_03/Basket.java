package by.it.lapushkin.jd02_03;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final Map<String, Integer> basket = new HashMap<>();

    public void inputBasket(String nameProduct,int price) {
        basket.put(nameProduct,price);
    }
    public Map<String,Integer> getBasket(){
        return basket;
    }
}
