package by.it.nakhankov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {
        Class<String> structureClass = String.class;

        Method[] methods = structureClass.getDeclaredMethods();

        for (Method m : methods) {
            if ((m.getModifiers() & Modifier.STATIC) != Modifier.STATIC){
                System.out.println(m.getName());
            }
        }
    }
}
