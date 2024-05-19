package test;

import model.Product;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchPage;
import page.SellerPage;
import service.ProductCreator;

import java.util.List;

public class SellerTest extends CommonConditions{
    @Test
    public void testSellerNameTest() throws InterruptedException {
        Product product = ProductCreator.withTitle();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.openPage()
                .writeSearchText(product.getProduct_name())
                .clickSearchButton();

        String sellerName = searchPage.getSellerName();

        SellerPage sellerPage = searchPage.goToSellerPage();

        Assert.assertEquals(sellerPage.getSellerName(), sellerName, "Имя продавца не сходится!");


    }
}
