package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.JsonDataReader;

public class RegisterUser extends BaseTest {
    @Feature("Authentication")
    @Story("User Registration")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("KAN-T1")
    @Test(description = "Register User")
    public void RegisterUserSuccessfully(){
        HomePage homePage = new HomePage(browser);
        SignupLoginPage signupLoginPage = new SignupLoginPage(browser);
        SignupAccountInformationPage signupAccountInfoPage = new SignupAccountInformationPage(browser);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(browser);
        DeleteAccountPage deleteAccountPage = new DeleteAccountPage(browser);
        String name= JsonDataReader.getData("registerUser","name");
        String email = JsonDataReader.getData("registerUser","email");
        String title = JsonDataReader.getData("registerUser","title");
        String password = JsonDataReader.getData("registerUser","password");
        String day = JsonDataReader.getData("registerUser","day");
        String month = JsonDataReader.getData("registerUser","month");
        String year = JsonDataReader.getData("registerUser","year");
        String firstName = JsonDataReader.getData("registerUser","firstName");
        String lastName = JsonDataReader.getData("registerUser","lastName");
        String companyName = JsonDataReader.getData("registerUser","companyName");
        String address1 = JsonDataReader.getData("registerUser","address1");
        String  address2 = JsonDataReader.getData("registerUser","address2");
        String  country = JsonDataReader.getData("registerUser","country");
        String state = JsonDataReader.getData("registerUser","state");
        String city = JsonDataReader.getData("registerUser","city");
        String zipcode = JsonDataReader.getData("registerUser","zipcode");
        String phone = JsonDataReader.getData("registerUser","phone");




        Assert.assertTrue(homePage.IsHomePageVisible());
        homePage.ClickOnSignInButton();

        Assert.assertTrue(signupLoginPage.isSignupPageDisplayed());
        signupLoginPage.enterNameAndEmail(name,email);
        signupLoginPage.clickSignupButton();

        Assert.assertTrue(signupAccountInfoPage.isAccountInfoTextDisplayed());
        signupAccountInfoPage.sellectTitel(title);
        signupAccountInfoPage.enterPassword(password);
        signupAccountInfoPage.sellectDateOfBirth(day,month,year);
        signupAccountInfoPage.clickOfferCheckbox();
        signupAccountInfoPage.addressInfo(firstName,lastName,companyName,address1,address2,country,state,city,zipcode,phone);
        signupAccountInfoPage.clickCreateAccountButton();

        Assert.assertTrue(accountCreatedPage.isAccountCreatedPageDisplayed());
        accountCreatedPage.ClickContinueButton();

        Assert.assertTrue(homePage.isLoggedinِِAsUserNameText());
        deleteAccountPage.clickDeleteAccountButton();
        Assert.assertTrue(deleteAccountPage.isDeleteAccountTextVisible());
        deleteAccountPage.clickContinueButton();





    }

}
