package by.it.abeseda.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;

    //мы создалі для переключнія языка
    //singleTon-это класс, у которого экземпляр создаётся только один раз.


    private String REFER="by.it.abeseda.jd02_05.resourse.language";

    private ResourceBundle rb;
//    private DateFormat df;

 //   Language() {
//        setLocale(Locale.getDefault());
//    }
 Language() {
     setLocale(Locale.ENGLISH);
 }

    public Locale getLocale(){
     return rb.getLocale();
    }

    //ссылка на папку, где искать переводы
    //копіровані через точкі -команда copy Reference


    void setLocale(Locale locale){
        rb= ResourceBundle.getBundle(REFER, locale);
    }

    String get(String key){
        return rb.getString(key);
    }
}
