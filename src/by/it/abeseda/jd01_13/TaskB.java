package by.it.abeseda.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        List<Double> doubles=new ArrayList<>();
        String number;

        while (!(number=scanner.next()).equals("END")){

                 try{
                     Double formatNumber=Double.parseDouble(number);
                    doubles.add(formatNumber);
                 }

                 catch (NumberFormatException e) {
                     String nameClassException = e.getClass().getName();

                     StackTraceElement[] stackTrace = e.getStackTrace();

                     for (StackTraceElement el : stackTrace) {
                         if (TaskB.class.getName().equals(el.getClassName())){

                             String nameClassExceptionIn = el.getClassName();
                             int lineNumberExceptionIn = el.getLineNumber();


                             System.out.println("class: "+nameClassException);
                             System.out.println("name: "+nameClassExceptionIn);
                             System.out.println("line: "+lineNumberExceptionIn);
                         }
                     }
                 }

             }
        System.out.println(doubles);

        double sum=0;
        for (Double element : doubles) {
            sum = sum + element;
            try {
                if (sum<0){
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException e) {

                String nameClassException = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement el : stackTrace) {
                    if (TaskB.class.getName().equals(el.getClassName())) {
                        String nameClassExceptionIn = el.getClassName();
                        int lineNumberExceptionIn = el.getLineNumber();

                        System.out.println("class: " + nameClassException);
                        System.out.println("name: " + nameClassExceptionIn);
                        System.out.println("line: " + lineNumberExceptionIn);

                    }
                }
            }

            finally {
                if (sum>=0){
            double sumSqrt= Math.sqrt(sum);
            System.out.println(sumSqrt);}}
            }
        }
    }
