package by.it.zevalich.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {


    public static void main(String[] args) {
        double number;
        double sum = 0;
        double sqr = 0;
        String str;
        List<Double> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (!(str=scanner.next()).equals("END")){
            try{
                number = Double.parseDouble(str);
                if(number<0){
                    throw new ArithmeticException();
                }
                list.add(number);
                sum += number;
                sqr = Math.sqrt(sum);

            }catch (NumberFormatException | ArithmeticException e){
                String name = e.getClass().getName();
                String nameC = TaskB.class.getName();

                StackTraceElement[] elements = e.getStackTrace();
                for (StackTraceElement element : elements) {
                    String className = element.getClassName();
                    if(className.equals(nameC)){
                        int line = element.getLineNumber();
                        System.out.printf("name: %s\n"+"class: %s\n"+ "line: %d\n",name,className,line);
                        break;
                    }
                }
            }
            System.out.println(sqr);


        }
    }
}
