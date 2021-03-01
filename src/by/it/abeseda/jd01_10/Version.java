Version.javapackage by.it.abeseda.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Version {
    public static void main(String[] args) {
        Class<Math> userClass = Math.class;
        Method[] allMethodsMath = userClass.getDeclaredMethods();
        for (Method method : allMethodsMath) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    System.out.println(method.getReturnType());
                    String returnType = method.getReturnType().toString();
                    System.out.println(returnType);
                }
            }
        }
    }
}
