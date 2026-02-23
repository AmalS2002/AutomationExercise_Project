package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {
    private final By ContactUsText= By.cssSelector("a[href='/contact_us']");
    private final By GetInTouchText=By.xpath("//h2[text()='Get In Touch']");
    private final By NameField=By.xpath("//input[@name='name']");
    private final By EmailField=By.xpath("//input[@name='email']");
    private final By SubjectField=By.xpath("//input[@name='subject']");
    private final By MessageField=By.id("message");
    private final By UploadFileField=By.xpath("//input[@name='upload_file']");
    private final By SubmitButton=By.xpath("//input[@name='submit']");
    private final By VerifySuccessMessage=By.xpath("//div[@class='status alert alert-success']");
    private final By ClickOnHome=By.xpath("//i[@class='fa fa-angle-double-left']");
    private final By VerifyHomePage=By.xpath("//i[@class='fa fa-home']");

    public ContactUsPage(WebDriver browser) {
        super(browser);
    }

    @Step("Open Contact Us page")
    public void OpenContactUsForm() {
        click(ContactUsText);
    }

    @Step("Verify 'Get In Touch' text is displayed")
    public boolean isGetInToutchTextDisplayed(){
        return LocateElement(GetInTouchText).isDisplayed();
    }

    @Step("Fill Contact Us form with name: {name}, email: {email}, subject: {subject}")
    public void FillContactUsForm(String name, String email, String subject, String message) {
        sendElement(NameField, name);
        sendElement(EmailField, email);
        sendElement(SubjectField, subject);
        sendElement(MessageField, message);
    }

    @Step("Click Submit button on Contact Us form")
    public void SubmitButtonClick(){
        click(SubmitButton);
    }

    @Step("Accept alert popup")
    public void AcceptAlert(){
        acceptAlert();
    }

    @Step("Verify success message is displayed")
    public boolean isSuccessMessageDisplayed(){
        return LocateElement(VerifySuccessMessage).isDisplayed();
    }

    @Step("Click on Home button")
    public void clickOnHome(){
        click(ClickOnHome);
    }

}
