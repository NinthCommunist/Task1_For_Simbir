package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MailTest extends BaseTest {


    @Test(description = "Проверка отправки письма себе")
    public void sendLetterTest() {
        String titleForMail = "Simbirsoft theme";
        int countOfLettersBefore = mailPage.getCountOfLetters();
        String textForMail = mailPage.generateText(countOfLettersBefore);
        mailPage.openLetterPage()
                .selectToMe()
                .fillForm(titleForMail, textForMail)
                .sendLetter()
                .checkNewLetter(countOfLettersBefore, 30000);
        int countOfLettersAfter = mailPage.getCountOfLetters();
        Assert.assertEquals(countOfLettersAfter, countOfLettersBefore + 1);
    }
}
