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
}
