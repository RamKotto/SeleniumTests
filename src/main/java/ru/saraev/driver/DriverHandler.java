package ru.saraev.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.saraev.providers.ConfigProvider;

@Slf4j
public class DriverHandler {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
            return driver;
        }
        return driver;
    }

    public static void createDriver() {
        log.info("Создаем " + ConfigProvider.BROWSER + " браузер");
        switch (ConfigProvider.BROWSER) {
            case "CHROME" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            default -> {
                log.info("Проверь config.properties. Тип браузера указан некорректно!");
                log.info("Допустимые значения: CHROME, FIREFOX");
            }
        }
    }

    public static void driverQuit() {
        log.info("Завершаем работу браузера");
        getDriver().close();
        getDriver().quit();
    }
}
