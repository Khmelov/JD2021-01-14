package by.it.shebeko.jd01_12;


import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List <String> list = new ArrayList<>();
        for (;;){
            String input = sc.next();
            String word = input.replaceAll("[^a-zA-Z']","" );
            if (word.equals("end")){
                break;
            }
            list.add(word);
        }
        Set  <String> set = new HashSet<>(list);
        for (String s : set) {
            System.out.println(s + "=" + Collections.frequency(list, s));
        }
    }
}
