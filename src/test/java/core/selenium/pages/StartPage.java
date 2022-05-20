package core.selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.config.Constants.BASE_URL;

public class StartPage extends BasePage {
    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@href, 'auth')]")
    private WebElement btnSignIn;

    @Step(value = "Открытие стартовой страницы")
    public StartPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    @Step(value = "Открытие страницы логина")
    public LoginPage openLoginPage() {
        waitForElementVisible(btnSignIn);
        waitForElementClickable(btnSignIn);
        btnSignIn.click();
        return new LoginPage(driver);
    }
}
