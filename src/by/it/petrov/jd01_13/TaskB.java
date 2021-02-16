package by.it.petrov.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double count = 0;
        double number = 0;
        double result = 0;
        while (sc.hasNext()){
            boolean parsingOk = false;
            boolean sqrtOk = false;
            String element = sc.next();
            if(element.equals("END")){
                break;
            } else {
                try{
                    number = Double.parseDouble(element);
                    parsingOk = true;
                }
                catch (Exception e){
                    StackTraceElement[] stacktrace = e.getStackTrace();
                    for (int i = 0; i < stacktrace.length; i++) {
                        if(stacktrace[i].getClassName().equals(TaskB.class.getName())){
                            System.out.println(stacktrace[i]);
                            String name = e.getClass().getName();
                            String clname = stacktrace[i].getClassName();
                            int numberE = stacktrace[i].getLineNumber();
                            System.out.printf("%7s%-20s%n", "name:", name);
                            System.out.printf("%7s%-20s%n", "class:", clname);
                            System.out.printf("%7s%-20s%n", "line:", numberE);
                            break;
                        }
                    }
                }

                if (parsingOk){
                    count += number;
                    if (count < 0){
                        try{
                            throw new ArithmeticException();
                        }
                        catch (ArithmeticException e){
                            StackTraceElement[] stacktrace = e.getStackTrace();
                            for (int i = 0; i < stacktrace.length; i++) {
                                if(stacktrace[i].getClassName().equals(TaskB.class.getName())){
                                    System.out.println(stacktrace[i]);
                                    String name = e.getClass().getName();
                                    String clname = stacktrace[i].getClassName();
                                    int numberE = stacktrace[i].getLineNumber();
                                    System.out.printf("%7s%-20s%n", "name:", name);
                                    System.out.printf("%7s%-20s%n", "class:", clname);
                                    System.out.printf("%7s%-20s%n", "line:", numberE);
                                    break;
                                }
                            }
                        }
                    } else {
                        result = Math.sqrt(count);
                        sqrtOk = true;
                    }
                }

                if(sqrtOk){
                    System.out.println(result);
                }
            }
        }
    }
}
