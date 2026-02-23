package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class SignupLoginPage extends BasePage  {

    //locators of new user//
    private final By newUserSignupText = By.xpath("//div[@class='signup-form']");
    private final By nameSignupField = By.xpath("//input[@data-qa='signup-name']");
    private final By emailSignupField = By.xpath("//input[@data-qa='signup-email']");
    private final By buttonSignup = By.xpath("//button[@data-qa=\"signup-button\"]");
    private final By emailAlreadyExistText= By.xpath("//p[text()='Email Address already exist!']");
    //locators of login account//
    private final By loginText = By.xpath("//h2[text()='Login to your account']");
    private final By loginEmailField = By.xpath("//input[@data-qa='login-email']");
    private final By passwordLoginField = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By ErrorMessageVisible=  By.xpath("//p[text()='Your email or password is incorrect!']");

    //constructor

    public SignupLoginPage(WebDriver browser) {
        super(browser);
    }

    //methods of new user
    @Step("Signup page should be displayed")
    public boolean isSignupPageDisplayed() {
        explicitWait(Duration.ofSeconds(10),newUserSignupText);
        return LocateElement(newUserSignupText).isDisplayed();
    }

    @Step("User enters signup name {string} and email {string}")
    public void enterNameAndEmail(String name, String email){
       sendElement(nameSignupField,name);
       sendElement(emailSignupField,email);

    }

    @Step("User clicks on Signup button")
    public void clickSignupButton(){
        click(buttonSignup);
    }

    @Step("Email already exists message should be visible")
    public boolean isEmailAlreadyExist(){
        return LocateElement(emailAlreadyExistText).isDisplayed();

    }

    //methods of user login
    @Step("Login page should be displayed")
    public boolean isLoginPageDisplayed(){
        return LocateElement(loginText).isDisplayed();
    }


    @Step("User enters login email {string} and password {string}")
    public void enterEmailAndPassword(String email, String password){
        sendElement(loginEmailField, email);
        sendElement(passwordLoginField, password);
    }

    @Step("User clicks on Login button")
    public boolean ErrorMessageVisible()
    {
        return LocateElement(ErrorMessageVisible).isDisplayed();
    }

    @Step("Login error message should be displayed")
    public void clickLoginButton(){
        click(loginButton);
    }


}
