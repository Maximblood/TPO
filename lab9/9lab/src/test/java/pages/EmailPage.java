package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailPage extends AbstractPage{
    private static final String PAGE_URL = "https://yopmail.com/ru/wm";
    @FindBy(xpath = "//button[@id='refresh']")
    WebElement refreshEmailsButton;

    @FindBy(xpath = "//iframe[@id='ifinbox']")
    WebElement inboxFrame;

    @FindBy(xpath = "//iframe[@id='ifmail']")
    WebElement emailFrame;

    @FindBy(xpath = "//div[@id='mail']/descendant::h3[2]")
    WebElement estimateEmailCost;

    @Override
    protected EmailPage openPage() {
        webDriver.navigate().to(PAGE_URL);
        return this;
    }

    public EmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openEmail() {
        while (!inboxFrame.isDisplayed()) {
            new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_IN_SECONDS)).until(ExpectedConditions.elementToBeClickable(refreshEmailsButton));
            refreshEmailsButton.click();
        }
    }

    public String getEstimateEmailCost() {
        webDriver.switchTo().frame(emailFrame);
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_IN_SECONDS)).until(ExpectedConditions.visibilityOf(estimateEmailCost));
        return estimateEmailCost.getText();
    }
}
