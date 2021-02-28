package by.it.abeseda.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        // попробуем создать файл тіпа bat!чтобы все проісходіло автоматіческі!
        //выполненіе все по порядку как в командной строке
        //заходім в папку с данным файлом і запускаем его, все автоматізіровано

        Language language = Language.INSTANCE;

        if (args.length==2){
            Locale locale = new Locale(args[0], args[1]);
           language.setLocale(locale);

            while (true) {
                switch (scanner.next()) {
                    case "ru":
                        language.setLocale(new Locale("ru", "RU"));
                        break;
                    case "en":
                        language.setLocale(new Locale("en", "US"));
                        break;
                    case "be":
                        language.setLocale(new Locale("be", "BY"));
                        break;
                    default:
                        language.setLocale(new Locale("en", "US"));
                        break;
                }

                System.out.println(language.get(Messages.WELCOM));
                System.out.println(language.get(Messages.QUESTION));
                System.out.println(language.get(User.FIRST_NAME));
                System.out.println(language.get(User.LAST_NAME));


                Date date = new Date();
                DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM,language.getLocale());
                String sDate = df.format(date);
                System.out.println(sDate);

            }
        }
//        DateFormat df;
//        df=DateFormat.getDateInstance(DateFormat.MEDIUM,new Locale("ru", "RU"));
//        System.out.println(df.format(new Date()));
//        df=DateFormat.getDateInstance(DateFormat.MEDIUM,new Locale("be", "BY"));
//        System.out.println(df.format(new Date()));
//        df=DateFormat.getDateInstance(DateFormat.MEDIUM,new Locale("en", "EN"));
//        System.out.println(df.format(new Date()));

    }
}
