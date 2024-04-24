package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AvitoPage;

public class AvitoTest {
    private static final String ITEM_NAME = "ноутбук";
    private static final String FINAL_URL = "https://www.avito.ru/all?q=%D0%BD%D0%BE%D1%83%D1%82%D0%B1%D1%83%D0%BA";

    private WebDriver driver;
    private AvitoPage avitoPage;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        avitoPage = new AvitoPage(driver);
    }

    @Test
    public void searchItemOnMarket(){
        avitoPage = avitoPage.openPage()
                .writeSearchText(ITEM_NAME)
                .clickSearchButton();
        Assert.assertEquals(driver.getCurrentUrl(), FINAL_URL, "Bad Url");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}