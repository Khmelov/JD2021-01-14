package by.it;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@SuppressWarnings("all")
public class HomeWork {

    protected HomeWork() {
    }

/*
    ===========================================================================================================
    НИЖЕ ВСПОМОГАТЕЛЬНЫЙ КОД ТЕСТОВ. НЕ МЕНЯЙТЕ В ЭТОМ ФАЙЛЕ НИЧЕГО.
    Но изучить как он работает - можно, это всегда будет полезно.
    ===========================================================================================================
     */
    //-------------------------------  методы ----------------------------------------------------------

    public Class<?> findClass(String className) {
        //обычно имя класса короткое, восстановим до полного
        if (!className.contains(".")) {
            className = getPackage() + "." + className;
        }
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            fail("\nERROR:Тест не пройден. Класс " + className + " не найден.");
        }
        return null;
    }

    public Method checkMethod(String className, String methodName, Class<?>... parameters) {
        Class<?> currentClass = findClass(className);
        try {
            methodName = methodName.trim();
            Method m;
            assert currentClass != null;
            if (methodName.startsWith("static")) {
                methodName = methodName.replace("static", "").trim();
                m = currentClass.getDeclaredMethod(methodName, parameters);
                if (!Modifier.isStatic(m.getModifiers())) {
                    fail("\nERROR:Метод " + m.getName() + " должен быть статическим");
                }
            } else {
                m = currentClass.getDeclaredMethod(methodName, parameters);
            }
            m.setAccessible(true);
            return m;

        } catch (NoSuchMethodException e) {
            System.err.println("\nERROR:Не найден метод " + methodName + " либо у него неверная сигнатура");
            System.err.println("ERROR:Ожидаемый класс: " + className);
            System.err.println("ERROR:Ожидаемый метод: " + methodName);
            throw new RuntimeException(e);
        }
    }

    public Method findMethod(Class<?> cl, String name, Class<?>... param) {
        try {
            return cl.getDeclaredMethod(name, param);
        } catch (NoSuchMethodException e) {
            fail("\nERROR:Тест не пройден. Метод " + cl.getName() + "." + name + " не найден\n");
        }
        return null;
    }

    public Object invoke(Method method, Object o, Object... value) {
        try {
            method.setAccessible(true);
            return method.invoke(o, value);
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("\nERROR:Не удалось вызвать метод " + method.getName() + "\n");
        }
        return null;
    }

    //метод находит и создает класс для тестирования
    //по имени вызывающего его метода, testTaskA1 будет работать с TaskA1

    public HomeWork run(String in) {
        return run(in, true);
    }

    public String getPackage() {
        StackTraceElement element = Stream.of(new Throwable().getStackTrace())
                .filter(e -> e.getMethodName().startsWith("test"))
                .findFirst()
                .orElse(null);
        assert element != null;
        List<String> p = new ArrayList<>(Arrays.asList(element.getClassName().split("\\.")));
        p.remove(p.size() - 1);
        Optional<String> packagePath = p.stream().reduce((s1, s2) -> s1 + "." + s2);
        return packagePath.get();
    }

    public HomeWork run(String in, boolean runMain) {
        StackTraceElement element = Stream.of(new Throwable().getStackTrace())
                .filter(e -> e.getMethodName().startsWith("test"))
                .findFirst()
                .orElse(null);
        assert element != null;
        String[] path = element.getClassName().split("\\.");
        String nameTestMethod = element.getMethodName();
        String clName = nameTestMethod.replace("test", "");
        clName = clName.replaceFirst(".+__", "");
        clName = element.getClassName().replace(path[path.length - 1], clName);
        System.out.println("\n---------------------------------------------");
        System.out.println("Старт теста для " + clName);
        if (!in.isEmpty()) System.out.println("input:" + in);
        System.out.println("---------------------------------------------");
        return new HomeWork(clName, in, runMain);
    }
    //-------------------------------  тест ----------------------------------------------------------

    //переменные теста
    public Class<?> aClass; //тестируемый класс
    public final PrintStream oldOut = System.out; //исходный поток вывода
    public final PrintStream newOut; //поле для перехвата потока вывода
    public final StringWriter strOut = new StringWriter(); //накопитель строки вывода

    //Основной конструктор тестов
    protected HomeWork(String className, String in, boolean runMain) {
        aClass = null;
        try {
            aClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            fail("ERROR:Не найден класс " + className + "\n");
        }
        InputStream reader = new ByteArrayInputStream(in.getBytes());
        System.setIn(reader);   //перехват стандартного ввода
        System.setOut(newOut);  //перехват стандартного вывода

        if (runMain) //если нужно запускать, то запустим, иначе оставим только вывод
            try {
                Class<?>[] argTypes = new Class[]{String[].class};
                Method main = aClass.getDeclaredMethod("main", argTypes);
                main.setAccessible(true);
                main.invoke(null, (Object) new String[]{});
            } catch (NoSuchMethodException e) {
                fail("ERROR:В классе " + aClass.getSimpleName() + " нет метода \"public static void main\"");
            } catch (IllegalAccessException | InvocationTargetException e) {
                //тут просто вывод ошибки оставим, иначе 13-е не работает как надо
                e.printStackTrace();
            } finally {
                System.setOut(oldOut); //возврат вывода, нужен, только если был запуск
            }
    }


    //проверка вывода
    public HomeWork is(String str) {
        assertEquals("ERROR:Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                strOut.toString(),
                str);
        return this;
    }

    public HomeWork include(String str) {
        assertTrue("ERROR:Строка не найдена: " + str + "\n",
                strOut.toString().contains(str));
        return this;
    }

    public HomeWork exclude(String str) {
        assertFalse("ERROR:Лишние данные в выводе: " + str + "\n",
                strOut.toString().contains(str));
        return this;
    }

    public HomeWork matches(String regexp) {
        assertTrue("ERROR:вывод не соответствует паттерну: " + regexp + "\n",
                strOut.toString().matches(regexp));
        return this;
    }

    public HomeWork find(String regexp) {
        Matcher matcher = Pattern.compile(regexp).matcher(strOut.toString());
        assertTrue("ERROR:вывод не содержит паттерн: " + regexp + "\n",
                matcher.find());
        return this;
    }

    public HomeWork checkCount(String regexp, int lessOrEquals) {
        Matcher matcher = Pattern.compile(regexp).matcher(strOut.toString());
        int count = 0;
        while (matcher.find()) count++;
        assertTrue(
                String.format("ERROR: Число повторов N паттерна %s в выводе ожидается равным или меньшим, чем %d раз. Сейчас N=%d\n",
                        regexp, lessOrEquals, count),
                count <= lessOrEquals
        );
        return this;
    }

    public HomeWork checkCount(int moreThanOrEquals, String regexp) {
        Matcher matcher = Pattern.compile(regexp).matcher(strOut.toString());
        int count = 0;
        while (matcher.find()) count++;
        assertTrue(
                String.format("ERROR: Число повторов N паттерна %s в выводе ожидается равным или большим, чем %d. Сейчас N=%d\n",
                        regexp, moreThanOrEquals, count),
                moreThanOrEquals <= count
        );
        return this;
    }

    public HomeWork checkCount(int moreThanOrEquals, String regexp, int andLessOrEquals) {
        Matcher matcher = Pattern.compile(regexp).matcher(strOut.toString());
        int count = 0;
        while (matcher.find()) count++;
        assertTrue(
                String.format("ERROR: Число повторов N паттерна %s в выводе ожидается от %d до %d (включительно). Сейчас N=%d\n",
                        regexp, moreThanOrEquals, andLessOrEquals, count),
                moreThanOrEquals <= count && count <= andLessOrEquals
        );
        return this;
    }


    //логический блок перехвата вывода
    {
        newOut = new PrintStream(new OutputStream() {
            private byte[] bytes = new byte[1];
            private int pos = 0;

            @Override
            public void write(int b) {
                if (pos == 0 && b == '\r') //пропуск \r (чтобы win mac и linux одинаково работали
                    return;
                if (pos == 0) { //определим кодировку https://ru.wikipedia.org/wiki/UTF-8
                    if ((b & 0b11110000) == 0b11110000) bytes = new byte[4];
                    else if ((b & 0b11100000) == 0b11100000) bytes = new byte[3];
                    else if ((b & 0b11000000) == 0b11000000) bytes = new byte[2];
                    else bytes = new byte[1];
                }
                bytes[pos++] = (byte) b;
                if (pos == bytes.length) { //символ готов
                    String s = new String(bytes); //соберем весь символ
                    strOut.append(s); //запомним вывод для теста
                    if (showSystemOut) oldOut.append(s); //копию в обычный вывод
                    pos = 0; //готовим новый символ
                }

            }
        });
    }

    public static boolean showSystemOut = true; // = hideSystemOut();
//
//    private static boolean hideSystemOut() {
//        try {
//            Properties properties = new Properties();
//            properties.load(new FileInputStream("application.properties"));
//            String value = properties.getProperty("homework.hideSystemOut").trim();
//            return value.equalsIgnoreCase("true") ||
//                    value.equalsIgnoreCase("1");
//        } catch (IOException e) {
//            return false;
//        }
//    }
}