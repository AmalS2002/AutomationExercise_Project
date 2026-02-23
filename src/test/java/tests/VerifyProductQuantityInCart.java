package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class VerifyProductQuantityInCart extends BaseTest {
    @Feature("Cart")
    @Story("Update Product Quantity")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("KAN-T13")
    @Description("Verify product quantity is updated correctly in cart")
    @Test
    public void VerifyProductQuantityInCartDisplayed(){
        HomePage homePage=new HomePage(browser);
        ProductsPage productsPage=new ProductsPage(browser);
        CartPage cartPage=new CartPage(browser);
        Assert.assertTrue(homePage.IsHomePageVisible());
        homePage.clickOnFirstProductAtHomePage();
        Assert.assertTrue(productsPage.VerifySellectedProductDetailsDisplayed());
        productsPage.IncreaseOfQuantityField();
        productsPage.ClickOnAddCartButton();
        productsPage.ClickOnViewCartButton();
        Assert.assertTrue(cartPage.IsOurSellectedProductDetailsDisplayed());
        Assert.assertTrue(cartPage.IsQuantityDisplayed());

    }
}
