package by.it.shebeko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structureString = String.class;
        Method[] methods = structureString.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder out = new StringBuilder();
            if (!Modifier.isStatic(method.getModifiers())){
                System.out.println(out.append(method.getName()));
            }

        }
    }
}
