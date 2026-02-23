package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class AddProductsInCart extends BaseTest {

    @Feature("Cart")
    @Story("Add Products to Cart")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("KAN-T12")
    @Description("Verify user can add products to cart")
    @Test
    public void addProductsInCart() {

        HomePage homePage = new HomePage(browser);
        CartPage cartPage = new CartPage(browser);
        ProductsPage productsPage = new ProductsPage(browser);
        Assert.assertTrue(homePage.IsHomePageVisible());
        homePage.clickOnProductButton();
        productsPage.HoverOnFirstPictureAndClickOnAddCartButtonAndContiueShopping();
        productsPage.HoverOnSecondPictureAndClickOnAddCartButton();
        Assert.assertTrue(cartPage.CartPageTitleIsDisplayed());
        Assert.assertFalse(cartPage.CartProductsIsDisplayed());
    }


}
