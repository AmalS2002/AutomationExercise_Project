package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;
import pages.SignupLoginPage;
import utils.JsonDataReader;

public class SearchProductsAndVerifyCartAfterLoginTest extends BaseTest {

    @Feature("Cart")
    @Story("Cart Persistence After Login")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("KAN-T20")
    @Description("Verify cart retains products after user logs in")
    @Test
    public void searchProductsAndVerifyCartAfterLoginTest(){
        HomePage homePage=new HomePage(browser);
        ProductsPage productsPage=new ProductsPage(browser);
        CartPage cartPage=new CartPage(browser);
        SignupLoginPage signupLoginPage=new SignupLoginPage(browser);
        String productName= JsonDataReader.getData("products","name");
        String email = JsonDataReader.getData("validUser","email");
        String password = JsonDataReader.getData("validUser","password");

        homePage.clickOnProductButton();
        Assert.assertTrue(productsPage.isProductPageDisplayed());
        productsPage.enterProductName(productName);
        productsPage.searchProduct();
        Assert.assertTrue(productsPage.isSearchedProductsTextDisplayed());
        Assert.assertTrue(productsPage.isSearchedProductsDisplayed());
        productsPage.AddAllProductsToCart();
        homePage.ClickOnCartButton();
        Assert.assertTrue(cartPage.IsProductsAddedVisible());
        //login details
        homePage.ClickOnSignInButton();
        Assert.assertTrue(signupLoginPage.isLoginPageDisplayed());
        signupLoginPage.enterEmailAndPassword(email,password);
        signupLoginPage.clickLoginButton();
        Assert.assertTrue(homePage.isLoggedinِِAsUserNameText());
        homePage.ClickOnCartButton();
        Assert.assertTrue(cartPage.IsProductsAddedVisible());


    }
}
