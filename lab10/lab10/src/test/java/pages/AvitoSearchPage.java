package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AvitoSearchPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.avito.ru/";

    public AvitoSearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@data-marker='search-form/suggest']")
    private WebElement searchInput;
    @FindBy(xpath = "//*[@data-marker='search-form/submit-button']")
    private WebElement searchButton;
    @FindAll(
            {
                    @FindBy(xpath = "//div[@class='iva-item-title-py3i_']//descendant::a//descendant::h3")
            }
    )
    private List<WebElement> searchResults;

    public AvitoSearchPage writeSearchText(String input){
        searchInput.sendKeys(input);
        return this;
    }
    public AvitoSearchPage clickSearchButton(){
        searchButton.click();
        return this;
    }

    public List<WebElement> getTitles() {
        return searchResults;
    }

    @Override
    public AvitoSearchPage openPage() {
        webDriver.get(HOMEPAGE_URL);
        return this;
    }
}
