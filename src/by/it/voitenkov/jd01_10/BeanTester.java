package by.it.voitenkov.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {

        Class<?> clazz = Class.forName(Bean.class.getName());
        Bean bean = Bean.class.newInstance();
        Method[] declaredMethods = bean.getClass().getDeclaredMethods();
        for(Method method : declaredMethods) {
            if (method.isAnnotationPresent(Param.class)) {
                method.setAccessible(true);
                int a = method.getAnnotation(Param.class).a();
                int b = method.getAnnotation(Param.class).b();
                System.out.println(method.getName() + " " + method.invoke(bean, a, b));
            }
        }
    }
}