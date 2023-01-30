package com.epam.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class EmailServicePage {

    private static final String HOMEPAGE_URL = "https://yopmail.com/email-generator";
    private String recepientEmailAddress = "zemautraummudei-6596@yopmail.com";
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    private WebDriver webDriver;

    @FindBy(xpath = "//button[@onclick='egengo();']")
    private WebElement checkInboxButton;
    @FindBy(xpath = "//div[@class='bname']")
    private WebElement emailAddress;
    @FindBy(xpath = "//button[@id='refresh']")
    private WebElement refreshButton;
    @FindBy(xpath = "//button[@id='newmail']")
    private WebElement writeNewMessageButton;
    @FindBy(xpath = "//input[@id='msgto']")
    private WebElement recepientMailAddressInput;
    @FindBy(xpath = "//input[@id='msgsubject']")
    private WebElement messageSubjectInput;
    @FindBy(xpath = "//div[@id='msgbody']")
    private WebElement messageTextInput;
    @FindBy(xpath = "//button[@id='msgsend']")
    private WebElement sendNewMessageButton;
    @FindBy(xpath = "//div[@id='mail']/div")
    private WebElement receivedMessageTextArea;
    @FindBy(xpath = "//div[@id='mail']/div//h3[contains(text(), 'USD')]")
    private WebElement receivedEstimatedTotalCost;

    public EmailServicePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openInbox(){
        webDriver.get(HOMEPAGE_URL);
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//button[@onclick='egengo();']")));
        checkInboxButton.click();
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//button[@id='newmail']")));
    }
    public void writeAndSendNewMessage(){
        writeNewMessageButton.click();
        WebElement ifmail = webDriver.findElement(By.id("ifmail"));
        webDriver.switchTo().frame(ifmail);
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//input")));
        recepientMailAddressInput.sendKeys(recepientEmailAddress);
        messageSubjectInput.sendKeys("some subject");
        messageTextInput.sendKeys("text to paste");
        sendNewMessageButton.click();
    }
    public void setRecepientEmailAddress(String recepientEmailAddress) {
        this.recepientEmailAddress = recepientEmailAddress;
    }

    public String getEmail(){
        return emailAddress.getText();
    }
    public void refreshInbox() throws InterruptedException {
        List<WebElement> searchResult = webDriver
                .findElements(By.xpath("//button[@onclick='g(this);']"));

        while (searchResult.isEmpty()){
            Thread.sleep(1000);
            refreshButton.click();
            new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions
                            .frameToBeAvailableAndSwitchToIt(By.id("ifinbox")));
           searchResult = webDriver
                    .findElements(By.xpath("//button[@onclick='g(this);']"));
           Thread.sleep(1000);
           webDriver.switchTo().defaultContent();
        }
        System.out.println(searchResult.size());
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//iframe[@id='ifmail']")));
    }
    public String getReceivedMessageText(){
        WebElement ifmail = webDriver.findElement(By.xpath("//iframe[@id='ifmail']"));
        webDriver.switchTo().frame(ifmail);
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//div[@id='mail']/div")));
        String receivedText = receivedMessageTextArea.getText();
        webDriver.switchTo().defaultContent();
        return receivedText;
    }
    public String getReceivedEstimatedTotalCost(){
        WebElement ifmail = webDriver.findElement(By.xpath("//iframe[@id='ifmail']"));
        webDriver.switchTo().frame(ifmail);
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//div[@id='mail']/div")));
        String receivedCost = receivedEstimatedTotalCost.getText();
        webDriver.switchTo().defaultContent();
        return receivedCost;
    }
}
