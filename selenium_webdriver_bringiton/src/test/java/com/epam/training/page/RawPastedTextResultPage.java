package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RawPastedTextResultPage {
    private WebDriver webDriver;
    private final String rawPastedTextXPATH = "//html/body/pre";
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    @FindBy(xpath = rawPastedTextXPATH)
    private WebElement rawPastedText;

    public RawPastedTextResultPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String readRawTextResults(){
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(rawPastedTextXPATH)));
        return rawPastedText.getText();
    }
}
