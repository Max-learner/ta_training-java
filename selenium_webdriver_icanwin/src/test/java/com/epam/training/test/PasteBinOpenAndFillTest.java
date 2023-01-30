package com.epam.training.test;

import com.epam.training.page.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PasteBinOpenAndFillTest {

    private WebDriver webDriver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test (description = "First test in test system")
    public void pastePageOpenAndFillFormTest() {

        int expectedPasteResultsCount = new PastebinHomePage(webDriver)
                .openHomePage()
                .fillPasteForm("Hello from WebDriver", "helloweb")
                .countPasteResults();

        Assert.assertTrue(expectedPasteResultsCount > 0, "No search results!");
    }

    @AfterMethod (alwaysRun = true)
    public  void closeBrowser(){
        webDriver.quit();
        webDriver = null;
    }
}
