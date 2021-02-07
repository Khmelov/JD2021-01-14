package by.it.abeseda.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> userClass=String.class;
        Method[] declaredMethods = userClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                String methodName = method.getName();
           System.out.println(methodName);
            }
        }
    }
}
