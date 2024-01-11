package ru.saraev.elements;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class DropDown extends BaseElement {

    private final ArrayList<TextLabel> dropDownValues;

    public DropDown(By locator, String name, By... valueLocator) {
        super(locator, name);
        this.dropDownValues = new ArrayList<>();
        if (valueLocator.length > 0) {
            int i = 0;
            for (By label : valueLocator) {
                this.dropDownValues.add(new TextLabel(label, "value index: " + i));
                i++;
            }
        }
    }

    public void selectFirstDeclaredValueFromDropdown() {
        log.info("Выбираем элемент: " + dropDownValues.get(0).name + " из " + this.name);
        waitAndFindElement().click();
        this.dropDownValues.get(0).waitAndFindElement().click();
    }
}
