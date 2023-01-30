package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class PastebinHomePage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;
    private WebDriver webDriver;
    @FindBy(xpath = "//*[@class='header__btn']")
    private WebElement addPasteButton;
    @FindBy(id = "postform-text")
    private WebElement pasteTextArea;
    @FindBy(xpath = "//span[@id='select2-postform-category_id-container']/parent::span")
    private WebElement pasteCategorySelect;
    @FindBy(xpath = "//li[text()='Source Code']")
    private WebElement pasteCategorySourceCode;
    @FindBy(xpath = "//span[@id='select2-postform-format-container']/parent::span")
    private WebElement pasteSyntaxHighlightingSelect;
    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement pasteSyntaxHighlightingBash;
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
        Set<Cookie> cookies = webDriver.manage().getCookies();

        PageFactory.initElements(webDriver, this);
    }
    public PastebinHomePage openPasteHomePage(){
        webDriver.get(HOMEPAGE_URL);
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.className("header__btn")));
        return this;
    }

    public PasteResultsPage fillPasteFormAndSubmit(String textToPaste, String nameToPaste){
        pasteTextArea.sendKeys(textToPaste);
        selectCategory();
        selectSyntaxHighlighting();
        selectPasteExpiration();
        pasteName.sendKeys(nameToPaste);
        submitPasteButton.click();
        return new PasteResultsPage(webDriver);
    }

    public void selectCategory(){
        pasteCategorySelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(pasteCategorySelect, "aria-expanded", "true"));
        pasteCategorySourceCode.click();
    }
    public void selectSyntaxHighlighting(){
        pasteSyntaxHighlightingSelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(pasteSyntaxHighlightingSelect, "aria-expanded", "true"));
        pasteSyntaxHighlightingBash.click();
    }
    public void selectPasteExpiration(){
        pasteExpirationSelect.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(pasteExpirationSelect, "aria-expanded", "true"));
        pasteExpiration10Minutes.click();
    }
}
