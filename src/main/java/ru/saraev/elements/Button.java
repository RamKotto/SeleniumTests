package ru.saraev.elements;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class Button extends BaseElement {

    public Button(By locator, String name) {
        super(locator, name);
    }

    public void click() {
        log.info("Кликаем по " + this.name);
        Allure.step("Пользователь кликает по " + this.name,
            () -> waitAndFindElement().click());
    }
}
