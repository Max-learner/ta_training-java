package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailYourEstimatePage {

    private String email = "zemautraummudei-6596@yopmail.com";

    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    private WebDriver webDriver;

    @FindBy(xpath = "//input[contains(@ng-model, 'emailQuote.user.email')]")
    private WebElement inputEmail;
    @FindBy(xpath = "//button[contains(@ng-click, 'emailQuote.emailQuote')]")
    private WebElement sendEmailButton;

    public EmailYourEstimatePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void fillFormAndSubmit(){
        WebElement outerFrame = webDriver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe"));
        webDriver.switchTo().frame(outerFrame);
        WebElement innerframe = webDriver.findElement(By.id("myFrame"));
        webDriver.switchTo().frame(innerframe);

        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//input[contains(@ng-model, 'email')]")));
        inputEmail.sendKeys(email);
        sendEmailButton.click();
//        return new GoogleCloudPlatformHomePage(webDriver);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
