package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchPage extends BasePage {
    private static final String HOMEPAGE_URL = "https://www.avito.ru/";
    private final Logger log = LogManager.getLogger();

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
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

    @FindBy(xpath = "(//*[@data-marker=\"item-title\"])[1]")
    private WebElement firstItemTextButton;

    @FindBy(xpath = "(//*[@data-marker=\"favorites-add\"])[1]")
    private WebElement firstItemFavoriteButton;

    @FindBy(xpath = "(//*[@data-marker=\"favorites-add\"])[2]")
    private WebElement secondItemFavoriteButton;

    @FindBy(xpath = "//a[@href=\"/favorites\"]")
    private WebElement favoritePageButton;

    @FindBy(xpath = "(//*[@class=\"style-root-uufhX\"])[1]//a")
    private WebElement sellerPageButton;



    public SearchPage writeSearchText(String input){
        searchInput.sendKeys(input);
        log.info("Search text is wroten");
        return this;
    }
    public SearchPage clickSearchButton(){
        searchButton.click();
        log.info("Search button is clicked");
        return this;
    }

    public List<WebElement> getTitles() {
        log.info("Titles is gotten");
        return searchResults;
    }

    public String getTitleText() {
        log.info("Title text is gotten");
        return firstItemTextButton.getText();
    }

    public SearchPage openPage() {
        driver.get(HOMEPAGE_URL);
        log.info("Main page is opened");
        return this;
    }

    public DescriptionPage clickFirstItemTextButton() {
        String originalWindow = driver.getWindowHandle();

        firstItemTextButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //переключение на другую вкладку
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-marker='item-view/title-info']")));

        log.info("First item text button is clicked and switched to new tab");
        return new DescriptionPage(driver);
    }

    public String getFirstItemUrl() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstItemTextButton));
        String firstItemUrl = firstItemTextButton.getAttribute("href");
        log.info("First item URL is gotten: " + firstItemUrl);
        return firstItemUrl;
    }

    public SearchPage clickFirstFavoriteButton() {
        firstItemFavoriteButton.click();
        log.info("First item favorite button is clicked");
        return this;
    }
    public SearchPage clickSecondFavoriteButton() {
        secondItemFavoriteButton.click();
        log.info("Second item favorite button is clicked");
        return this;
    }

    public FavoritePage goToFavoritePage() {
        favoritePageButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class=\"css-1e7cqb\"])[1]")));
        log.info("Favorite page button is clicked");
        return new FavoritePage(driver);
    }

    public String getSellerName(){
        String name = extractName(sellerPageButton.getText());
        log.info("SellerName is gotten: " + name);
        return name;
    }

    public SellerPage goToSellerPage(){
        String originalWindow = driver.getWindowHandle();

        sellerPageButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //переключение на другую вкладку
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"AvatarNameView-name-UrFI_\"]//h1")));

        log.info("Seller name is clicked and switched to new tab");
        return new SellerPage(driver);
    }


    public static String extractName(String input) {
        String regex = "^[^\\s]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(0);
        }

        return "";
    }


}
