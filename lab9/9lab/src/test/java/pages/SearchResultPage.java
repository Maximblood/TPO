package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class SearchResultPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='K5hUy'][@href='https://cloud.google.com/products/calculator-legacy?hl=es-419']")
    private WebElement searchResults;


    protected SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage goToResult(String resultName) {

                    new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_IN_SECONDS)).until(ExpectedConditions.elementToBeClickable(searchResults)).click();



        return new CalculatorPage(webDriver);
    }


    @Override
    protected AbstractPage openPage() {
        return null;
    }
}