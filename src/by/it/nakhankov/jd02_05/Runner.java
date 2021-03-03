package by.it.nakhankov.jd02_05;

import by.it.nakhankov.jd02_05.Messages;
import by.it.nakhankov.jd02_05.ResMan;
import by.it.nakhankov.jd02_05.User;

import java.util.Locale;

public class Runner {


    public static void main(String[] args) {
        by.it.nakhankov.jd02_05.ResMan manager = ResMan.INSTANCE;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }
        System.out.printf(
                manager.get(Messages.FORMAT_CONSOLE),
                manager.get(Messages.WELCOME),
                manager.get(Messages.QUESTION),
                manager.get(by.it.nakhankov.jd02_05.User.FIRST_NAME),
                manager.get(by.it.nakhankov.jd02_05.User.LAST_NAME)
        );
    }
}
