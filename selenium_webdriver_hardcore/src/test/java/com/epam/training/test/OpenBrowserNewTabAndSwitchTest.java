package com.epam.training.test;

import com.epam.training.page.EmailServicePage;
import com.epam.training.service.BrowserTabOperator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenBrowserNewTabAndSwitchTest {

    private WebDriver webDriver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test (description = "Service test in test system")
    public void startCalculatorAndFillFormTest() throws InterruptedException {

        EmailServicePage emailServicePage = new EmailServicePage(webDriver);
        emailServicePage.openInbox();
        System.out.println(emailServicePage.getEmail());

        BrowserTabOperator browserTabOperator = new BrowserTabOperator(webDriver);
        browserTabOperator.openNewTab();
        browserTabOperator.switchToFirstTab();

        EmailServicePage emailServiceSupportingPage = new EmailServicePage(webDriver);
        emailServiceSupportingPage.openInbox();
        emailServiceSupportingPage.setRecepientEmailAddress(emailServicePage.getEmail());
        System.out.println(emailServiceSupportingPage.getEmail());
        emailServiceSupportingPage.writeAndSendNewMessage();

        browserTabOperator.switchToDefaultTab();
        emailServicePage.refreshInbox();
        System.out.println(emailServicePage.getReceivedMessageText());
    }

    @AfterMethod (alwaysRun = true)
    public  void closeBrowser(){
//        webDriver.quit();
        webDriver = null;
    }
}
