package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.JsonDataReader;

public class VerifySubscriptionInHomePageTest extends BaseTest {
    @Feature("Subscription")
    @Story("Home Page Subscription")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("KAN-T10")
    @Description("Verify subscription functionality on home page")
    @Test
    public void verifySubscriptionInHomePageTest() {
        HomePage homePage=new HomePage(browser);
        String email= JsonDataReader.getData("SubscriptiHomeEmail","email");
        Assert.assertTrue(homePage.IsHomePageVisible());
        homePage.ScrollDownTillSubscribtion();
        homePage.EnterSubscriptionEmail(email);
        Assert.assertTrue(homePage.isSuccssfullyMessageDisplayed());
    }
}
