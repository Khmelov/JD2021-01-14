package by.it.zevalich.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>();
        String str;
        while (!(str = scanner.next()).equals("END")){
            try{
                double num = Double.valueOf(str);
                numbers.add(num);
                double sumOfElements = 0;
                for (Double number : numbers) {
                    sumOfElements+=number;
                    System.out.println(num + " " + Math.sqrt(sumOfElements));
                }
            }
            catch (ArithmeticException e){
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if(TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int arrLine = element.getLineNumber();
                        System.out.printf(" name: %s\n" +
                                        " class: %s\n" +
                                        " line: %d\n",
                                name, className, arrLine);
                        break;
                    }
                }

            }
            catch (Exception e){
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if(TaskB.class.getName().equals(element.getClassName())){
                        String name = e.getClass().getName();
                        String clName = element.getClassName();
                        int number = element.getLineNumber();
                        System.out.printf(" name: %s\n" +
                                        " class: %s\n" +
                                        " line: %d\n" ,
                                name,clName,number);
                        break;
                }
                }
            }
        }
    }
}
