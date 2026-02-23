package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.SignupLoginPage;
import utils.JsonDataReader;

public class LogoutUser extends BaseTest {

    @Feature("Authentication")
    @Story("User Logout")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("KAN-T4")
    @Description("Verify user can logout successfully")
    @Test
    public void testLogoutUser() {
        HomePage homePage = new HomePage(browser);
        SignupLoginPage signupLoginPage = new SignupLoginPage(browser);
        DeleteAccountPage deleteAccountPage = new DeleteAccountPage(browser);
        String email= JsonDataReader.getData("logOutUser","email");
        String password = JsonDataReader.getData("logOutUser","password");

        Assert.assertTrue(homePage.IsHomePageVisible());
        homePage.ClickOnSignInButton();

        Assert.assertTrue(signupLoginPage.isLoginPageDisplayed());
        signupLoginPage.enterEmailAndPassword(email,password);
        signupLoginPage.clickLoginButton();

        Assert.assertTrue(homePage.isLoggedinِِAsUserNameText());
        homePage.clickOnLoggedoutButton();
        Assert.assertTrue(signupLoginPage.isLoginPageDisplayed());

    }


}
