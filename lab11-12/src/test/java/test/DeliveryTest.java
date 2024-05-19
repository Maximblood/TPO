package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.DeliveryPage;
import page.MainPage;
import page.QuestionsPage;

public class DeliveryTest extends CommonConditions{
    private static final String RESULT_NAME = "Авито Доставка";

    @Test
    public void checkOftenQuestionsTitleTest() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);

        DeliveryPage deliveryPage = mainPage.openPage()
                .clickCloseRegionButton()
                .clickDeliveryPageButton();

        String deliveryText = deliveryPage.getDeliveryText();
        Assert.assertEquals(deliveryText, RESULT_NAME, "Данный заголовок не найден!");

    }
}
