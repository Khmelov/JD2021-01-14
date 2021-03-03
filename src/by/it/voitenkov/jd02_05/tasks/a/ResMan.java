package by.it.voitenkov.jd02_05.tasks.a;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private static final String RES_PATH = "by.it.voitenkov.jd02_05.tasks.a.lang.language";
    private ResourceBundle resourceBundle;
    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(RES_PATH, locale);
    }
    public String get(String key) {
        return resourceBundle.getString(key);
    }
    public Locale getLocale(){
        return resourceBundle.getLocale();
    }
    ResMan() {
        setLocale(Locale.getDefault());
    }

}
