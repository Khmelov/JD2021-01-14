package by.it.zevalich.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//ne prohodit
public class TaskB {
    class ArEx extends Exception{
        public ArEx() {
        }

        public ArEx(String message) {
            super(message);
        }

        public ArEx(String message, Throwable cause) {
            super(message, cause);
        }

        public ArEx(Throwable cause) {
            super(cause);
        }

        public ArEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>();
        String str;
        while (!(str = scanner.next()).equals("END")){
            try{
                double num = Double.parseDouble(str);
                numbers.add(num);
                double sumOfElements = 0;
                for (Double number : numbers) {
                    sumOfElements+=number;
                }
                System.out.println(num + " " + Math.sqrt(sumOfElements));
            } catch (ArithmeticException e){
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int arrLine = element.getLineNumber();
                        System.out.printf("""
                                         name: %s
                                         class: %s
                                         line: %d
                                        """,
                                name, className, arrLine);
                        break;

                }

            } catch (Exception e){
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if(TaskB.class.getName().equals(element.getClassName())){
                        String name = e.getClass().getName();
                        String clName = element.getClassName();
                        int number = element.getLineNumber();
                        System.out.printf("""
                                         name: %s
                                         class: %s
                                         line: %d
                                        """,
                                name,clName,number);
                        break;
                    }
                }
            }


        }
    }
}
