package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SignupAccountInformationPage extends BasePage {
 //locators
                              // Account info
    private final By AccountInfoText= By.xpath("//b[text()=\"Enter Account Information\"]");
    private final By TitelMr= By.id("id_gender1");
    private final By TitelMrs= By.id("id_gender2");
    private final By PasswordField= By.id("password");
    private final By DayDropDown= By.id("days");
    private final By MonthDropDown= By.id("months");
    private final By YearDropDown= By.id("years");
    private final By NwesletterCheckbox= By.id("newsletter");
    private final By OfferCheckbox= By.id("optin");
                             //Address info
    private final By FirstNameLocator= By.id("first_name");
    private final By LastNameLocator= By.id("last_name");
    private final By CompanyNameLocator= By.id("company");
    private final By Address1Locator= By.id("address1");
    private final By Address2Locator= By.id("address2");
    private final By CountrDropDown= By.id("country");
    private final By StateField= By.id("state");
    private final By CityField= By.id("city");
    private final By ZipCodeField= By.id("zipcode");
    private final By PhoneNumberField= By.id("mobile_number");
    private final By CreateAccountButton=By.xpath("//button[@data-qa='create-account']");
    private final By SearchFormLocator=By.xpath("//form[@class='searchform']");

//constructors
    public SignupAccountInformationPage(WebDriver browser) {
            super(browser);
    }

//methods
    @Step("Account Information page should be displayed")
    public boolean isAccountInfoTextDisplayed(){
        explicitWait(Duration.ofSeconds(15),AccountInfoText);
        return LocateElement(AccountInfoText).isDisplayed();
    }

    @Step("User selects title {string}")
    public void sellectTitel(String Title){
        if(Title.equalsIgnoreCase("mr"))
        {
            click(TitelMr);
        }
        else{
            click(TitelMrs);
        }

    }

    @Step("User enters password {string}")
    public void enterPassword(String password){
        sendElement(PasswordField, password);
    }

    @Step("User selects date of birth day {string} month {string} year {string}")
    public void sellectDateOfBirth(String day, String month, String year){
        selectDropdownByValue(DayDropDown,day, Duration.ofSeconds(10));
        selectDropdownByVisibleText(MonthDropDown,month, Duration.ofSeconds(10));
        selectDropdownByValue(YearDropDown,year, Duration.ofSeconds(10));
    }
    @Step("User subscribes to newsletter")
    public void subscribeNewsletter(){
        checkCheckbox(NwesletterCheckbox,Duration.ofSeconds(10));
    }

    @Step("User checks offers option")
    public void clickOfferCheckbox(){
        checkCheckbox(OfferCheckbox,Duration.ofSeconds(10));
    }

    @Step("User enters address information")
    public void addressInfo(String firstName, String lastName, String companyName, String address1, String address2, String country, String state, String city, String zipcode, String phoneNumber){
        sendElement(FirstNameLocator,firstName);
        sendElement(LastNameLocator,lastName);
        sendElement(CompanyNameLocator,companyName);
        sendElement(Address1Locator,address1);
        sendElement(Address2Locator,address2);
        selectDropdownByVisibleText(CountrDropDown,country,Duration.ofSeconds(10));
        sendElement(StateField,state);
        sendElement(CityField,city);
        sendElement(ZipCodeField,zipcode);
        sendElement(PhoneNumberField,phoneNumber);
    }

    @Step("User clicks on Create Account button")
    public void clickCreateAccountButton(){

        scrollToElement(SearchFormLocator,Duration.ofSeconds(15));
        browser.findElement(CreateAccountButton).click();
    }









}
