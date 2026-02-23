package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionalityTest extends BaseTest {

    @Feature("UI")
    @Story("Scroll Without Arrow Button")
    @Severity(SeverityLevel.TRIVIAL)
    @TmsLink("KAN-T26")
    @Description("Verify scroll up without arrow button and scroll down functionality")
    @Test
    public void verifyScrollUpWithoutArrowButtonAndScrollDownFunctionalityTest() {
        HomePage homePage=new HomePage(browser);
        Assert.assertTrue(homePage.IsHomePageVisible());
        Assert.assertTrue(homePage.IsSubscribtionTextDisplayed());
        homePage.ScrollToTop();
        homePage.IsFullFledgedText();


    }


}
