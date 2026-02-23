package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.SignupLoginPage;
import utils.JsonDataReader;

public class LoginUserWithIncorrectEmailAndPassword extends BaseTest {

    @Feature("Authentication")
    @Story("Invalid Login")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("KAN-T3")
    @Description("Verify error message is shown when login with invalid credentials")
    @Test
    public void loginUserWithIncorrectEmailAndPassword(){
        HomePage homePage = new HomePage(browser);
        SignupLoginPage signupLoginPage = new SignupLoginPage(browser);
        DeleteAccountPage deleteAccountPage = new DeleteAccountPage(browser);
        String email= JsonDataReader.getData("inValidUser","email");
        String password = JsonDataReader.getData("inValidUser","password");

        Assert.assertTrue(homePage.IsHomePageVisible());
        homePage.ClickOnSignInButton();

        Assert.assertTrue(signupLoginPage.isLoginPageDisplayed());
        signupLoginPage.enterEmailAndPassword(email,password);
        signupLoginPage.clickLoginButton();

        Assert.assertTrue(signupLoginPage.ErrorMessageVisible());

    }
}
