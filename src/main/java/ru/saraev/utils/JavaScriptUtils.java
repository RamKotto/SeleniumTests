package ru.saraev.utils;

import static ru.saraev.driver.DriverHandler.getDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    private final static JavascriptExecutor JS = (JavascriptExecutor) getDriver();

    public static void paintBorderToRed(WebElement element) {
        JS.executeScript("arguments[0].style.border = '3px solid #FF0000';", element);
    }
}
