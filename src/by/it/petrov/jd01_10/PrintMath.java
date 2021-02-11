package by.it.petrov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structuredMath = Math.class;
        Method[] methodNames = structuredMath.getDeclaredMethods();
        String[] methodNamesStr = new String [methodNames.length];
        for (int i = 0; i < methodNamesStr.length; i++) {
            methodNamesStr[i] = methodNames[i].toString().replace("java.lang.Math.", "");
            if((methodNames[i].getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC){
                System.out.println(methodNamesStr[i]);
            }
        }
        Field[] fieldNames  = structuredMath.getDeclaredFields();
        String[] fieldNamesStr = new String [fieldNames.length];
        for (int i = 0; i < fieldNamesStr.length; i++) {
            fieldNamesStr[i] = fieldNames[i].toString().replace("java.lang.Math.", "");
            if((fieldNames[i].getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                System.out.println(fieldNamesStr[i]);
            }
        }
    }
}
