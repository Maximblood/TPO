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

public class PlacingAdPage extends BasePage{
    private static final String HOMEPAGE_URL = "https://www.avito.ru/";
    private final Logger log = LogManager.getLogger();

    public PlacingAdPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//a[@href='#login?next=%2Fadditem&authsrc=ca']")
    private WebElement placingButton;

    @FindBy(xpath = "//form[@data-marker='login-form']//descendant::h2")
    private WebElement titleText;


    public PlacingAdPage clickPlacingButton(){
        placingButton.click();
        log.info("Placing button clicked");
        return this;
    }

    public String getTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@data-marker='login-form']//descendant::h2")));
        log.info("Title received");
        return titleText.getText();
    }

    public PlacingAdPage openPage() {
        driver.get(HOMEPAGE_URL);
        log.info("Main page opened");
        return this;
    }
}
