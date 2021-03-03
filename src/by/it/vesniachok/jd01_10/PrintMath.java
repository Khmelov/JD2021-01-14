package by.it.vesniachok.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {

        Class<Math> userClass = Math.class;
        Method[] allMethodsMath = userClass.getDeclaredMethods();
        for (Method method : allMethodsMath) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    String returnType = method.getReturnType().toString();
                    String methodName = method.getName();
                    StringBuilder parameterTypes = new StringBuilder();
                    for (Class<?> parameterClass : method.getParameterTypes()) {
                        if (parameterTypes.length() != 0) parameterTypes.append(",");
                        parameterTypes.append(parameterClass.getName());
                    }
                    System.out.printf("%s %s %s(%s)\n", "public static", returnType, methodName, parameterTypes);
                }
            }
        }
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if ((declaredField.getModifiers() & Modifier.PUBLIC)== Modifier.PUBLIC){
                if((declaredField.getModifiers() & Modifier.STATIC)== Modifier.STATIC){
                    if((declaredField.getModifiers() & Modifier.FINAL)== Modifier.FINAL) {
                        String declaredFieldName = declaredField.getName();
                        String type = declaredField.getType().getTypeName();
//                    System.out.println(declaredField);System.out.println(declaredFieldName);System.out.println(type);
                        System.out.printf("%s %s %s\n", "public static final", type, declaredFieldName);
                        //                   System.out.printf("%s %s %s %s %s\n",Modifier.PUBLIC,Modifier.STATIC,Modifier.FINAL, type, declaredFieldName);
                    }
                }
            }
        }

        }
    }






