package by.it.lapushkin.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResMan manager = ResMan.INSTANCE;
        String str;
        while (!(str = scanner.nextLine()).equals("end")) {
            switch (str) {
                case "ru":
                    manager.setLocale(new Locale("ru", "RU"));
                    break;
                case "be":
                    manager.setLocale(new Locale("be", "BY"));
                    break;
                case "en":
                    manager.setLocale(new Locale("en", "EN"));
                    break;
                default:
                    manager.setLocale(Locale.ENGLISH);
            }


            System.out.printf(
                    "%s%n%s%n%s%n%s%n",
                    Time.getTime(manager.getLocale()) + "--" + manager.get(Messages.WELCOME),
                    Time.getTime(manager.getLocale()) + "--" + manager.get(Messages.QUESTION),
                    Time.getTime(manager.getLocale()) + "--" + manager.get(User.FIRST_NAME),
                    Time.getTime(manager.getLocale()) + "--" + manager.get(User.LAST_NAME)
            );


        }
    }
}
