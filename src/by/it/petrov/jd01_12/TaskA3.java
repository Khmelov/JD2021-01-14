package by.it.petrov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayOfNumbers = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        String input;
        int position = 0;
        while(!(input = sc.next()).equals("end")){
            if(Integer.parseInt(input) < 0){
                arrayOfNumbers.add(Integer.parseInt(input));
            }
            if(Integer.parseInt(input) == 0){
                arrayOfNumbers.add(position, Integer.parseInt(input));
            }
            if(Integer.parseInt(input) > 0){
                arrayOfNumbers.add(position++, Integer.parseInt(input));

            }
        }
        System.out.println(arrayOfNumbers);
    }
}
