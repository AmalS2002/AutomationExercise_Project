package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import utils.JsonDataReader;

public class VerifySubscriptionInCartPageTest extends BaseTest {
    @Feature("Subscription")
    @Story("Cart Page Subscription")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("KAN-T11")
    @Description("Verify subscription functionality on cart page")
    @Test
  public void VerifySubscriptionInCartPage() {
      HomePage homePage=new HomePage(browser);
      CartPage cartPage=new CartPage(browser);
      String email= JsonDataReader.getData("SubscriptiCartEmail","email");
      Assert.assertTrue(homePage.IsHomePageVisible());
      homePage.clickOnCartButtonAtTheEndOfPage();
      cartPage.ScrollToFooter();
      Assert.assertTrue(cartPage.isSubscriptionDisplayed());
      cartPage.enterEmail(email);
      cartPage.clickOnSubmitButton();
      Assert.assertTrue(cartPage.isSuccessMessageDisplayed());
  }

}
