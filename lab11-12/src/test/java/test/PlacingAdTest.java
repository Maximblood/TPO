package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.PlacingAdPage;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;

public class PlacingAdTest extends CommonConditions{
    private static final String RESULT_NAME = "Вход";

    @Test
    public void testPlacingAdTest() throws InterruptedException {
        PlacingAdPage placingAdPage = new PlacingAdPage(driver);
        placingAdPage.openPage().clickPlacingButton();
        Assert.assertTrue(placingAdPage.getTitle().contains(RESULT_NAME), "Неверный результат");
    }
}
