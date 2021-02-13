package by.it.abeseda.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random()>0.5) {
                new HashMap<String, String>(null);
            }else{
                Integer.parseInt("привет");}
        } catch (Exception e) {
            String nameClassException = e.getClass().getName();

            StackTraceElement[] stackTrace = e.getStackTrace();

            for (StackTraceElement element : stackTrace) {
                System.out.println(element.getClassName());
                if (TaskA.class.getName().equals(element.getClassName())){

                    String nameClassExceptionIn = element.getClassName();
                    int lineNumberExceptionIn = element.getLineNumber();


                    System.out.println("class: "+nameClassException);
                    System.out.println("name: "+nameClassExceptionIn);
                    System.out.println("line: "+lineNumberExceptionIn);


                }
            }
        }

    }
}
