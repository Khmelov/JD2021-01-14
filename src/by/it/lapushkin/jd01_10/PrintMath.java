package by.it.lapushkin.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structureClass = Math.class;

        Method[] methods = structureClass.getMethods();

        Field[] fields = structureClass.getFields();

        printFields(fields);
        System.out.println();
        printMethods(methods);


    }
    private static void printMethods(Method[] methods){
        for (Method method : methods) {

            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                StringBuilder strMethod = new StringBuilder("public ");
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC)
                    strMethod.append("static ");
                if ((method.getModifiers() & Modifier.FINAL) == Modifier.FINAL)
                    strMethod.append("final ");
                strMethod.append(method.getReturnType().toString()).append(" ");
                strMethod.append(method.getName()).append("(");
                int parameterCount = method.getParameterCount();
                for (int i = 0; i < parameterCount; i++) {
                    strMethod.append(method.getParameterTypes()[i].toString());
                    if (i <= parameterCount - 2)
                        strMethod.append(",");
                }
                strMethod.append(")");
                System.out.println(strMethod);
            }
        }
    }

    private static void printFields(Field[] fields) {
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                StringBuilder strField = new StringBuilder("public ");
                if ((field.getModifiers() & Modifier.STATIC) == Modifier.STATIC)
                    strField.append("static ");
                if ((field.getModifiers() & Modifier.FINAL) == Modifier.FINAL)
                    strField.append("final ");
                strField.append(field.getType().toString()).append(" ").append(field.getName());
                System.out.println(strField);
            }
        }
    }

}
