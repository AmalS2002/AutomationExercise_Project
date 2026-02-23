package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CartPage extends BasePage {

    private final By SubscribtionText=By.xpath("//h2[text()='Subscription']");
    private final By emailField=By.xpath("//input[@type='email']");
    private final By ArrowButton=By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
    private final By SucessMessageLocator=By.xpath("//div[@class='alert-success alert']");
    private final By cartPageTitle=By.xpath("//li[text()='Shopping Cart']");
    private final By cartProducts=By.xpath("(//tr[contains(@id,'product')])[1]");
    private final By OurSellectProductLocator=By.xpath("//a[@href='/product_details/1']");
    private final By QuantityLocator=By.xpath("//button[@class='disabled']");
    //test case 14/15/16
    private final By ShoppingCartTextLocator=By.xpath("//li[@class='active']");
    private final By ProceedToCheckoutButtonLocator=By.xpath("//a[@class='btn btn-default check_out']");
    private final By RegisterOrLoginButtonLocaror=By.xpath("//a[u='Register / Login']");
    private final By AdressDetailsTextLocator=By.xpath("//h2[text()='Address Details']");
    private final By ReviewYourOrderLocator=By.xpath("//h2[text()='Review Your Order']");
    private final By TextAreaLocator=By.xpath("//textarea[@class='form-control']");
    private final By PlaceOrderButtonLocator=By.xpath("//a[text()='Place Order']");
    private final By NameOnCardTextLocator=By.xpath("//input[@name='name_on_card']");
    private final By NumberOfCardsTextLocator=By.xpath("//input[@name='card_number']");
    private final By CVCTextLocator=By.xpath("//input[@name='cvc']");
    private final By ExpirationMonthTextLocator=By.xpath("//input[@name='expiry_month']");
    private final By ExpirationYearTextLocator=By.xpath("//input[@name='expiry_year']");
    private final By PayAndConfirmButtonLocator=By.xpath("//button[@class='form-control btn btn-primary submit-button']");
    private final By SuccessMessageForOrderLocator=By.xpath("//p[@style='font-size: 20px; font-family: garamond;']");
    // test case 17
    private final By X_ButtonLocator=By.xpath("//i[@class='fa fa-times']");
    private final By CartIsEmptyLocator=By.xpath("//b[text()='Cart is empty!']");
    //test case 20
    private final By ItemAddedToCartLocator=By.xpath("//td[@class='image']");
    //test case 22
    private final By SellectedItemLocator=By.xpath("(//tr[@class='cart_menu'])");
    // test case 23
    private final By YourDeliveryAdressTextLocator=By.xpath("//h3[text()='Your delivery address']");
    private final By deliveryNameLocator=By.xpath("//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']");
    private final By delivaryCompanyLocator=By.xpath("//ul[@id='address_delivery']//li[text()='validation']");
    private final By delivaryAddress1Locator=By.xpath("//ul[@id='address_delivery']//li[text()='Nasr City']");
    private final By delivaryAddress2Locator=By.xpath("//ul[@id='address_delivery']//li[text()='Giza']");
    private final By delivarycityStateZipCodeLocator=By.xpath("//ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']");
    private final By delivaryCountryLocator=By.xpath("//ul[@id='address_delivery']//li[@class='address_country_name']");
    private final By delivaryPhoneLocator=By.xpath("//ul[@id='address_delivery']//li[@class='address_phone']");

    private final By YourbillingAdressTextLocator=By.xpath("//h3[text()='Your billing address']");
    private final By billingNameLocator=By.xpath("//ul[@id='address_invoice']//li[@class='address_firstname address_lastname']");
    private final By billingCompanyLocator=By.xpath("//ul[@id='address_invoice']//li[text()='validation']");
    private final By billingAddress1Locator=By.xpath("//ul[@id='address_invoice']//li[text()='Nasr City']");
    private final By billingAddress2Locator=By.xpath("//ul[@id='address_invoice']//li[text()='Giza']");
    private final By billingcityStateZipCodeLocator=By.xpath("//ul[@id='address_invoice']//li[@class='address_city address_state_name address_postcode']");
    private final By billingCountryLocator=By.xpath("//ul[@id='address_invoice']//li[@class='address_country_name']");
    private final By billingPhoneLocator=By.xpath("//ul[@id='address_invoice']//li[@class='address_phone']");



    public CartPage(WebDriver browser) {
        super(browser);
    }

    @Step("Scroll to footer of Cart page")
    public void ScrollToFooter(){
        scrollToBottom();
    }

    @Step("Verify subscription section is displayed")
    public boolean isSubscriptionDisplayed()
    {
        return LocateElement(SubscribtionText).isDisplayed();
    }

    @Step("Enter email: {email} in subscription field")
    public void enterEmail(String email)
    {
        sendElement(emailField, email);
    }

    @Step("Click on subscription submit button")
    public void clickOnSubmitButton()
    {
        click(ArrowButton);
    }

    @Step("Verify subscription success message is displayed")
    public boolean isSuccessMessageDisplayed() {
        return LocateElement(SucessMessageLocator).isDisplayed();
    }

    @Step("Verify Cart page title is displayed")
    public boolean CartPageTitleIsDisplayed(){
        explicitWait(Duration.ofSeconds(15),cartPageTitle);
        return LocateElement(cartPageTitle).isDisplayed();
    }

    @Step("Verify products are displayed in cart")
    public boolean CartProductsIsDisplayed(){
        explicitWait(Duration.ofSeconds(15),cartProducts);
        return findAll(cartProducts).isEmpty();
    }
    //test case13
    @Step("Verify our selected product is displayed")
    public boolean IsOurSellectedProductDetailsDisplayed(){
        return LocateElement(OurSellectProductLocator).isDisplayed();
    }

    @Step("Verify quantity is displayed")
    public boolean IsQuantityDisplayed(){
        explicitWait(Duration.ofSeconds(10),QuantityLocator);
        return LocateElement(QuantityLocator).isDisplayed();
    }
    // test case 14

    @Step("Verify shopping cart text is displayed")
    public boolean IsShoppingCartDisplayed(){
        return LocateElement(ShoppingCartTextLocator).isDisplayed();
    }

    @Step("Click Proceed To Checkout button")
    public void ClickProceedToCheckoutButton(){
        explicitWait(Duration.ofSeconds(20),ProceedToCheckoutButtonLocator);
        click(ProceedToCheckoutButtonLocator);
    }

    @Step("Click Register or Login button")
    public void ClickRegisterOrLoginButton(){
        click(RegisterOrLoginButtonLocaror);
    }

    @Step("Verify Address Details section is displayed")
    public boolean IsAdressDetailsDisplayed(){
        return LocateElement(AdressDetailsTextLocator).isDisplayed();
    }

    @Step("Verify Review Your Order section is displayed")
    public boolean IsReviewYourOrderDisplayed(){
        return LocateElement(ReviewYourOrderLocator).isDisplayed();
    }

    @Step("Enter comment and click Place Order")
    public void CommentOfDiscussionandClickPlaceOrder(String comment){
        sendElement(TextAreaLocator, comment);
        click(PlaceOrderButtonLocator);
        explicitWait(Duration.ofSeconds(10),NameOnCardTextLocator);
    }
    @Step("Enter payment details and confirm order")
    public void PaymentMethod(String NameOfCard,String NumOfCard,String CVC,String ExpiryMonth,String ExpiryYear){
        scrollToBottom();
        sendElement(NameOnCardTextLocator,NameOfCard);
        sendElement(NumberOfCardsTextLocator,NumOfCard);
        sendElement(CVCTextLocator,CVC);
        scrollToElement(PayAndConfirmButtonLocator,Duration.ofSeconds(10));
        sendElement(ExpirationMonthTextLocator,ExpiryMonth);
        sendElement(ExpirationYearTextLocator,ExpiryYear);
        explicitWait(Duration.ofSeconds(10),PayAndConfirmButtonLocator);
        click(PayAndConfirmButtonLocator);
    }

    @Step("Verify order success message is displayed")
    public boolean IsSuccessMessageDisplayed(){
        explicitWait(Duration.ofSeconds(10),SuccessMessageForOrderLocator);
        return LocateElement(SuccessMessageForOrderLocator).isDisplayed();
    }
    //test case 17
    @Step("Remove product from cart")
    public void ClickOn_X_Button(){
        click(X_ButtonLocator);
    }

    @Step("Verify cart is empty")
    public boolean IsCartEmptyDisplayed(){
        explicitWait(Duration.ofSeconds(15),CartIsEmptyLocator);
        return LocateElement(CartIsEmptyLocator).isDisplayed();
    }
    //test case 20
    @Step("Verify visibility of product")
    public boolean IsProductsAddedVisible(){
       return LocateElement(ItemAddedToCartLocator).isDisplayed();
    }
    // test case 22
    @Step("Verify visibility of selected item")
    public boolean IsSellectedItemVisible(){
        explicitWait(Duration.ofSeconds(15),SellectedItemLocator);
        return LocateElement(SellectedItemLocator).isDisplayed();
    }
    // test case 23
    @Step("Verify delivery address section is displayed")
    public boolean IsYourDelivaryAdressDisplayed(){
        return LocateElement(YourDeliveryAdressTextLocator).isDisplayed();
    }
    @Step("Get delivery name")
    public String getDeliveryName() {
        return LocateElement(deliveryNameLocator).getText();
    }

    @Step("Get delivery company")
    public String getDelivaryCompany(){
        return LocateElement(delivaryCompanyLocator).getText();
    }

    @Step("Get delivery address1")
    public String getDeliveryAddress1() {
        return LocateElement(delivaryAddress1Locator).getText();
    }

    @Step("Get delivery address2")
    public String getDeliveryAddress2() {
        return LocateElement(delivaryAddress2Locator).getText();
    }

    @Step("Get delivery state & zip")
    public String getDeliveryCityStateZip() {
        return LocateElement(delivarycityStateZipCodeLocator).getText();
    }

    @Step("Get delivery country")
    public String getDeliveryCountry() {
        return LocateElement(delivaryCountryLocator).getText();
    }

    @Step("Get delivery phone")
    public String getDeliveryPhone() {
        return LocateElement(delivaryPhoneLocator).getText();
    }
    //Billing
    @Step("Verify billing address section is displayed")
    public boolean IsYourBilingAdressDisplayed(){
        return LocateElement(YourbillingAdressTextLocator).isDisplayed();
    }

    @Step("Get billing name")
    public String getBilingName() {
        return LocateElement(billingNameLocator).getText();
    }

    @Step("Get billing company")
    public String getBilingCompany(){
        return LocateElement(billingCompanyLocator).getText();
    }

    @Step("Get billing address1")
    public String getBilingAddress1() {
        return LocateElement(billingAddress1Locator).getText();
    }

    @Step("Get billing address2")
    public String getBilingAddress2() {
        return LocateElement(billingAddress2Locator).getText();
    }

    @Step("Get billing city & zip")
    public String getBilingCityStateZip() {
        return LocateElement(billingcityStateZipCodeLocator).getText();
    }

    @Step("Get billing country")
    public String getBilingCountry() {
        return LocateElement(billingCountryLocator).getText();
    }

    @Step("Get billing phone")
    public String getBilingPhone() {
        return LocateElement(billingPhoneLocator).getText();
    }


}
