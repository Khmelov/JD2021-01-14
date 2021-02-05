package by.it.abeseda.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> userClass = Bean.class;

        //здесь создаем экземпляр класса
        Constructor<Bean> constructor = userClass.getConstructor(Bean.class);
        Object onno=constructor.newInstance(2.0,3.0);
        System.out.println(onno);


        //здесь вызываем все доступные методы
        Method[] declaredMethods = userClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            String returnType = method.getReturnType().getSimpleName();

            System.out.printf("%s %s (%s)\n",returnType,name, Arrays.toString(parameterTypes));        }

//        Method method= userClass.getMethod("min");
  //      System.out.println(method.invoke);
    }
}
