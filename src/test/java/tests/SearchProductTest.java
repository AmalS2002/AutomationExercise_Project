package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import utils.JsonDataReader;

public class SearchProductTest extends BaseTest {
    @Feature("Products")
    @Story("Search Product")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("KAN-T9")
    @Description("Verify user can search for products")
    @Test
    public void productsTest(){
        HomePage homePage=new HomePage(browser);
        ProductsPage productDetailPage=new ProductsPage(browser);
        String productName= JsonDataReader.getData("products","name");
        //verify home page
        Assert.assertTrue(homePage.IsHomePageVisible());
        homePage.clickOnProductButton();
        Assert.assertTrue(productDetailPage.isProductPageDisplayed());
        productDetailPage.enterProductName(productName);
        productDetailPage.searchProduct();
        Assert.assertTrue(productDetailPage.isSearchedProductsTextDisplayed());
        Assert.assertTrue(productDetailPage.isSearchedProductsDisplayed());
    }


}
