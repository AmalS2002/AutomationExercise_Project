package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.JsonDataReader;

public class VerifyAddressDetailsInCheckoutPageTest extends BaseTest {

    @Feature("Checkout")
    @Story("Verify Address Details")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("KAN-T23")
    @Description("Verify address details are displayed correctly in checkout page")
    @Test
    public void verifyAddressDetailsInCheckoutPageTest() {
        HomePage homePage=new HomePage(browser);
        CartPage cartPage=new CartPage(browser);
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
        //home page
        Assert.assertTrue(homePage.IsHomePageVisible());
        homePage.ClickOnSignInButton();
        // signup page
        Assert.assertTrue(signupLoginPage.isSignupPageDisplayed());
        signupLoginPage.enterNameAndEmail(name,email);
        signupLoginPage.clickSignupButton();
        // account information page
        Assert.assertTrue(signupAccountInfoPage.isAccountInfoTextDisplayed());
        signupAccountInfoPage.sellectTitel(title);
        signupAccountInfoPage.enterPassword(password);
        signupAccountInfoPage.sellectDateOfBirth(day,month,year);
        signupAccountInfoPage.clickOfferCheckbox();
        signupAccountInfoPage.addressInfo(firstName,lastName,companyName,address1,address2,country,state,city,zipcode,phone);
        signupAccountInfoPage.clickCreateAccountButton();
        //create account page
        Assert.assertTrue(accountCreatedPage.isAccountCreatedPageDisplayed());
        accountCreatedPage.ClickContinueButton();
        // home page
        Assert.assertTrue(homePage.isLoggedinِِAsUserNameText());
        homePage.ClickOnAddCartOfProductsButton();
        homePage.ClickOnContinueShoppingButton();
        homePage.ClickOnCartButton();
        Assert.assertTrue(cartPage.IsShoppingCartDisplayed());
        cartPage.ClickProceedToCheckoutButton();
        // verify delivary address
        Assert.assertEquals(cartPage.getDeliveryName(),title+" "+firstName+" "+lastName);
        Assert.assertEquals(cartPage.getDelivaryCompany(),companyName);
        Assert.assertEquals(cartPage.getDeliveryAddress1(),address1);
        Assert.assertEquals(cartPage.getDeliveryAddress2(),address2);
        Assert.assertEquals(cartPage.getDeliveryCountry(),country);
        Assert.assertEquals(cartPage.getDeliveryCityStateZip(),city+" "+state+" "+zipcode);
        Assert.assertEquals(cartPage.getDeliveryPhone(),phone);
        // verify billing address
        Assert.assertEquals(cartPage.getBilingName(),title+" "+firstName+" "+lastName);
        Assert.assertEquals(cartPage.getBilingCompany(),companyName);
        Assert.assertEquals(cartPage.getBilingAddress1(),address1);
        Assert.assertEquals(cartPage.getBilingAddress2(),address2);
        Assert.assertEquals(cartPage.getBilingCountry(),country);
        Assert.assertEquals(cartPage.getBilingCityStateZip(),city+" "+state+" "+zipcode);
        Assert.assertEquals(cartPage.getBilingPhone(),phone);
        // delete account
        deleteAccountPage.clickDeleteAccountButton();
        Assert.assertTrue(deleteAccountPage.isDeleteAccountTextVisible());
        deleteAccountPage.clickContinueButton();



    }
}
