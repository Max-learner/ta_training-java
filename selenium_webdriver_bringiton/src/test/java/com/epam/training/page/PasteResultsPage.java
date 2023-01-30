package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PasteResultsPage {
    private WebDriver webDriver;
    private final String pastedPasteXPATH = "//div[@class='de1']";
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    @FindBy(xpath = pastedPasteXPATH)
    private WebElement pastedPaste;
    @FindBy(xpath = "//title")
    private WebElement pasteResultsPageTitle;
    @FindBy(xpath = "//a[text()='Bash']")
    private WebElement pasteSyntaxHighlighting;
    @FindBy(xpath = "//span[@title='Category']")
    private WebElement pasteCategory;
    @FindBy(xpath = "//a[text()='raw']")
    private WebElement rawPastedTextButton;
    public PasteResultsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public int countPasteResults(){
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(pastedPasteXPATH)));
        List<WebElement> pasteResultsAmount = webDriver.findElements(By.xpath(pastedPasteXPATH));
        return pasteResultsAmount.size();
    }
    public String readPageTitle(){
        return pasteResultsPageTitle.getAttribute("textContent");
    }
    public String readSyntaxHighlighting(){
        return pasteSyntaxHighlighting.getText();
    }
    public String readPasteCategory(){
        return pasteCategory.getText();
    }
    public RawPastedTextResultPage openRawResultPage(){
        rawPastedTextButton.click();
        return new RawPastedTextResultPage(webDriver);
    }
}
