package ru.saraev.pages.helpdesk;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.saraev.elements.Button;
import ru.saraev.elements.DropDown;
import ru.saraev.elements.TextArea;
import ru.saraev.elements.TextField;
import ru.saraev.pages.base_page.BasePage;
import ru.saraev.providers.DataProvider;
import ru.saraev.utils.DriverUtils;

public class Homepage extends BasePage {

    public Homepage() {
        super(By.xpath("//h2[text()='Submit a Ticket']"), "Homepage");
    }

    DropDown queueDropdown = new DropDown(
        By.xpath("//*[@id='id_queue']"),
        "Queue dropdown",
        By.xpath("//*[@id='id_queue']/option[@value='1']")
    );

    TextField summaryField = new TextField(
        By.xpath("//input[@name='title']"),
        "Summary of the problem"
    );

    TextArea descriptionTextArea = new TextArea(
        By.xpath("//*[@id='id_body']"),
        "Description of your issue"
    );

    TextField emailField = new TextField(
        By.xpath("//*[@type='email']"),
        "Your E-Mail Address"
    );

    private final Button submitButton = new Button(
        By.xpath("//button[contains(text(),'Submit Ticket')]"),
        "'Submit Ticket' button"
    );

    public Homepage goToMainPage() {
        DriverUtils.open(DataProvider.HOST);
        return this;
    }

    @Step("Выбираем первое значение из Queue dropdown")
    public Homepage setQueueFirstValue() {
        queueDropdown.selectFirstDeclaredValueFromDropdown();
        return this;
    }

    @Step("Заполняем поле Summary of the problem: {summary}")
    public Homepage setSummary(String summary) {
        summaryField.sendKeys(summary);
        return this;
    }

    @Step("Заполняем поле Description of your issue: {description}")
    public Homepage setDescription(String description) {
        descriptionTextArea.sendKeys(description);
        return this;
    }

    @Step("Заполняем поле Your E-Mail Address: {email}")
    public Homepage setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("Кликаем по Submit Ticket кнопке и переходим на страницу New Ticket page")
    public TicketPage clickSubmitButtonAndNavigateToTicketPage() {
        submitButton.click();
        return new TicketPage();
    }
}
