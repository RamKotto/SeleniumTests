package ru.saraev.providers;

import java.util.ResourceBundle;

public class DataProvider {

    public static final String HOST = getValue("host");
    public static final String LOGIN = getValue("login");
    public static final String PASSWORD = getValue("password");

    private static final String DATA = "data";

    private static String getValue(String key) {
        return ResourceBundle.getBundle(DataProvider.DATA).getString(key);
    }
}
