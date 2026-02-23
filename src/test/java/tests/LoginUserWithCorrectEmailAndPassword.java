package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.SignupLoginPage;
import utils.JsonDataReader;

public class LoginUserWithCorrectEmailAndPassword extends BaseTest {
    @Feature("Authentication")
    @Story("User Login")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("KAN-T1")   // Register User
    @Test(description = "Login User with correct email and password")
    public void loginUserWithCorrectEmailAndPassword(){
        HomePage homePage = new HomePage(browser);
        SignupLoginPage signupLoginPage = new SignupLoginPage(browser);
        DeleteAccountPage deleteAccountPage = new DeleteAccountPage(browser);
        String email = JsonDataReader.getData("validUser","email");
        String password = JsonDataReader.getData("validUser","password");

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
