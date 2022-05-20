package tests;

import core.selenium.WebDriverInstall;
import core.selenium.pages.MailPage;
import core.selenium.pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static core.config.Constants.LOGIN;
import static core.config.Constants.PASSWORD;

public class BaseTest {
    protected WebDriver driver;
    private StartPage startPage;
    protected MailPage mailPage;


    @BeforeTest
    public void setUp() {
        driver = WebDriverInstall.createSelenoidDriver();
        startPage = new StartPage(driver);
        mailPage = startPage.openPage()
                .openLoginPage()
                .signIn(LOGIN, PASSWORD);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
