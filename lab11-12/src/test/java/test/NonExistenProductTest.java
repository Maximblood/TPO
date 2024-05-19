package test;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.DescriptionPage;
import page.NotFoundPage;
import page.SearchPage;
import service.ProductCreator;

public class NonExistenProductTest extends CommonConditions{

    @Test
    public void checkNonExistenProductTest() throws InterruptedException {
        Product product = ProductCreator.withTitle();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.openPage()
                .writeSearchText(product.getProduct_name())
                .clickSearchButton();

        String firstItemUrl = searchPage.getFirstItemUrl();


        String firstTitleText = searchPage.getTitleText();
        DescriptionPage descriptionPage = searchPage.clickFirstItemTextButton();

        String descriptionTitleText = descriptionPage.getTitle();
        Assert.assertEquals(descriptionTitleText, firstTitleText, "Строки не совпадают!");

        String invalidUrl = firstItemUrl.replace("avito.ru", "avito.ru/invalid-path");
        driver.get(invalidUrl);

        NotFoundPage notFoundPage = new NotFoundPage(driver);
        Assert.assertTrue(notFoundPage.isNotFoundErrorDisplayed(), "There is no such page error message is not displayed!");

    }
}