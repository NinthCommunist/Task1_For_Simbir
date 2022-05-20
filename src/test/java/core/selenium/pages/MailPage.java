package core.selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends BasePage {
    public MailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".mail-NestedList-Item-Info .mail-NestedList-Item-Info-Extras")
    private WebElement countLetters;

    @FindBy(xpath = "//a[@title='Написать (w, c)']")
    private WebElement btnWrite;

    @FindBy(css = ".mail-ComposeButton-Refresh")
    private WebElement btnRefresh;

    @Step(value = "Получение количества писем")
    public int getCountOfLetters() {
        return Integer.parseInt(countLetters.getText().replaceAll("[^0-9]", ""));
    }

    @Step(value = "Открытие формы отправки письма")
    public LetterPage openLetterPage() {
        btnWrite.click();
        return new LetterPage(driver);
    }

    @Step(value = "Проверка получения нового письма")
    public MailPage checkNewLetter(int countBefore, long durationOfMillis) {
        long start = System.currentTimeMillis();
        while (countBefore == getCountOfLetters() && System.currentTimeMillis() - start < durationOfMillis) {
            waitForElementClickable(btnRefresh);
            btnRefresh.click();
        }
        return this;
    }


    @Step(value = "Получение текста в зависимости от числа писем")
    public String generateText(int countLetters) {
        int resultOfDiv10 = countLetters % 10;
        int resultOfDiv100 = countLetters % 100;
        if (resultOfDiv10 == 5 || resultOfDiv10 == 6 || resultOfDiv10 == 7
                || resultOfDiv10 == 8 || resultOfDiv10 == 9 || resultOfDiv10 == 0
                || resultOfDiv100 == 11 || resultOfDiv100 == 12 || resultOfDiv100 == 13 || resultOfDiv100 == 14) {
            return String.format("Найдено %d писем", countLetters);
        }

        if (resultOfDiv10 == 1) {
            return String.format("Найдено %d письмо", countLetters);
        }
        if (resultOfDiv10 == 2 || resultOfDiv10 == 3 || resultOfDiv10 == 4) {
            return String.format("Найдено %d письма", countLetters);
        }
        return "Неизвестное количество писем";
    }
}
