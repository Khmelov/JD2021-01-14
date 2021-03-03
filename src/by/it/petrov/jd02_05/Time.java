package by.it.petrov.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Time {
    public static String getTime(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        return dateFormat.format(new Date());
    }
}
