package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.DescriptionPage;
import page.MainPage;
import page.QuestionsPage;
import page.SearchPage;

public class QuestionsTest extends CommonConditions{
    private static final String RESULT_NAME = "Частые вопросы";

    @Test
    public void checkOftenQuestionsTitleTest() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);

        QuestionsPage questionsPage = mainPage.openPage()
                .clickHelpPageButton();

        String oftenQuestionsText = questionsPage.getTitle();
        Assert.assertEquals(oftenQuestionsText, RESULT_NAME, "Данный заголовок не найден!");

    }
}
