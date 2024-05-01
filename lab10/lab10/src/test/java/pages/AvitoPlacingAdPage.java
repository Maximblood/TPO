package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AvitoPlacingAdPage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://www.avito.ru/";

    public AvitoPlacingAdPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@href='#login?next=%2Fadditem&authsrc=ca']")
    private WebElement placingButton;

    @FindBy(xpath = "//form[@data-marker='login-form']//descendant::h2")
    private WebElement titleText;


    public AvitoPlacingAdPage clickPlacingButton(){
        placingButton.click();
        return this;
    }
    public WebElement getTitle() {
        return titleText;
    }
    public String waiting(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@data-marker='login-form']//descendant::h2")));
        return  titleElement.getText();
    }

    @Override
    public AvitoPlacingAdPage openPage() {
        webDriver.get(HOMEPAGE_URL);
        return this;
    }
}
