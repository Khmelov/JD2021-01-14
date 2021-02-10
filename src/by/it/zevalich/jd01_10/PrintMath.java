package by.it.zevalich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method : methods) {
            if((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC){
                String name = method.getName();
                Class<?>[] types = method.getParameterTypes();
                String returnType = method.getReturnType().getSimpleName();
                System.out.printf("%s %s(%s)\n", returnType, name, Arrays.toString(types));;
            }
        }
    }
}
