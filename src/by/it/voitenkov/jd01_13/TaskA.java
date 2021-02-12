package by.it.voitenkov.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (Exception e) {
            StackTraceElement[] elements = e.getStackTrace();
            for (StackTraceElement element : elements) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    System.out.printf("name:  %s\nclass: %s\nline:  %d\n",
                            e.getClass().getName(),
                            element.getClassName(),
                            element.getLineNumber());
                    break;
                }
            }
        }
    }
}