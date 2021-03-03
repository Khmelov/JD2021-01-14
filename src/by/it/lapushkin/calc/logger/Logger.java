package by.it.lapushkin.calc.logger;

import java.text.DateFormat;
import java.util.Date;

public class Logger {

    private static class LazyLogger {
        public static final Logger INSTANCE = new Logger();
    }

    private static final DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    private static final StringBuilder sb = new StringBuilder();
    private static final Date date = new Date();

    public static Logger getInstance() {
        return LazyLogger.INSTANCE;
    }

    public void writeHeadline(String head) {
        sb.append("\t").append(head).append("\n");
    }

    public void logExeption(String message) {
        sb.append(message).append("\n\n");
    }

    public void writeDate(DateFormat df) {
        sb.append("\t").append(df.format(date)).append("\n\n");
    }

    public void write(String string){
        sb.append("\t")
                .append(string)
                .append("\n\n");
    }

    public void print() {
        System.out.println(sb);
    }



}
