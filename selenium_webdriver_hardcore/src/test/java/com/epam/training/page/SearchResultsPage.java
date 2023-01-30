package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {
    private WebDriver webDriver;
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(20);

    private final String SEARCH_RESULT_XPATH = "//b[contains(text(), 'Google') and contains(text(), 'Cloud') and contains(text(), 'Platform') and contains(text(), 'Pricing') and contains(text(), 'Calculator')]//parent::a";
    @FindBy(xpath = SEARCH_RESULT_XPATH)
    private WebElement pricingCalculatorPageLink;

    public SearchResultsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public PricingCalculatorPage navigateToPricingCalculatorPage(){
        pricingCalculatorPageLink.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//iframe")));
//        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
//                .until(ExpectedConditions
//                        .presenceOfAllElementsLocatedBy(By.xpath("//div[@class='hexagon']")));
        return new PricingCalculatorPage(webDriver);
    }
}
