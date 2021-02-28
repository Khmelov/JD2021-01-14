package by.it.abeseda.jd02_05;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Mine {
    public static void main(String[] args) {

        Date date=new Date();
        System.out.println(date.toString());

 //8       System.out.println(Locale.getDefault());
        DateFormat df=DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.US);
        Date fullDate = null;
        String s="February 28, 2021";
        try {
            fullDate=df.parse(s);
            System.out.println(fullDate);
        } catch (ParseException e) {
            System.err.println("Ошібка: "+e.getErrorOffset());
        }
// Для получения даты в виде строки для заданного региона используется метод:
// String s = df.format(new Date());
// Метод Date parse(String source) преобразовывает переданную в виде
// строки дату в объектное представление конкретного регионального формата

        df=DateFormat.getDateInstance(DateFormat.FULL,new Locale("ru", "RU"));
//для данного метода обязательно неоьходім ініціалізіровать!null!
        System.out.println(df.format(fullDate));


        df=DateFormat.getDateInstance(DateFormat.SHORT,Locale.GERMAN);

        System.out.println(df.format(fullDate));


        df=DateFormat.getDateInstance(DateFormat.LONG,new Locale("de", "GE"));
// 28. Februar 2021
        System.out.println(df.format(fullDate));

        df=DateFormat.getDateInstance(DateFormat.FULL,Locale.GERMAN);

        System.out.println(df.format(fullDate));





//        System.out.println(Locale.getDefault().getCountry()); // код региона
//        System.out.println(Locale.getDefault().getDisplayCountry()); // регион
//        System.out.println(Locale.getDefault().getLanguage()); // код языка
//        System.out.println(Locale.getDefault().getDisplayLanguage());

        Calendar calendar=Calendar.getInstance();
        calendar.set(2021, Calendar.FEBRUARY, 28, 12, 42, 0);
        Date moment=calendar.getTime();
        System.out.println(moment);


        Clock clock=Clock.systemDefaultZone();
        System.out.println(clock.millis());
        System.out.println(clock.instant());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(clock.instant());


        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt);

        ZonedDateTime z1=ZonedDateTime.of(ldt, ZoneId.of("Australia/Sydney"));//Europe/Paris
        System.out.println(z1);
    }
}
