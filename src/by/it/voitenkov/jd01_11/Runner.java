package by.it.voitenkov.jd01_11;


import java.util.List;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {
        Set<Integer> list = new SetC<>();
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(null);
        list.add(null);
        list.add(1000);
        list.add(1000);
        list.add(1001);
        list.add(1002);

        System.out.println(list);

    }

}
