package by.it.voitenkov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class PrintMath {

    public static void main(String[] args) {
        printField();
        printMethods();
    }

    public static void printMethods() {
        Method[] declaredMethods = Math.class.getDeclaredMethods();

        for (Method method : declaredMethods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                StringBuilder str = new StringBuilder(method.toString());
                str.replace(str.lastIndexOf(" "), str.lastIndexOf(".") + 1, " ");
                System.out.println(str);
            }
        }
    }

    public static void printField() {
        Field[] declaredFields = Math.class.getDeclaredFields();

        for (Field field : declaredFields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                StringBuilder str = new StringBuilder(field.toString());
                str.replace(str.lastIndexOf(" "), str.lastIndexOf(".") + 1, " ");
                System.out.println(str);

            }


        }
    }
}