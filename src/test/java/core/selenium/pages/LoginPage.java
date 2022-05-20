package core.selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='login']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//button[@data-t='button:pseudo']")
    private WebElement btnNotNow;


    @Step(value = "Авторизация")
    public MailPage signIn(String login, String password) {
        inputLogin.sendKeys(login);
        btnSubmit.click();
        waitForElementVisible(inputPassword);
        inputPassword.sendKeys(password);
        btnSubmit.click();
        try {
            btnNotNow.click();
        } catch (Exception ignored) { //поп ап может не появиться
        }
        return new MailPage(driver);
    }

}
