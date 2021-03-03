package by.it.zevalich.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private final File logFile;

    private static volatile Logger instance;

    private Logger() {
        logFile = Util.getFile(Logger.class, "log.txt");
    }

    public static Logger getLogger() {
        Logger local = instance;
        if (local == null) {
            synchronized (Logger.class) {
                local =instance;
                if (local == null) {
                    local = new Logger();
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
