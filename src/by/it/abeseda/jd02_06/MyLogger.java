package by.it.abeseda.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


//все как в примере
public class MyLogger {
    //SingleTon класс

    private final File LOG_FILE;

    private static volatile MyLogger instance;
    //переменная хранится напрямую в кеше

    private MyLogger() {
        LOG_FILE = Util.getFile(MyLogger.class, "log.txt");
        //в конструкторе храним постоянный путь
    }

    //метод доступа к экземпляру
    public static MyLogger getLogger() {
        MyLogger localInstance = instance;//попытка получить объект
        if (localInstance == null) {//первая проверка для скорости
            synchronized (MyLogger.class) {
                localInstance =instance;
                if (localInstance == null) {//вторая проверка для надежности
                    localInstance = new MyLogger();
                    instance = localInstance;//создание
                }
            }
        }
        return localInstance;//возврат
    }


    synchronized void myLog(String logText) {
        try (
                PrintWriter logWriter = new PrintWriter(
                        new FileWriter(LOG_FILE, true)//перезаписывает или нет
                )
        ) {
            Date date=new Date();
            logWriter.println(logText+" "+date);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
