package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FavoritePage extends BasePage{
    private final Logger log = LogManager.getLogger();

    public FavoritePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "(//*[@class=\"css-1e7cqb\"])[1]")
    private WebElement firstItemTitleText;

    @FindBy(xpath = "//*[@class=\"sorting-sorting-SytIe\"]")
    private WebElement sortingItemsTextButton;

    @FindBy(xpath = "(//*[@class=\"styles-module-textWrapper-LUnNm styles-module-textWrapper_size-s-Kg9aR\"])[2]")
    private WebElement moreExpensiveButton;

    @FindBy(xpath = "(//*[@class=\"styles-module-root-uSima styles-module-root-xvjz8 styles-module-size_l-eYNQn styles-module-size_l-rFHDY stylesMarningNormal-module-root-REW4p stylesMarningNormal-module-header-l-ODomD\"])[1]")
    private WebElement firstPriceText;

    @FindBy(xpath = "(//*[@class=\"styles-module-root-uSima styles-module-root-xvjz8 styles-module-size_l-eYNQn styles-module-size_l-rFHDY stylesMarningNormal-module-root-REW4p stylesMarningNormal-module-header-l-ODomD\"])[2]")
    private WebElement secondPriceText;

    public String getTitle(){
        log.info("First item title received");
        return firstItemTitleText.getText();
    }

    public FavoritePage clickSortingItemsTextButton(){
        sortingItemsTextButton.click();
        log.info("Sorting items button clicked");
        return this;
    }

    public FavoritePage clickMoreExpensiveButton(){
        moreExpensiveButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstPriceText));
        log.info("More expensive button clicked");
        return this;
    }

    public int extractFirstPriceAsNumber() {
        String digitsOnly = firstPriceText.getText().replaceAll("[^0-9]", "");
        log.info("First price text received: " + digitsOnly);
        return Integer.parseInt(digitsOnly);
    }

    public int extractSecondPriceAsNumber() {
        String digitsOnly = secondPriceText.getText().replaceAll("[^0-9]", "");
        log.info("Second price text received: " + digitsOnly);
        return Integer.parseInt(digitsOnly);
    }


}
