package by.it.vesniachok.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structureClass = Math.class;
        Method[] methods = structureClass.getMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            StringBuilder out = new StringBuilder();
            if (Modifier.isStatic(modifiers))
                out.append("static ");
            Class<?> returnType = method.getReturnType();
            out.append(returnType.getSimpleName()).append(" ");
            out.append(method.getName()).append("(");
            Class<?>[] types = method.getParameterTypes();
            String delimiter = "";
            for (Class<?> type : types) {
                out.append(delimiter).append(type.getTypeName());
                delimiter = ",";
            }
            out.append(")");
            System.out.println(out);

        }
    }
}
