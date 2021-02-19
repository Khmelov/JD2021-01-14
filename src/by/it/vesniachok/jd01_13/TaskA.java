package by.it.vesniachok.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NumberFormatException | NullPointerException e) {
            String name = e.getClass().getName();
            String myMain = TaskA.class.getName();

            StackTraceElement[] elements = e.getStackTrace();
            for (StackTraceElement element : elements) {
                String classNameElement = element.getClassName();
                if (classNameElement.equals(myMain)) {
                    int lineNumber = element.getLineNumber();
                    System.out.printf(" name: %s\n" +
                                    "class: %s\n" +
                                    " line: %d\n"
                            , name, classNameElement, lineNumber);
                    break;
                }
            }
        }
    }
}
