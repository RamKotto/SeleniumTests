package ru.saraev.utils;

import static ru.saraev.driver.DriverHandler.getDriver;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.saraev.providers.ConfigProvider;

@Slf4j
public class WaitUtils {

    public static void setImplicitlyWait() {
        log.info("Неявное ожидание установлено на " + ConfigProvider.IMPLICITLY_WAIT + " секунд.");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.IMPLICITLY_WAIT));
    }

    private static WebDriverWait getExplicitWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigProvider.EXPLICIT_WAIT));
    }

    public static WebElement waitUntilVisibilityOfElementLocated(By element) {
        return getExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
