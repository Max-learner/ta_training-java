package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    private WebDriver webDriver;
    @FindBy(xpath = "//*[@class='header__btn']")
    private WebElement addPasteButton;
    @FindBy(id = "postform-text")
    private WebElement pasteTextArea;
    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']/parent::span")
    private WebElement pasteExpirationSelect;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpiration10Minutes;
    @FindBy(id = "postform-name")
    private WebElement pasteName;
    @FindBy(xpath = "//*[@class='btn -big']")
    private WebElement submitPasteButton;

    public PastebinHomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public PastebinHomePage openHomePage(){
        webDriver.get(HOMEPAGE_URL);
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.className("header__btn")));
        return this;
    }
    public PasteResultsPage fillPasteForm(String textToPaste, String nameToPaste){
        pasteTextArea.sendKeys(textToPaste);
        pasteExpirationSelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(pasteExpirationSelect, "aria-expanded", "true"));
        pasteExpiration10Minutes.click();
        pasteName.sendKeys(nameToPaste);
        submitPasteButton.click();
        return new PasteResultsPage(webDriver);
    }
}
