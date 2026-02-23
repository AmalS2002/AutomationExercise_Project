package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage extends BasePage {
    // Locators
    private final By homePageLocator = By.xpath("//a[contains(text(),' Home')]");
    private final By logedinAsUserLocator = By.xpath("//a[contains(text(),' Logged in as ')]");
    private final By logoutTextLocator= By.xpath("//a[text()=' Logout']  ");
    private final By SignOrlogedinButtonLocator = By.xpath("//i[@class='fa fa-lock']");
    private final By producstButtonLocator=By.cssSelector("a[href=\"/products\"]");
    private final By SubscriptionTextLocator=By.xpath("//h2[text()='Subscription']");
    private final By susbscribeEmailFieldLocator=By.id("susbscribe_email");
    private final By ButtonSubscribtionHomeLocator=By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
    private final By SuccssfullyMessageLocator=By.xpath("//div[@class='alert-success alert']");
    private final By CartArrowButtonLocator=By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
    private final By FirstProductAtHomePageLocator=By.xpath("//a[@href='/product_details/1']");
    //test 14/15/16/17
    private final By FirstPhotoHover=By.xpath("(//div[@class='product-image-wrapper'])[1]");
    private final By AddCartOfFirstProductButtonLocator=By.xpath("(//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart'])[1]");
    private final By CartButtonLocator=By.xpath("//a[normalize-space()='Cart']");
    private final By ContinueShoppingButtonLocator=By.xpath("//button[contains(text(),'Continue Shopping')]");
    private final By FourthPhotoLocator=By.xpath("//img[@src=\"/get_product_picture/4\"]");
    // test case 18
    private final By CategoryTextLocator=By.xpath("//h2[text()='Category']");
    private final By WomenBottonLocator=By.xpath("//a[@href='#Women']");
    private final By TopsButtonLocator=By.xpath("//a[@href='/category_products/2']");
    //test case 22
    private final By RecommendedItemsTextLocator=By.xpath("//h2[text()='recommended items']");
    private final By ProductOfRecommendedItemLocator=By.xpath("(//a[contains(@class,'add-to-cart')])[72]");
    private final By ViewCartButtonLocator=By.xpath("(//u[text()='View Cart'])");
    // test case 25
    private final By ArrowBottomLocator=By.xpath("//i[@class='fa fa-angle-up']");
    private final By Full_FledgedText=By.xpath("(//div[@class='carousel-inner']//h2[text()='Full-Fledged practice website for Automation Engineers'])[2]");




    protected WebDriver driver;
    //Constructors
    public HomePage(WebDriver browser) {
        super(browser);
    }

    @Step("Verify Home page is visible")
    public boolean IsHomePageVisible() {
        implicitWait(Duration.ofSeconds(10));
        return LocateElement(homePageLocator).isDisplayed();
    }

    @Step("Click on Signup / Login button")
    public void ClickOnSignInButton() {
        explicitWait(Duration.ofSeconds(10),SignOrlogedinButtonLocator);
        click(SignOrlogedinButtonLocator);
        implicitWait(Duration.ofSeconds(15));
    }

    @Step("Verify user is logged in successfully")
    public boolean isLoggedinِِAsUserNameText() {
        return LocateElement(logedinAsUserLocator).isDisplayed();
    }

    @Step("Click on Logout button")
    public void clickOnLoggedoutButton() {
        click(logoutTextLocator);
    }

    @Step("Click on Products button")
    public void clickOnProductButton() {
        explicitWait(Duration.ofSeconds(10),producstButtonLocator);
        click(producstButtonLocator);
    }

    @Step("Scroll down till Subscription section")
    public void ScrollDownTillSubscribtion() {
        scrollToElement(SubscriptionTextLocator, Duration.ofSeconds(15));
    }

    @Step("Enter subscription email: {email}")
    public void EnterSubscriptionEmail(String email) {
        sendElement(susbscribeEmailFieldLocator, email);
        click(ButtonSubscribtionHomeLocator);
    }

    @Step("Verify subscription success message is displayed")
    public boolean isSuccssfullyMessageDisplayed() {
        return LocateElement(SuccssfullyMessageLocator).isDisplayed();
    }

    @Step("Click on Cart button at bottom of page")
    public void clickOnCartButtonAtTheEndOfPage() {
        click(CartArrowButtonLocator);
    }

    //test case13
    @Step("Click on first product from Home page")
    public void clickOnFirstProductAtHomePage() {
        hoverOver(FirstProductAtHomePageLocator);
        explicitWait(Duration.ofSeconds(10),FirstProductAtHomePageLocator);
        click(FirstProductAtHomePageLocator);

    }
    //test case 14/15/16/17
    @Step("Add first product to cart from Home page")
    public void ClickOnAddCartOfProductsButton(){
        hoverOver(FirstPhotoHover);
        explicitWait(Duration.ofSeconds(15), AddCartOfFirstProductButtonLocator);
        click(AddCartOfFirstProductButtonLocator);
    }

    @Step("Click on Continue Shopping button")
    public void ClickOnContinueShoppingButton(){
        explicitWait(Duration.ofSeconds(20), ContinueShoppingButtonLocator);
        click(ContinueShoppingButtonLocator);
    }

    @Step("Click on Cart button")
    public void ClickOnCartButton(){
        click(CartButtonLocator);
    }
    //test case 18

    @Step("Verify Category section is displayed")
    public boolean IsCategoryTextDisplayed() {
        return LocateElement(CategoryTextLocator).isDisplayed();
    }

    @Step("Click on Women category")
    public void clickOnWomenBotton() {
        click(WomenBottonLocator);
    }

    @Step("Click on Tops sub-category")
    public void clickOnTopsButton() {
        click(TopsButtonLocator);
        implicitWait(Duration.ofSeconds(15));
    }

    @Step("Verify Recommended Items section is displayed")
    public boolean IsRecommendedItemsDisplayed() {
        scrollToBottom();
        return LocateElement(RecommendedItemsTextLocator).isDisplayed();
    }

    @Step("Add product from Recommended Items to cart and view cart")
    public void clickOnProductOfRecommendedItems() {
        click(ProductOfRecommendedItemLocator);
        explicitWait(Duration.ofSeconds(20),ViewCartButtonLocator);
        click(ViewCartButtonLocator);
    }
    // test case 25

    @Step("Verify Subscription text is displayed")
    public boolean IsSubscribtionTextDisplayed() {
        scrollToBottom();
        explicitWait(Duration.ofSeconds(15),SubscriptionTextLocator);
        return LocateElement(SubscriptionTextLocator).isDisplayed();
    }

    @Step("Click on scroll to bottom arrow")
    public  void ClickOnArrowBottom() {
        click(ArrowBottomLocator);
    }

    @Step("Verify Full-Fledged practice text is displayed")
    public boolean IsFullFledgedText(){
        return LocateElement(Full_FledgedText).isDisplayed();
    }

    @Step("Scroll to top of the page")
    public void ScrollToTop() {
        scrollToTop();
    }






}
