package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {
    private final By CreatedAccountText= By.xpath("//h2[b='Account Created!']");
    private final By ContinueButton= By.xpath("//a[@data-qa='continue-button']");

    public AccountCreatedPage(WebDriver browser){
        super(browser);
    }

    @Step("Verify that Account Created page is displayed")
    public boolean isAccountCreatedPageDisplayed(){
        return browser.findElement(CreatedAccountText).isDisplayed();
    }
    @Step("Click on Continue button in Account Created page")
    public void ClickContinueButton(){
        browser.findElement(ContinueButton).click();
    }

}
