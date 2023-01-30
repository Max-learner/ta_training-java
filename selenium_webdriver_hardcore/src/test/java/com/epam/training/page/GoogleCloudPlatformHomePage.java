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

public class GoogleCloudPlatformHomePage {

    private static final String HOMEPAGE_URL = " https://cloud.google.com/";
    private final String textToSearch = "Google Cloud Platform Pricing Calculator";
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    private WebDriver webDriver;
    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchInput;

    public GoogleCloudPlatformHomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        Set<Cookie> cookies = webDriver.manage().getCookies();

        PageFactory.initElements(webDriver, this);
    }
    public GoogleCloudPlatformHomePage openHomePage(){
        webDriver.get(HOMEPAGE_URL);
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.className("devsite-searchbox")));
        return this;
    }

    public SearchResultsPage activateSearch(){
        searchInput.click();
        searchInput.sendKeys(textToSearch);
        searchInput.submit();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//a[@class='gs-title']")));
        return new SearchResultsPage(webDriver);
    }

}
