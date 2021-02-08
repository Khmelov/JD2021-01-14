package by.it.abeseda.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> userClass = Bean.class;



        //здесь вызываем все доступные методы
        Method[] declaredMethods = userClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            String returnType = method.getReturnType().getSimpleName();
            System.out.printf("%s %s (%s)\n",returnType,name, Arrays.toString(parameterTypes));

        }
        //попытка обратится к методу
        //здесь создаем экземпляр класса
        Constructor<Bean> constructor = Bean.class.getConstructor(Integer.class);// у нас конструтор без параметров
        Bean arr=constructor.newInstance();//значит мы не передаем никаких параметров
        Method obj=Bean.class.getDeclaredMethod("min", int.class, int.class);
        obj.setAccessible(true);
        System.out.println(obj.invoke(arr));
//метод статический надо инраче вызвать!

    }
}
