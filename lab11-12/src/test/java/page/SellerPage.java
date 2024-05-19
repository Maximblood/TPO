package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellerPage extends BasePage{
    private final Logger log = LogManager.getLogger();

    public SellerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@class=\"AvatarNameView-name-UrFI_\"]//h1")
    private WebElement sellerNameText;


    public String getSellerName(){
        log.info("Seller name is gotten: " + sellerNameText.getText());
        return sellerNameText.getText();
    }

}
