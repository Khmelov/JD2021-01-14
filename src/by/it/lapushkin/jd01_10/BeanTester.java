package by.it.lapushkin.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class<?> beanClass = Bean.class;

        Method[] methods = beanClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {

                double result;
                Param param = method.getAnnotation(Param.class);
                Object o = beanClass.getDeclaredConstructor().newInstance();
                result = (double) method.invoke(o,param.a(),param.b());

                System.out.print("Method " + method.getName() + " is correct. Return : " + result);
                System.out.println();
            }
        }
    }
}
