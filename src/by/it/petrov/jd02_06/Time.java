package by.it.petrov.jd02_06;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Time {
    public static String getTime() {
        DateFormat DFormat = DateFormat.getDateTimeInstance();
        return DFormat.format(new Date());
    }
}
