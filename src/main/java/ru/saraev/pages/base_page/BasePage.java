package ru.saraev.pages.base_page;

import static ru.saraev.utils.WaitUtils.waitUntilVisibilityOfElementLocated;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public abstract class BasePage {

    protected By rootElement;
    protected String pageName;

    public BasePage(By rootElement, String pageName) {
        this.rootElement = rootElement;
        this.pageName = pageName;
        waitUntilVisibilityOfElementLocated(rootElement);
        log.info("Страница " + this.pageName + " открыта.");
    }
}
