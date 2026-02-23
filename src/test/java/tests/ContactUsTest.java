package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utils.JsonDataReader;

public class ContactUsTest extends BaseTest {

    @Feature("Contact Us")
    @Story("Submit Contact Form")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("KAN-T6")
    @Description("Verify user can submit contact us form successfully")
    @Test
    public void contactUsTest()
    {
        ContactUsPage contactUsPage= new ContactUsPage(browser);
        HomePage homePage= new HomePage(browser);

        contactUsPage.OpenContactUsForm();
        Assert.assertTrue(contactUsPage.isGetInToutchTextDisplayed());
        String name= JsonDataReader.getData("contactUs","name");
        String email= JsonDataReader.getData("contactUs","email");
        String subject= JsonDataReader.getData("contactUs","subject");
        String message= JsonDataReader.getData("contactUs","message");
        String file= JsonDataReader.getData("contactUs","filePath");
        contactUsPage.FillContactUsForm(name,email,subject,message);
        contactUsPage.SubmitButtonClick();
        contactUsPage.AcceptAlert();
        Assert.assertTrue(contactUsPage.isSuccessMessageDisplayed());
        contactUsPage.clickOnHome();
        Assert.assertTrue(homePage.IsHomePageVisible());


    }

}
