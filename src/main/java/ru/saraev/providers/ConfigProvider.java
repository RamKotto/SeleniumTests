package ru.saraev.providers;

import java.util.ResourceBundle;

public class ConfigProvider {

    public static final String BROWSER = getValue("browser");
    public static final Integer IMPLICITLY_WAIT = Integer.parseInt(getValue("implicitly_wait"));
    public static final Integer EXPLICIT_WAIT = Integer.parseInt(getValue("explicit_wait"));

    private static final String CONFIG = "config";

    private static String getValue(String key) {
        return ResourceBundle.getBundle(ConfigProvider.CONFIG).getString(key);
    }
}
