package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class RemoveProductsFromCart extends BaseTest {

    @Feature("Cart")
    @Story("Remove Products")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("KAN-T17")
    @Description("Verify user can remove products from cart")
    @Test
    public void removeProductsFromCartTest(){
        HomePage homePage=new HomePage(browser);
        CartPage cartPage=new CartPage(browser);
        //verify home page
        Assert.assertTrue(homePage.IsHomePageVisible());

        //add product to cart
        homePage.ClickOnAddCartOfProductsButton();
        homePage.ClickOnContinueShoppingButton();
        homePage.ClickOnCartButton();
        // Remove Cart
        cartPage.IsShoppingCartDisplayed();
        cartPage.ClickOn_X_Button();
        Assert.assertTrue(cartPage.IsCartEmptyDisplayed());


    }
}
