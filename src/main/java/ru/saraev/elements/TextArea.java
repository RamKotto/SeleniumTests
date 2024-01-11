package ru.saraev.elements;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class TextArea extends BaseElement {

    public TextArea(By locator, String name) {
        super(locator, name);
    }

    public void sendKeys(String keys) {
        log.info("Вводим текст: '" + keys + "' в " + this.name);
        waitAndFindElement().sendKeys(keys);
    }
}
