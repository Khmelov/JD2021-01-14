package by.it.petrov.jd02_02;

import java.util.Map;

public class TestClass {
    public static void main(String[] args) {
        Map<String, Integer> goods = Map.of(
                "Meet", 300,
                "Milk", 200,
                "Sausages", 500,
                "Apples", 100,
                "Toilet paper", 50,
                "Potatoes", 100
        );
        System.out.println(goods.keySet().toArray()[0]);
    }
}