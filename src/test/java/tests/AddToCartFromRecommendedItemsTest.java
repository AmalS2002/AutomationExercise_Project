package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class AddToCartFromRecommendedItemsTest extends BaseTest {

    @Feature("Cart")
    @Story("Add Recommended Items")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("KAN-T22")
    @Description("Verify user can add recommended items to cart")

    @Test(description = "Add to cart from Recommended items")
    public void addToCartFromRecommendedItemsTest(){
        HomePage homePage=new HomePage(browser);
        CartPage cartPage=new CartPage(browser);
        Assert.assertTrue(homePage.IsRecommendedItemsDisplayed());
        homePage.clickOnProductOfRecommendedItems();
        Assert.assertTrue(cartPage.IsSellectedItemVisible());
    }
}
