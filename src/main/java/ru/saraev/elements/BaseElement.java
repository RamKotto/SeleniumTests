package ru.saraev.elements;

import static ru.saraev.utils.JavaScriptUtils.paintBorderToRed;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.saraev.utils.WaitUtils;

@Slf4j
public abstract class BaseElement {

    protected By locator;
    protected String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    protected WebElement waitAndFindElement() {
        log.info("Ожидаем элемент по локатору: " + this.locator.toString());
        WebElement webElement = WaitUtils.waitUntilVisibilityOfElementLocated(this.locator);
        paintBorderToRed(webElement);
        return webElement;
    }

    public boolean isDisplayed() {
        log.info("Проверяем отображение элемента на странице по локатору: " + this.locator.toString());
        return waitAndFindElement().isDisplayed();
    }

    public boolean isEnabled() {
        log.info("Проверяем доступность элемента на странице по локатору: " + this.locator.toString());
        return waitAndFindElement().isEnabled();
    }
}
