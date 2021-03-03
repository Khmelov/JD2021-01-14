package by.it.zevalich.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan manager = ResMan.INSTANCE;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }
        System.out.printf(
                manager.get(Messages.FORMAT_CONSOLE),
                manager.get(Messages.WELCOME),
                manager.get(Messages.QUESTION),
                manager.get(User.FIRST_NAME),
                manager.get(User.LAST_NAME)
        );
    }
}
