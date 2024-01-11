package ru.saraev.elements;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class TextLabel extends BaseElement {

    public TextLabel(By locator, String name) {
        super(locator, name);
    }

    public String getText() {
        log.info("Получаем текст из " + this.name);
        return waitAndFindElement().getText();
    }
}
