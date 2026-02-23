package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class ViewAndCartBrandProductsTest extends BaseTest {
    @Feature("Brands")
    @Story("View Brand Products")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("KAN-T19")
    @Description("Verify user can view and add brand products to cart")
    @Test
    public void viewAndCartBrandProductsTest() {
        HomePage homePage=new HomePage(browser);
        ProductsPage productsPage=new ProductsPage(browser);
        homePage.clickOnProductButton();
        Assert.assertTrue(productsPage.IsBrandTextDisplayed());
        productsPage.ClickOnPoloBrandButton();
        Assert.assertTrue(productsPage.IsPoloBrandProductsDisplayed());
        Assert.assertTrue(productsPage.IsBrand_PoloProductsTextDisplayed());
        productsPage.ClickOnHAndMBrandButton();
        Assert.assertTrue(productsPage.IsHAndMBrandProductsDisplayed());
        Assert.assertTrue(productsPage.IsBrand_HAndMProductsTextDisplayed());


    }
}
