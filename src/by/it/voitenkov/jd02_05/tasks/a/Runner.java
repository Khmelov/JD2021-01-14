package by.it.voitenkov.jd02_05.tasks.a;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        ResMan manager = ResMan.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        String line;

        while (!(line = scanner.nextLine()).equals("exit")) {
            switch (line) {
                case "en" -> manager.setLocale(new Locale("en", "EN"));
                case "ru" -> manager.setLocale(new Locale("ru", "RU"));
                case "be" -> manager.setLocale(new Locale("be", "BY"));
                default -> manager.setLocale(Locale.ENGLISH);
            }

            System.out.printf("%s%n%s%n%s%n%s%n",
                    Date.getDate(manager.getLocale()) + " " + manager.get(Messages.WELCOME),
                    Date.getDate(manager.getLocale()) + " " + manager.get(Messages.QUESTION),
                    Date.getDate(manager.getLocale()) + " " + manager.get(User.FIRST_NAME),
                    Date.getDate(manager.getLocale()) + " " + manager.get(User.LAST_NAME)
            );


        }
//        if (args.length == 2) {
//            Locale locale = new Locale(args[0], args[1]);
//            manager.setLocale(locale);
//        }
//        System.out.printf(
//                manager.get(Messages.FORMAT_CONSOLE),
//                manager.get(Messages.WELCOME),
//                manager.get(Messages.QUESTION),
//                manager.get(User.FIRST_NAME),
//                manager.get(User.LAST_NAME)
//        );
    }
}
