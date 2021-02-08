package by.it.vesniachok.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structureClass = Math.class;
        Method[] methods = structureClass.getMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            StringBuilder out = new StringBuilder();
            if (Modifier.isPublic(modifiers)) {
                out.append("public ");
            }
            out.append(method.getName()).append('(');
            Class<?>[] parameterTypes = method.getParameterTypes();
            System.out.println(out);
        }

    }
}
