package by.it.voitenkov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {
        printMethod();
    }

    public static void printMethod() {
        Method[] declaredMethods = String.class.getDeclaredMethods();

        for (Method method : declaredMethods) {
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                System.out.println(method.getName());
            }
        }
    }
}