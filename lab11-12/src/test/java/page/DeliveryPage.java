package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeliveryPage extends BasePage {
    private final Logger log = LogManager.getLogger();

    public DeliveryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@class=\"header-section-title-IflKn\"]")
    private WebElement deliveryText;

    public String getDeliveryText() {
        log.info("Delivery text is gotten: " + deliveryText.getText());
        return deliveryText.getText();
    }
}
