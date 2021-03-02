package by.it._classwork_.jd02_06;

import java.io.*;

class MyLogger {

    private File logFile;

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
