package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AvitoPlacingAdPage;
import pages.AvitoSearchPage;

import java.time.Duration;
import java.util.List;

public class AvitoPlacingAdTest {
    private static final String RESULT_NAME = "Вход";
    private static final String FINAL_URL = "https://www.avito.ru/all?q=%D0%BD%D0%BE%D1%83%D1%82%D0%B1%D1%83%D0%BA";

    private WebDriver driver;
    private AvitoPlacingAdPage avitoPlacingAdPage;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        avitoPlacingAdPage = new AvitoPlacingAdPage(driver);
    }

    @Test
    public void searchItemOnMarket(){
        avitoPlacingAdPage = avitoPlacingAdPage.openPage()
                .clickPlacingButton();

        String title = avitoPlacingAdPage.waiting(driver);
        Assert.assertTrue(title.contains(RESULT_NAME), "Неверный результат");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
