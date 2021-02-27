package by.it.abeseda.jd02_05;

import java.util.Locale;

public class ConsoleRunner {
    public static void main(String[] args) {
        // попробуем создать файл тіпа bat!чтобы все проісходіло автоматіческі!
        //выполненіе все по порядку как в командной строке
        //заходім в папку с данным файлом і запускаем его, все автоматізіровано

        Language instance = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);
//        Locale locale=new Locale("be", "BY");

        if (args.length==2){
            instance.setLocale(new Locale(args[0], args[1]));
        }


 //       System.out.println(Locale.getDefault());
        System.out.println(instance.get(Messages.WELCOM));
        System.out.println(instance.get(Messages.QUESTION));
        System.out.println(instance.get(User.FIRST_NAME));
        System.out.println(instance.get(User.LAST_NAME));

    }
}
