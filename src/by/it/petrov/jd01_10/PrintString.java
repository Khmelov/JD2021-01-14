package by.it.petrov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structuredString = String.class;
        Method[] methodNames = structuredString.getDeclaredMethods();
        String[] methodNamesStr = new String[methodNames.length];
        for (int i = 0; i < methodNamesStr.length; i++) {
            if ((methodNames[i].getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                System.out.println(methodNames[i].getName());
            }
        }
    }
}