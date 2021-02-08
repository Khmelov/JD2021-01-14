package by.it.shebeko.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Object o = beanClass.getDeclaredConstructor().newInstance();
        Method [] beenClassMethods = beanClass.getDeclaredMethods();

        for (Method method : beenClassMethods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                System.out.println("Название метода: " + method.getName() + "Результат: " + method.invoke(o , annotation.a(), annotation.b()));
            }
        }

    }

}
