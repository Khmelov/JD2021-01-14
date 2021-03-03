package by.it.voitenkov.jd02_06.tasks.a;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

class Logger {

    private File logFile;

    private static volatile Logger instance;

    private Logger() {
        logFile = Utility.getFile(Logger.class, "logFile.txt");
    }

    public static Logger getLogger() {
        Logger local = instance;
        if (local == null) {
            synchronized (Logger.class) {
                local = instance;
                if (local == null) {
                    local = new Logger();
                    instance = local;
                }
            }
        }
        return local;
    }

    synchronized void log(String logText) {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true))) {
            Date data = new Date();
            logWriter.println(logText + " " + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
