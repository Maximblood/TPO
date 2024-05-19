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

public class DescriptionPage extends BasePage{
    private final Logger log = LogManager.getLogger();

    public DescriptionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@data-marker='item-view/title-info']")
    private WebElement itemTitleText;

    @FindBy(xpath = "//*[@data-marker=\"favorite-seller-subscription-button\"]")
    private WebElement subscribeButton;

    @FindBy(xpath = "//form[@data-marker='login-form']//descendant::h2")
    private WebElement authTitleText;

    @FindBy(xpath = "//div[@class=\"style-header-add-favorite-M7nA2\"]//button")
    private WebElement addFavoriteButton;

    @FindBy(xpath = "//a[@href=\"/favorites\"]")
    private WebElement favoritePageButton;

    public String getTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(itemTitleText));
        log.info("Title received ");
        return itemTitleText.getText();
    }


    public DescriptionPage clickSubscribeButton(){
        subscribeButton.click();
        log.info("Subscribe button is clicked");
        return this;
    }

    public String getAuthTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@data-marker='login-form']//descendant::h2")));
        log.info("Auth title received");
        return authTitleText.getText();
    }

    public DescriptionPage clickAddFavoriteButton(){
        addFavoriteButton.click();
        log.info("Add favorite button is clicked");
        return this;
    }

    public FavoritePage goToFavoritePage() {
        favoritePageButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class=\"css-1e7cqb\"])[1]")));
        log.info("Favorite page button is clicked");
        return new FavoritePage(driver);
    }

}
