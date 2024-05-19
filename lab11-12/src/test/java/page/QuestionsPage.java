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

public class QuestionsPage extends BasePage{
    private final Logger log = LogManager.getLogger();

    public QuestionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//h3[contains(text(), 'Частые вопросы')]")
    private WebElement oftenQuestionsText;


    public String getTitle(){
        log.info("Often questions text received");
        return oftenQuestionsText.getText();
    }

}
