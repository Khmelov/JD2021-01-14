package by.it.shebeko.jd01_10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.SQLOutput;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> classStructM = Math.class;
        Method[] methods = classStructM.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder out = new StringBuilder();
                out.append("public ");
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
        Field[] fields = classStructM.getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            {
                if (Modifier.isPublic(modifiers)) {
                    StringBuilder out = new StringBuilder();
                    out.append("public ");
                    if (Modifier.isStatic(modifiers))
                        out.append("static ");
                    Class<?> returnType = field.getType();
                    out.append(returnType.getSimpleName()).append(" ");
                    out.append(field.getName());
                    System.out.println(out);
                }
            }

        }
    }
}
