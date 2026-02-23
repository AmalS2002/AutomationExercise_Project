package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

public class ViewCategoryProductsTest extends BaseTest {

    @Feature("Categories")
    @Story("View Category Products")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("KAN-T18")
    @Description("Verify user can view products by category")
    @Test
    public void viewCategoryProductsTest() {
        HomePage homePage=new HomePage(browser);
        ProductsPage productsPage=new ProductsPage(browser);

        Assert.assertTrue(homePage.IsCategoryTextDisplayed());
        homePage.clickOnWomenBotton();
        homePage.clickOnTopsButton();
        Assert.assertTrue(productsPage.IsWomenTopsProductsTextDisplayed());
        productsPage.ClickOnMenButton();
        productsPage.ClickOnTshirtsButton();
        Assert.assertTrue(productsPage.IsMenTshirtsProductsTextDisplayed());



    }
}
