package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest   {


    @Feature("Static Pages")
    @Story("Home Page")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("KAN-T27")
    @Description("Verify user can open home page")
    @Test
    public void TestHomePage() {
        HomePage homePage = new HomePage(browser);
        String ExpectedUrl ="https://automationexercise.com";
        Assert.assertTrue(browser.getCurrentUrl().contains(ExpectedUrl)

        );

    }



}
