package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.JsonDataReader;

public class RegisterUserWithExistingEmail extends BaseTest {
    @Feature("Authentication")
    @Story("Duplicate Registration")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("KAN-T5")
    @Description("Verify error message is displayed when registering with existing email")
    @Test
    public void registerUserWithExistingEmail() {
        HomePage homePage = new HomePage(browser);
        SignupLoginPage signupLoginPage = new SignupLoginPage(browser);
        String name= JsonDataReader.getData("existingUser", "name");
        String email= JsonDataReader.getData("existingUser", "email");


        Assert.assertTrue(homePage.IsHomePageVisible());
        homePage.ClickOnSignInButton();

        Assert.assertTrue(signupLoginPage.isSignupPageDisplayed());
        signupLoginPage.enterNameAndEmail(name, email);
        signupLoginPage.clickSignupButton();
        Assert.assertTrue(signupLoginPage.isEmailAlreadyExist());


    }
}
