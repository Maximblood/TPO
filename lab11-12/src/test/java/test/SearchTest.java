package test;
import model.Product;
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
import page.PlacingAdPage;
import page.SearchPage;
import service.ProductCreator;

import java.time.Duration;
import java.util.List;

public class SearchTest extends CommonConditions {

    @Test
    public void testSearchElementsTest() throws InterruptedException {
        Product product = ProductCreator.withTitle();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.openPage()
                .writeSearchText(product.getProduct_name())
                .clickSearchButton();

        List<WebElement> titles = searchPage.getTitles();
        for (WebElement title : titles) {
            String titleText = title.getText().toLowerCase();
            Assert.assertTrue(titleText.contains("ноутбук"), "Строка 'ноутбук' не найдена в заголовке: " + titleText);
        }
    }
}
