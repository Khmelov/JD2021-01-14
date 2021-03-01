package by.it.vesniachok.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list=new ListA<>();
        List<String> arList = new ArrayList<>();
        list.add("Zero"); arList.add("Zero");
        list.add("One"); arList.add("One");
        list.add("Two");arList.add("Two");
        list.add("Last"); arList.add("Last");
        System.out.println("add list:" + list + "\narList:" + arList);
        list.add(2,"Tree"); arList.add(2,"Tree");
        list.add(0,"Start") ;arList.add(0,"Start");
        System.out.println("add () myList:" + list + "\narList:" + arList);
        System.out.println(list);
        list.remove( 1);
        System.out.println(list);
    }
}
