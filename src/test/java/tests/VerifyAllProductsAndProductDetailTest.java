package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailedPage;
import pages.ProductsPage;

public class VerifyAllProductsAndProductDetailTest extends BaseTest {

    @Feature("Products")
    @Story("View Products")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("KAN-T8")
    @Description("Verify all products page and product details page are displayed correctly")
    @Test
    public void verifyAllProductsAndProductDetailTest(){
        HomePage homePage=new HomePage(browser);
        ProductsPage  productsPage=new ProductsPage(browser);
        ProductDetailedPage productDetailedPage=new ProductDetailedPage(browser);
        Assert.assertTrue(homePage.IsHomePageVisible());
        homePage.clickOnProductButton();
        Assert.assertTrue(productsPage.isSearchedProductsTextDisplayed());
        Assert.assertTrue(productsPage.isProductListVisible());
        productsPage.cliclOnViewProduct();
        Assert.assertTrue(productDetailedPage.isProductNameDisplayed());
        Assert.assertTrue(productDetailedPage.isProductCategoryDisplayed());
        Assert.assertTrue(productDetailedPage.isProductPriceDisplayed());
        Assert.assertTrue(productDetailedPage.isProductAvailabilityDisplayed());
        Assert.assertTrue(productDetailedPage.isProductBrandDisplayed());
        Assert.assertTrue(productDetailedPage.isProductConditionDisplayed());

    }
}
