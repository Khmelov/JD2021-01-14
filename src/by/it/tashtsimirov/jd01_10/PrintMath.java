package by.it.tashtsimirov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {

        Class<Math> mathStruct = Math.class;

        Method[] methods = mathStruct.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                //System.out.println(method);
                String met = String.valueOf(method);
                System.out.println(met.replace("java.lang.Math.", ""));
            }
        }

        Field[] fields = mathStruct.getDeclaredFields();
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                //System.out.println(field);
                String met = String.valueOf(field);
                System.out.println(met.replace("java.lang.Math.", ""));
            }
        }

    }
}
