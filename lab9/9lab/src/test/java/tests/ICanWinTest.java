package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ICanWinPage;

public class ICanWinTest {
    private WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("acceptInsecureCerts", true);
        webDriver = new ChromeDriver();
    }

    @Test
    public void tryCreateNewPaste(){
        ICanWinPage iCanWinPage = new ICanWinPage(webDriver);
        iCanWinPage.openPage();
        iCanWinPage.writeNewPaste("Hello from WebDriver");
        iCanWinPage.chooseExpirationOption("10 Minutes");
        iCanWinPage.writeName("helloweb");
        String oldUrl = webDriver.getCurrentUrl();
        iCanWinPage.clickCreateNewPasteButton();
        Assert.assertNotEquals(oldUrl, webDriver.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        webDriver.quit();
    }
}
