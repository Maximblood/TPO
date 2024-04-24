package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HurtMePlentyPage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//div[@class='ND91id LLv0lb']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='i4']")
    private WebElement searchInput;


    public HurtMePlentyPage(WebDriver driver) {
        super(driver);
    }

    public HurtMePlentyPage openPage() {
        webDriver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultPage startSearch(String searchText) {
        searchButton.click();
        searchInput.sendKeys(searchText);
        searchInput.sendKeys(Keys.RETURN);
        return new SearchResultPage(webDriver);
    }
}