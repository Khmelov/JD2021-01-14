package by.it.petrov.jd01_13;

import java.util.Arrays;
import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (Exception e){
            StackTraceElement[] stacktrace = e.getStackTrace();
            for (int i = 0; i < stacktrace.length; i++) {
                if(stacktrace[i].getClassName().equals(TaskA.class.getName())){
                    System.out.println(stacktrace[i]);
                    String name = e.getClass().getName();
                    String clname = stacktrace[i].getClassName();
                    int number = stacktrace[i].getLineNumber();
                    System.out.printf("%7s%-20s%n", "name:", name);
                    System.out.printf("%7s%-20s%n", "class:", clname);
                    System.out.printf("%7s%-20s%n", "line:", number);
                    break;
                }
            }
        }
    }
}
