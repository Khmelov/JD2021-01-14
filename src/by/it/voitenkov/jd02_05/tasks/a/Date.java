package by.it.voitenkov.jd02_05.tasks.a;

import java.text.DateFormat;
import java.util.Locale;

public class Date {
    public static String getDate(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        return dateFormat.format(new java.util.Date());
    }
}
