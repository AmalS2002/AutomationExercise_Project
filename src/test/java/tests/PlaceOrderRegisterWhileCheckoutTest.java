package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.JsonDataReader;

public class PlaceOrderRegisterWhileCheckoutTest extends BaseTest {


    @Feature("Checkout")
    @Story("Checkout with Registration")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("KAN-T14")
    @Description("Verify user can place order by registering during checkout")
    @Test
    public void placeOrderRegisterWhileCheckout(){
        HomePage homePage=new HomePage(browser);
        CartPage cartPage=new CartPage(browser);
        SignupLoginPage signupLoginPage=new SignupLoginPage(browser);
        SignupAccountInformationPage signupAccountInfoPage=new SignupAccountInformationPage(browser);
        AccountCreatedPage accountCreatedPage=new AccountCreatedPage(browser);
        DeleteAccountPage deleteAccountPage=new DeleteAccountPage(browser);

        //json data
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
        String comment = JsonDataReader.getData("DiscriptionOfOrder","Comment");
        String NameOfCard= JsonDataReader.getData("Payment","NameOfCard");
        String NumOfCard=JsonDataReader.getData("Payment","NumOfCard");
        String CVC=JsonDataReader.getData("Payment","CVC");
        String ExpiryMonth=JsonDataReader.getData("Payment","ExpiryMonth");
        String ExpiryYear=JsonDataReader.getData("Payment","ExpiryYear");


        //verify home page
        Assert.assertTrue(homePage.IsHomePageVisible());
        //Add product to cart
        homePage.ClickOnAddCartOfProductsButton();
        homePage.ClickOnContinueShoppingButton();
        //Go to Cart
        homePage.ClickOnCartButton();
        Assert.assertTrue(cartPage.IsShoppingCartDisplayed());
        //Checkout
        cartPage.ClickProceedToCheckoutButton();
        //Go to Create Account
        cartPage.ClickRegisterOrLoginButton();
        Assert.assertTrue(signupLoginPage.isSignupPageDisplayed());
        signupLoginPage.enterNameAndEmail(name,email);
        signupLoginPage.clickSignupButton();
        //Account information
        Assert.assertTrue(signupAccountInfoPage.isAccountInfoTextDisplayed());
        signupAccountInfoPage.sellectTitel(title);
        signupAccountInfoPage.enterPassword(password);
        signupAccountInfoPage.sellectDateOfBirth(day,month,year);
        signupAccountInfoPage.clickOfferCheckbox();
        signupAccountInfoPage.addressInfo(firstName,lastName,companyName,address1,address2,country,state,city,zipcode,phone);
        signupAccountInfoPage.clickCreateAccountButton();
        // Account created
        Assert.assertTrue(accountCreatedPage.isAccountCreatedPageDisplayed());
        accountCreatedPage.ClickContinueButton();
        // ids logged in as username visible
        Assert.assertTrue(homePage.isLoggedinِِAsUserNameText());
        //Cart page
        homePage.ClickOnCartButton();
        cartPage.ClickProceedToCheckoutButton();
        Assert.assertTrue(cartPage.IsAdressDetailsDisplayed());
        Assert.assertTrue(cartPage.IsReviewYourOrderDisplayed());
        cartPage.CommentOfDiscussionandClickPlaceOrder(comment);
        //Payment methods
        cartPage.PaymentMethod(NameOfCard,NumOfCard,CVC,ExpiryMonth,ExpiryYear);
        Assert.assertTrue(cartPage.IsSuccessMessageDisplayed());
        deleteAccountPage.clickDeleteAccountButton();
        Assert.assertTrue(deleteAccountPage.isDeleteAccountTextVisible());
        deleteAccountPage.clickContinueButton();








    }
}
