package by.it.abeseda.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;

    //мы создалі для переключнія языка
    //singleTon-это класс, у которого экземпляр создаётся только один раз.


    private static final String REFER="by.it.abeseda.jd02_05.resourse.language";

    private ResourceBundle rb;

    Language() {
        setLocale(Locale.getDefault());
    }


    //ссылка на папку, где искать переводы
    //копіровані через точкі -команда copy Reference


    public void setLocale(Locale locale){
        rb= ResourceBundle.getBundle(REFER, locale);
    }

    String get(String key){
        return rb.getString(key);
    }
}
