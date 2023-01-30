package com.epam.training.test;

import com.epam.training.page.CalculationResultsPage;
import com.epam.training.page.GoogleCloudPlatformHomepage;
import com.epam.training.page.PricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleCloudPlatformCalculatorTest {

    private WebDriver webDriver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test (description = "First test in test system")
    public void startCalculatorAndFillFormTest() {

        PricingCalculatorPage pricingCalculatorPage =  new GoogleCloudPlatformHomepage(webDriver)
                .openHomePage()
                .activateSearch()
                .navigateToPricingCalculatorPage();
        pricingCalculatorPage.fillPricingCalculatorForm();
        CalculationResultsPage calculationResultsPage = pricingCalculatorPage.openCalculationResultsPage();

        String expectedDataCenterLocation = calculationResultsPage.readDataCenterLocation();
        Assert.assertTrue(expectedDataCenterLocation.contains("Frankfurt"));

        String expectedCommitmentTerm = calculationResultsPage.readCommitmentTerm();
        Assert.assertTrue(expectedCommitmentTerm.contains("1 Year"));

        String expectedProvisioningModel = calculationResultsPage.readProvisioningModel();
        Assert.assertTrue(expectedProvisioningModel.contains("Regular"));

        String expectedMachineType = calculationResultsPage.readMachineType();
        Assert.assertTrue(expectedMachineType.contains("n1-standard-8"));

        String expectedLocalSSD = calculationResultsPage.readLocalSSD();
        Assert.assertTrue(expectedLocalSSD.contains("2x375 G"));

        String expectedTotalCost = calculationResultsPage.readTotalCost();
        Assert.assertTrue(expectedTotalCost.contains("1,081.20"));
    }

    @AfterMethod (alwaysRun = true)
    public  void closeBrowser(){
//        webDriver.quit();
        webDriver = null;
    }
}
