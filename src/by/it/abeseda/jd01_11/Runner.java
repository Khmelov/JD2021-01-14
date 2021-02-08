package by.it.abeseda.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List <String> listA= new ListA<>();
        List <Integer> listB= new ListB<>();

        //проверка метода boolean add
        listA.add("Кот");listA.add("Пёс");listA.add("Лошадь");

        //проверяем как выводит +метод size
        System.out.println(listA+" "+listA.size());

        //метод удаление элемента по индексу
        listA.remove(1);
        System.out.println(listA);

        //полкчаем элемент по индексу
        System.out.println(listA.get(0));

        //listB
        listB.add(10);listB.add(41);listB.add(546);listB.add(11);listB.add(55);listB.add(8668);
        listB.set(0, 999);listB.set(1, 11111111);
        //проверяем как выводит +метод size

        System.out.println(listB+" "+listB.size());
        listB.set(0, 8888888);
        System.out.println(listB);

        listB.contains(null);listB.contains(98);
        listB.indexOf(546);
        listB.add(546);

        System.out.println(listB);



    }
}
