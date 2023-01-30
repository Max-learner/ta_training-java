package com.epam.training.test;

import com.epam.training.page.PastebinHomePage;
import com.epam.training.page.PasteResultsPage;
import com.epam.training.page.RawPastedTextResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastebinOpenAndPasteCodeWithOptionsTest {

    private WebDriver webDriver;
    private String codeToPaste = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String nameToPaste = "how to gain dominance among developers";

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test (description = "Second test in test system")
    public void pastePageOpenAndPasteCodeWithOptionsTest(){

        PasteResultsPage resultsPage = new PastebinHomePage(webDriver)
                .openPasteHomePage()
                .fillPasteFormAndSubmit(codeToPaste, nameToPaste);

        int expectedPasteResultsCount = resultsPage.countPasteResults();
        Assert.assertTrue(expectedPasteResultsCount > 0, "No search results!");

        String expectedPageTitle = resultsPage.readPageTitle();
        Assert.assertTrue(expectedPageTitle.regionMatches(true, 0, nameToPaste, 0, nameToPaste.length()));

        String expectedSyntaxHighlighting = resultsPage.readSyntaxHighlighting();
        Assert.assertTrue(expectedSyntaxHighlighting.regionMatches(true,0, "bash", 0, "bash".length()));

        String expectedCategory = resultsPage.readPasteCategory();
        Assert.assertTrue(expectedCategory.regionMatches(true,2, "source code", 0, "source code".length()));

        RawPastedTextResultPage rawTextResultPage = new PasteResultsPage(webDriver)
                .openRawResultPage();

        String expectedPastedText = rawTextResultPage.readRawTextResults();
        Assert.assertEquals(expectedPastedText, codeToPaste);
    }

    @AfterMethod (alwaysRun = true)
    public  void closeBrowser(){
        webDriver.quit();
        webDriver = null;
    }
}
