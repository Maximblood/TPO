package test;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.DescriptionPage;
import page.PlacingAdPage;
import page.SearchPage;
import service.ProductCreator;

import java.time.Duration;
import java.util.List;

public class DescriptionTest extends CommonConditions{

    @Test
    public void checkDescriptionTitleTest() throws InterruptedException {
        Product product = ProductCreator.withTitle();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.openPage()
                .writeSearchText(product.getProduct_name())
                .clickSearchButton();

        String firstTitleText = searchPage.getTitleText();
        DescriptionPage descriptionPage = searchPage.clickFirstItemTextButton();

        String descriptionTitleText = descriptionPage.getTitle();
        Assert.assertEquals(descriptionTitleText, firstTitleText, "Названия товаров не совпадают!");

    }
}
