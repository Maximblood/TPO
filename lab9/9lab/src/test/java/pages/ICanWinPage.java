package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ICanWinPage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(xpath = "//textarea[@name='PostForm[text]']")
    private WebElement newPaste;

    @FindBy(xpath = "//select[@id='postform-expiration']/following::span[1]")
    private WebElement selectPasteExpiration;

    @FindAll({
            @FindBy(xpath = "//li[@class='select2-results__option']")
    })
    private List<WebElement> pasteExpirationOptions;

    @FindBy(xpath = "//input[@name='PostForm[name]']")
    private WebElement pasteName;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement newPasteButton;

    public ICanWinPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ICanWinPage openPage(){
        webDriver.get(HOMEPAGE_URL);
        return this;
    }

    public void writeNewPaste(String text){
        newPaste.sendKeys(text);
    }

    public void chooseExpirationOption(String expirationOption){
        setSelectOption(selectPasteExpiration, expirationOption);
    }

    public void writeName(String name){
        pasteName.sendKeys(name);
    }

    public void clickCreateNewPasteButton(){
        newPasteButton.click();
        //new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_IN_SECONDS)).until(CustomCondition.changingURL(webDriver.getCurrentUrl()));
    }

    public void setSelectOption(WebElement select, String option){
        select.click();
        for(WebElement selectOption : pasteExpirationOptions){
            if(selectOption.getText().trim().equals(option.trim())){
                selectOption.click();
                new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_IN_SECONDS)).until(ExpectedConditions.invisibilityOf(selectOption));
                break;
            }
        }
    }
}
