package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class VerifyScrollUpUsingArrowButtonAndScrollDownFunctionalityTest extends BaseTest {

    @Feature("UI")
    @Story("Scroll Using Arrow Button")
    @Severity(SeverityLevel.TRIVIAL)
    @TmsLink("KAN-T25")
    @Description("Verify scroll up using arrow button and scroll down functionality")
    @Test
    public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionalityTest(){

        HomePage homePage=new HomePage(browser);
        Assert.assertTrue(homePage.IsHomePageVisible());
        Assert.assertTrue(homePage.IsSubscribtionTextDisplayed());
        homePage.ClickOnArrowBottom();
        homePage.IsFullFledgedText();




    }
}
