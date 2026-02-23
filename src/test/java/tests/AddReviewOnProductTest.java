package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import utils.JsonDataReader;

public class AddReviewOnProductTest extends BaseTest {

    @Feature("Products")
    @Story("Add Product Review")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("KAN-T21")
    @Description("Verify user can add a review on a product")
    @Test
    public void testAddReviewOnProduct() {
        HomePage homePage=new HomePage(browser);
        ProductsPage productsPage=new ProductsPage(browser);
        String name= JsonDataReader.getData("ReviewProductForm","name");
        String email= JsonDataReader.getData("ReviewProductForm","email");
        String review= JsonDataReader.getData("ReviewProductForm","reviewText");
        homePage.clickOnProductButton();
        Assert.assertTrue(productsPage.IsAllProductsTextDisplayed());
        productsPage.ClickOnviewProductOfTheFiristProduct();
        Assert.assertTrue(productsPage.IsWriteYourReviewTextDisplayed());
        productsPage.EnterNameEmailAndReview(name, email, review);
        Assert.assertTrue(productsPage.IsSuccessMessageDisplayed());
    }

}
