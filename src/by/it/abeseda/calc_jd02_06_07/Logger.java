package by.it.abeseda.calc_jd02_06_07;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public enum  Logger {
    INSTANCE;

    private final File LOG_FILE;

    Logger() {
        LOG_FILE = Util.getFile(Logger.class, "log.txt");
    }

    //метод доступа к экземпляру
    public static Logger getLogger() {
        return INSTANCE;//возврат
    }

    void print(String message) {
        Date date=new Date();
            try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
                writer.println(message+" "+date);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
}
