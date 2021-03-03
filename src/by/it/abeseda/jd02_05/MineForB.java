package by.it.abeseda.jd02_05;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class MineForB {

    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
        String s=date.toString();
        System.out.println(s);

//        DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
//        Date fullDate = null;
//        String s="February 28, 2021";
//        try {
//            fullDate=df.parse(date.toString());
//            System.out.println(fullDate);
//        } catch (ParseException e) {
//            System.err.println("Ошібка: "+e.getErrorOffset());
//        }

//        DateFormat df;
//        df=DateFormat.getDateInstance(DateFormat.MEDIUM,new Locale("ru", "RU"));
//        System.out.println(df.format(new Date()));
//        df=DateFormat.getDateInstance(DateFormat.MEDIUM,new Locale("be", "BY"));
//        System.out.println(df.format(new Date()));
//        df=DateFormat.getDateInstance(DateFormat.MEDIUM,new Locale("en", "EN"));
//        System.out.println(df.format(new Date()));
    }
}
