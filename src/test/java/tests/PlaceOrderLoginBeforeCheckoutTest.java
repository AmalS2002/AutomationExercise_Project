package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.JsonDataReader;

public class PlaceOrderLoginBeforeCheckoutTest extends BaseTest {

    @Feature("Checkout")
    @Story("Checkout with Login")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("KAN-T16")
    @Description("Verify user can place order after login")
    @Test
    public void placeOrderLoginBeforeCheckoutTest() {
        HomePage homePage=new HomePage(browser);
        ProductsPage productsPage=new ProductsPage(browser);
        CartPage cartPage=new CartPage(browser);
        SignupLoginPage signupLoginPage=new SignupLoginPage(browser);
        DeleteAccountPage deleteAccountPage=new DeleteAccountPage(browser);
        //json data
        String email = JsonDataReader.getData("validUser","email");
        String password = JsonDataReader.getData("validUser","password");
        String comment = JsonDataReader.getData("DiscriptionOfOrder","Comment");
        String NameOfCard= JsonDataReader.getData("Payment","NameOfCard");
        String NumOfCard=JsonDataReader.getData("Payment","NumOfCard");
        String CVC=JsonDataReader.getData("Payment","CVC");
        String ExpiryMonth=JsonDataReader.getData("Payment","ExpiryMonth");
        String ExpiryYear=JsonDataReader.getData("Payment","ExpiryYear");

        //Test steps
        // home page
        Assert.assertTrue(homePage.IsHomePageVisible());
        homePage.ClickOnSignInButton();
        // login
        Assert.assertTrue(signupLoginPage.isLoginPageDisplayed());
        signupLoginPage.enterEmailAndPassword(email,password);
        signupLoginPage.clickLoginButton();
        //verify login
        Assert.assertTrue(homePage.isLoggedinِِAsUserNameText());
        //Add product to cart
        homePage.ClickOnAddCartOfProductsButton();
        homePage.ClickOnContinueShoppingButton();
        //Cart page
        homePage.ClickOnCartButton();
        Assert.assertTrue(cartPage.IsShoppingCartDisplayed());
        cartPage.ClickProceedToCheckoutButton();
        Assert.assertTrue(cartPage.IsAdressDetailsDisplayed());
        Assert.assertTrue(cartPage.IsReviewYourOrderDisplayed());
        cartPage.CommentOfDiscussionandClickPlaceOrder(comment);
        //Payment methods
        cartPage.PaymentMethod(NameOfCard,NumOfCard,CVC,ExpiryMonth,ExpiryYear);
        Assert.assertTrue(cartPage.IsSuccessMessageDisplayed());
        //delete account
//        deleteAccountPage.clickDeleteAccountButton();
//        Assert.assertTrue(deleteAccountPage.isDeleteAccountTextVisible());
//        deleteAccountPage.clickContinueButton();



    }
}
