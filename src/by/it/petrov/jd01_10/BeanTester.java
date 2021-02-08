package by.it.petrov.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> structuredBean = Bean.class;
        //Param ann = structuredBean.getAnnotation(Param.class);
        Method[] methods = structuredBean.getMethods();
        Object o = null;
        double result = 0;
        for (int i = 0; i < methods.length; i++) {
            if(methods[i].isAnnotationPresent(Param.class)){
                o = structuredBean.newInstance();
                result = (double) methods[i].invoke(o, methods[i].getAnnotation(Param.class).a(), methods[i].getAnnotation(Param.class).b());
                System.out.println(methods[i].getName() + " equals: " + result);
            }
        }
    }
}
