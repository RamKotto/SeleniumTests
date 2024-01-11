package ru.saraev.utils;

import static ru.saraev.driver.DriverHandler.getDriver;
import io.qameta.allure.Allure;
import java.io.File;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@Slf4j
public class ScreenshotUtils {

    public static void takeScreenshot(String path) {
        try {
            File target = new File(System.getProperty("user.dir") + path);
            File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            Allure.getLifecycle().addAttachment(
                "Screenshot", "image/png", "png",
                ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)
            );
            FileUtils.copyFile(src, target);
        } catch (IOException e) {
            log.info("Не удалось сделать скриншот!");
        }
    }
}
