package test;

import model.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.DescriptionPage;
import page.FavoritePage;
import page.SearchPage;
import service.ProductCreator;

public class FavoriteItemsTest extends CommonConditions{
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

        FavoritePage favoritePage = descriptionPage.clickAddFavoriteButton().goToFavoritePage();

        Assert.assertEquals(favoritePage.getTitle(), descriptionTitleText, "Названия товаров не совпадают!");

    }
}
