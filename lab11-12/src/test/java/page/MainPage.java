package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    private final Logger log = LogManager.getLogger();

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@href=\"//support.avito.ru\"]")
    private WebElement helpPageButton;

    @FindBy(xpath = "//a[@href=\"/dostavka#buyer\"]")
    private WebElement deliveryPageButton;

    @FindBy(xpath = "//*[@data-marker='location/tooltip-leave-as-is']")
    private WebElement closeRegionButton;

    public QuestionsPage clickHelpPageButton() {
        String originalWindow = driver.getWindowHandle();

        helpPageButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //переключение на другую вкладку
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"_2k1K0xlUez6KQGse3IMCFS\"]//h1")));

        log.info("Help button is clicked and switched to new tab");
        return new QuestionsPage(driver);
    }

    public MainPage clickCloseRegionButton(){
        closeRegionButton.click();
        log.info("Close region button is clicked");
        return this;
    }

    public DeliveryPage clickDeliveryPageButton() {
        String originalWindow = driver.getWindowHandle();

        deliveryPageButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //переключение на другую вкладку
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"header-section-title-IflKn\"]")));

        log.info("Delivery button is clicked and switched to new tab");
        return new DeliveryPage(driver);
    }


    public MainPage openPage() {
        driver.navigate().to("https://www.avito.ru/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(deliveryPageButton));
        log.info("Main page is opened");
        return this;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
