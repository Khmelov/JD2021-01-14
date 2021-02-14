package by.it.abeseda.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<?> userClass = Class.forName(Bean.class.getName());
        Bean beanAPI= (Bean) userClass.getDeclaredConstructor().newInstance();

        Method[] declaredMethods = beanAPI.getClass().getDeclaredMethods();

        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Param.class)) {
                method.setAccessible(true);
                int a = method.getAnnotation(Param.class).a();
                int b = method.getAnnotation(Param.class).b();
                System.out.println(method.getName()+" "+method.invoke(beanAPI, a,b));
            }
        }
//            String name = method.getName();
//            Class<?>[] parameterTypes = method.getParameterTypes();
//            String returnType = method.getReturnType().getSimpleName();
//            System.out.printf("%s %s (%s)\n",returnType,name, Arrays.toString(parameterTypes));
//

        //попытка обратится к методу
        //здесь создаем экземпляр класса
//        Constructor<Bean> constructor = Bean.class.getConstructor(Integer.class);// у нас конструтор без параметров
//        Bean beanAPI=constructor.newInstance();//значит мы не передаем никаких параметров
//        Method obj=Bean.class.getDeclaredMethod("min", int.class, int.class);
//        obj.setAccessible(true);
//        System.out.println(obj.invoke(beanAPI));
//метод статический надо инраче вызвать!

    }
}
