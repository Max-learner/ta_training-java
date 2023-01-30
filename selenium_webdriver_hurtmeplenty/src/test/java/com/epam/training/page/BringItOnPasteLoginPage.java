package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BringItOnPasteLoginPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String USERNAME = "QAZwsx12";
    private static final String PASSWORD = "QAZwsxEDCrfv1234";
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(30);
    private WebDriver webDriver;
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;
    @FindBy(id = "loginform-username")
    private WebElement inputUserName;
    @FindBy(id = "loginform-password")
    private WebElement inputPassword;
    @FindBy(xpath = "//*[@class='btn -big']")
    private WebElement loginSubmitButton;

    public BringItOnPasteLoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudPlatformHomepage fillLoginFormAndSubmit(){
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.className("header__btn")));
        inputUserName.sendKeys(USERNAME);
        inputPassword.sendKeys(PASSWORD);
        loginSubmitButton.click();
        return new GoogleCloudPlatformHomepage(webDriver);
    }
}
