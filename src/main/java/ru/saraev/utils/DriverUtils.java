package ru.saraev.utils;

import static ru.saraev.driver.DriverHandler.getDriver;

public class DriverUtils {

    public static void open(String URL) {
        getDriver().get(URL);
    }

    public static void setWindowSizeMaximize() {
        getDriver().manage().window().maximize();
    }
}
