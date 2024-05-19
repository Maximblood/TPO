package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotFoundPage extends BasePage {
    private final Logger log = LogManager.getLogger();

    public NotFoundPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        waitForPageToLoad();
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"content-description\"]")));
        log.info("Not Found page was loaded");
    }

    @FindBy(xpath = "//h1[contains(text(), 'Такой страницы нe существует')]")
    private WebElement errorMessage;

    public boolean isNotFoundErrorDisplayed() {
        log.info("There is no such page error message is displayed");
        return errorMessage.isDisplayed();
    }
}
