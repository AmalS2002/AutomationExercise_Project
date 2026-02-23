package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;

public class VerifyTestCasesTest extends BaseTest {

    @Feature("Static Pages")
    @Story("Test Cases Page")
    @Severity(SeverityLevel.TRIVIAL)
    @TmsLink("KAN-T7")
    @Description("Verify test cases page is accessible and displayed correctly")
    @Test
    public void testCasesTest() {
        HomePage homePage=new HomePage(browser);
        TestCasesPage testCasesPage=new TestCasesPage(browser);
        Assert.assertTrue(homePage.IsHomePageVisible());
        testCasesPage.TestCasesButtonClick();
        Assert.assertTrue(testCasesPage.TestCasesTextIsDisplayed());


    }


}
