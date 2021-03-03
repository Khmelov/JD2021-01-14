package by.it.nakhankov.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class MyLogger {

    private final File logFile;

    private static volatile MyLogger instance;

    private MyLogger() {
        logFile = Util.getFile(MyLogger.class, "log.txt");
    }

    public static MyLogger getLogger() {
        MyLogger local = instance;
        if (local == null) {
            synchronized (MyLogger.class) {
                local =instance;
                if (local == null) {
                    local = new MyLogger();
                    instance = local;
                }
            }
        }
        return local;
    }


    synchronized void log(String logText) {
        try (
                PrintWriter logWriter = new PrintWriter(
                        new FileWriter(logFile, true)
                )
        ) {
            logWriter.println(logText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
