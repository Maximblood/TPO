package test;

import model.Product;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.FavoritePage;
import page.SearchPage;
import service.ProductCreator;

import java.util.List;

public class SortingTest extends CommonConditions{
    @Test
    public void testSearchElementsTest() throws InterruptedException {
        Product product = ProductCreator.withTitle();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.openPage()
                .writeSearchText(product.getProduct_name())
                .clickSearchButton();


        FavoritePage favoritePage = searchPage.clickFirstFavoriteButton()
                .clickSecondFavoriteButton()
                .goToFavoritePage();

        favoritePage.clickSortingItemsTextButton()
                .clickMoreExpensiveButton();

        Assert.assertTrue(favoritePage.extractFirstPriceAsNumber() >= favoritePage.extractSecondPriceAsNumber());
    }
}
