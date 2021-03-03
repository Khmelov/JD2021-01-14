package by.it.shebeko.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ведите ru/be/en");

        Lang manager = Lang.INSTANCE;
        Locale locale;
        String language = sc.nextLine();
            if(Lang.lang.containsKey(language)){
                locale = new Locale(language, Lang.lang.get(language));
            }
            else{locale=Locale.getDefault();}

        manager.setLocale(locale);
        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, locale);
        System.out.printf(manager.get(Message.DATA),df.format(d).toString());
        System.out.println(manager.get(Language.CHOICE));
        System.out.println(manager.get(Message.HELLO));
        System.out.println(manager.get(Message.QUESTION));
        System.out.println(manager.get(User.FIRST_NAME));
        System.out.println(manager.get(User.LAST_NAME));
    }

}


