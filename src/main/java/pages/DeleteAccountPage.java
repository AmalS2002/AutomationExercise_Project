package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DeleteAccountPage extends BasePage {
    private final By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private final By deleteAccountText= By.xpath("//b[text()='Account Deleted!']");
    private final By continueButton= By.xpath("//a[@data-qa='continue-button']");
    //constructor
    public DeleteAccountPage(WebDriver browser) {
        super(browser);
    }
    //method
    @Step("Click on Delete Account button")
    public void clickDeleteAccountButton(){
        click(deleteAccountButton);
    }

    @Step("Verify 'Account Deleted!' message is displayed")
    public boolean isDeleteAccountTextVisible(){
        return browser.findElement(deleteAccountText).isDisplayed();
    }

    @Step("Click Continue button after deleting account")
    public void clickContinueButton(){
        click(continueButton);
    }


}
