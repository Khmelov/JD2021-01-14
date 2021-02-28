package by.it.abeseda.jd01_11;

import java.util.*;

public class Ex {
    public static void main(String[] args) {
            int[] arraySource = {1, 2, 3, 4, 5, 6};
            int[] arrayDestination = {0, 0, 0, 0, 0, 0, 0, 0};

            System.out.println("arraySource: " + Arrays.toString(arraySource));
            System.out.println("arrayDestination: "
                    + Arrays.toString(arrayDestination));

            System.arraycopy(arraySource, 1, arrayDestination, 2, 3);

            //берем с первой позиции первого масссива, т.е. значения [2,3,4,5,6]
        //зачинаем копировать во 2ую позицию второго массива,так вот [0,0,2.....]
        //и копируем только длину 3,т.е только 3 элемента

            System.out.println("arrayDestination after arrayCopy: "
                    + Arrays.toString(arrayDestination));



        Object c=new Object();
        System.out.println(c.hashCode());


        ArrayList<Integer> ruff=new ArrayList<>();
        ruff.add(1223);ruff.add(4335353);ruff.add(7777);ruff.add(111);
        ruff.sort(Integer::compareTo);

        System.out.println("Massive sorted:"+ruff+"\n"+"Massive size:"+ruff.size());

        //эксперименты с map

        Person ivan=new Person(1, "Ivan", "Ivanov");
        Person petr=new Person(2, "Petr", "Petrov");

        Map<Integer,Person> map= new HashMap<>();
        map.put(ivan.getId(), ivan);
        map.put(petr.getId(), petr);

        System.out.println(map.get(2));
        System.out.println(ivan.hashCode());
        Map<String,Integer> map1=new HashMap<>();
        map1.put("морковь", 123);
        map1.put("редис", 111);
        map1.put("cinnamon", 0);

        for (Integer k: map1.values()){
            System.out.println(k);
        }
        for (String j: map1.keySet()){
            System.out.println(j);
        }
        System.out.println(map1.size());


    }
    }

