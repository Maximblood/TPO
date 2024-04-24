package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AvitoPage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://www.avito.ru/";

    public AvitoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@data-marker='search-form/suggest']")
    private WebElement searchInput;
    @FindBy(xpath = "//*[@data-marker='search-form/submit-button']")
    private WebElement searchButton;

    public AvitoPage writeSearchText(String input){
        searchInput.sendKeys(input);
        return this;
    }
    public AvitoPage clickSearchButton(){
        searchButton.click();
        return this;
    }
    @Override
    public AvitoPage openPage() {
        webDriver.get(HOMEPAGE_URL);
        return this;
    }
}
