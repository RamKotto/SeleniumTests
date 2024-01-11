package ru.saraev.pages.helpdesk;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.saraev.elements.Button;
import ru.saraev.elements.TextArea;
import ru.saraev.elements.TextLabel;
import ru.saraev.pages.base_page.BasePage;

public class TicketPage extends BasePage {

    public TicketPage() {
        super(By.xpath("//*[contains(text(),'Update This Ticket')]"), "New Ticket page");
    }

    private final TextArea commentField = new TextArea(
        By.xpath("//*[@name='comment']"),
        "'Comment / Resolution' text area"
    );

    private final TextLabel summaryLabel = new TextLabel(
        By.xpath("//caption"),
        "Summary of Ticket"
    );

    private final TextLabel emailLabel = new TextLabel(
        By.xpath("//*[contains(text(),'Submitter E-Mail')]/following-sibling::td"),
        "Email label"
    );

    private final Button updateTicketBtn = new Button(
        By.xpath("//button[contains(text(),'Update This Ticket')]"),
        "Update This Ticket button"
    );

    @Step("Заполняем поле Comment / Resolution: {comment}")
    public TicketPage setComment(String comment) {
        commentField.sendKeys(comment);
        return this;
    }

    @Step("Получаем значение поля Summary of Ticket")
    public String getTextFromSummary() {
        return summaryLabel.getText();
    }

    @Step("Получаем значение поля Email label")
    public String getTextFromEmailLabel() {
        return emailLabel.getText();
    }

    @Step("Проверяем состояние кнопки Update This Ticket")
    public boolean isUpdateTicketButtonEnabled() {
        return updateTicketBtn.isEnabled();
    }
}
