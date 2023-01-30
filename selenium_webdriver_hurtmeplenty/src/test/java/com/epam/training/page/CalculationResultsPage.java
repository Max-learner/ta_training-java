package com.epam.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CalculationResultsPage {
    private WebDriver webDriver;
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    @FindBy(xpath = "//md-content[@ng-if='cloudCartCtrl.showComputeItems']//div[contains(text(),'Region:')]")
    private WebElement dataCenterLocation;
    @FindBy(xpath = "//md-content[@ng-if='cloudCartCtrl.showComputeItems']//div[contains(text(),'Commitment')]")
    private WebElement commitmentTerm;
    @FindBy(xpath = "//md-content[@ng-if='cloudCartCtrl.showComputeItems']//div[contains(text(),'Provisioning')]")
    private WebElement provisioningModel;
    @FindBy(xpath = "//md-content[@ng-if='cloudCartCtrl.showComputeItems']//div[contains(text(),'Instance')]")
    private WebElement machineType;
    @FindBy(xpath = "//md-content[@ng-if='cloudCartCtrl.showComputeItems']//div[contains(text(),'SSD')]")
    private WebElement localSSD;
    @FindBy(xpath = "//div[@class='cpc-cart-total']//b[contains(text(), 'Total Estimated Cost')]")
    private WebElement totalCost;
    public CalculationResultsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String readDataCenterLocation(){
        return dataCenterLocation.getText();
    }
    public String readCommitmentTerm(){
        return commitmentTerm.getText();
    }
    public String readProvisioningModel(){
        return provisioningModel.getText();
    }
    public String readMachineType(){
        return machineType.getText();
    }
    public String readLocalSSD(){
        return localSSD.getText();
    }
    public String readTotalCost(){
        return totalCost.getText();
    }
}
