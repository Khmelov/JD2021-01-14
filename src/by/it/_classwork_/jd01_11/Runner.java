package by.it._classwork_.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list=new ListA<>();
        list.add("Zero");
        list.add("One");
        list.add("Two");
        list.add("Last");
        System.out.println(list);
        list.remove( 1);
        System.out.println(list);
    }
}
