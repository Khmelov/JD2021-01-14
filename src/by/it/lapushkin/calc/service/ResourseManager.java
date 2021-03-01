package by.it.lapushkin.calc.service;

import java.util.Locale;
import java.util.ResourceBundle;
public enum ResourseManager {
    INSTANCE;

    private static final String RES_PATH = "by.it.lapushkin.calc.service.language.language";

    private ResourceBundle resourceBundle;

    ResourseManager() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(RES_PATH, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
