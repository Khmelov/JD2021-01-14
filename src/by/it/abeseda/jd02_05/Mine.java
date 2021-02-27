package by.it.abeseda.jd02_05;

import java.util.Locale;

public class Mine {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());


        System.out.println(Locale.getDefault().getCountry()); // код региона
        System.out.println(Locale.getDefault().getDisplayCountry()); // регион
        System.out.println(Locale.getDefault().getLanguage()); // код языка
        System.out.println(Locale.getDefault().getDisplayLanguage());
    }
}
