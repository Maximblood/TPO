package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenerateTempEmailPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://yopmail.com/ru/email-generator";

    @FindBy(xpath = "//button[@id='cprnd']")
    WebElement copyEmailButton;

    @FindBy(xpath = "//button/span[text()='Проверить почту']")
    WebElement checkEmailButton;

    public GenerateTempEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GenerateTempEmailPage openPage() {
        webDriver.get(HOMEPAGE_URL);
        return this;
    }

    public void copyEmailButtonClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_IN_SECONDS)).until(CustomCondition.isButtonEnabled(copyEmailButton));
        copyEmailButton.click();
    }

    public EmailPage checkEmailButtonClick() {
        checkEmailButton.click();
        return new EmailPage(webDriver);
    }

}