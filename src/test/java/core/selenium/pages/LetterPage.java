package core.selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends BasePage {
    public LetterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class='MultipleAddressesDesktop-Field ComposeYabblesField'])[1]")
    private WebElement inputTo;

    @FindBy(css = ".ContactsSuggestItemDesktop-Name")
    private WebElement btnToMe;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement inputTitle;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement inputText;

    @FindBy(xpath = "//button[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']")
    private WebElement btnSend;

    @Step(value = "Выбор в качестве получателя себя")
    public LetterPage selectToMe() {
        inputTo.click();
        waitForElementVisible(btnToMe);
        btnToMe.click();
        return this;
    }

    @Step(value = "Заполнение заголовка и текста письма")
    public LetterPage fillForm(String title, String text) {
        inputTitle.sendKeys(title);
        inputText.sendKeys(text);
        return this;
    }

    @Step(value = "Отправка письма")
    public MailPage sendLetter() {
        btnSend.click();
        return new MailPage(driver);
    }


}
