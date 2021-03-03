package by.it.nakhankov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private static final String RES_PATH = "by.it.nakhankov.jd02_05.lang.language";

    private ResourceBundle resourceBundle;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(RES_PATH, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

}
