package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProductsPage extends BasePage {

    private final By productPageVisible=By.xpath("//h2[text()='Category']");
    private final By productNameFieldLocator=By.xpath("//input[@type='text']");
    private final By productSearchButtonLocator=By.xpath("//button[@type='button']");
    private final By searchedAllProductsTextLocator=By.xpath("//h2[@class='title text-center']");
    private final By searchedProductsLocator=By.xpath("//h2[@class='title text-center']");
    private final By productsListLocator=By.className("features_items");
    private final By viewProductOfTheFiristProduct=By.xpath("//a[@href='/product_details/1']");
    private final By HoverOnFirstPictureLocator=By.xpath("//img[@src=\"/get_product_picture/1\"]");
    private final By AddCartButtonLOfFirstPictureocator=By.xpath("(//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart'])[1]");
    private final By ContinueShoppingButton=By.xpath("//button[@class='btn btn-success close-modal btn-block']");
    private final By HoverOnSecondPictureLocator=By.xpath("//img[@src=\"/get_product_picture/2\"]");
    private final By AddCartButtonOfSecondPictureLocator=By.xpath("(//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart'])[2]");
    private final By ViewCartButtonLocator=By.xpath("//div[@class='modal-content']//a[@href='/view_cart']");
    private final By ScrollingPicture=By.xpath("//img[@src='/get_product_picture/4']");
    private final By VerifySellectedProductDetailsLocator=By.xpath("//div[@class='product-information']");
    private final By QuantityFieldLocator=By.xpath("//input[@name='quantity']");
    private final By AddCartButtonLocator=By.xpath("//button[@type='button']");
    private final By ViewCartButtonOfProductLocator=By.xpath("//u[text()='View Cart']");
    //test case 18
    private final By WomenTopsProductsTextLocator=By.xpath("//h2[@class='title text-center']");
    private final By MenButtonLocator=By.xpath("//a[@href='#Men']");
    private final By TshirtsButtonLocator=By.xpath("//a[@href='/category_products/3']");
    private final By MenTshirtsProductsTextLocator=By.xpath("//h2[text()='Men - Tshirts Products']");
    //test case 19
    private final By BrandTextLocator=By.xpath("//h2[text()='Brands']");
    private final By PoloBrandButtonLocator=By.xpath("//a[@href='/brand_products/Polo']");
    private final By PoloBrandProductLocator=By.xpath("//li[text()='Polo']");
    private final By Brand_PoloProductTextLocator=By.xpath("//h2[@class='title text-center']");
    private final By HAndMBrandButtonLocator=By.xpath("//a[@href='/brand_products/H&M']");
    private final By HAndMBrandProductLocator=By.xpath("//li[@class='active']");
    private final By Brand_HAndMProductLocator=By.xpath("//h2[text()='Brand - H&M Products']");
    //test case 20
    private final By FirstPhotoLocator=By.xpath("(//a[contains(@class,'add-to-cart')])[1]");
    private final By SecondPhotoLocator=By.xpath("(//a[contains(@class,'add-to-cart')])[3]");
    private final By ThirdPhotoLocator=By.xpath("(//a[contains(@class,'add-to-cart')])[5]");
    private final By FourthPhotoLocator=By.xpath("(//a[contains(@class,'add-to-cart')])[7]");
    private final By FifthPhotoLocator=By.xpath("(//a[contains(@class,'add-to-cart')])[9]");
    private final By SixPhotoLocator=By.xpath("(//a[contains(@class,'add-to-cart')])[11]");
    //test case 21
    private final By AllProductTextLocator=By.xpath("//h2[@class='title text-center']");
    private final By WriteYourReviewTextLocator=By.xpath("//a[@href='#reviews']");
    private final By EnterNameFieldLocator=By.xpath("//input[@type='text']");
    private final By EnterEmailFieldLocator=By.xpath("//input[@placeholder=\"Email Address\"]");
    private final By AddReviewFieldLocator=By.xpath("//textarea[@name=\"review\"]");
    private final By SubmitButtonReviewLocator=By.xpath("//button[@class=\"btn btn-default pull-right\"]");
    private final By SuccessMessageTextLocator=By.xpath("//span[text()='Thank you for your review.']");
    private final By modalContentLocator = By.xpath("//div[@class='modal-content']");

    // Constructor
    public ProductsPage(WebDriver browser) {
        super(browser);
    }

    // Methods
    @Step("Verify products page is displayed")
    public boolean isProductPageDisplayed() {
        explicitWait(Duration.ofSeconds(10),productPageVisible);

        return LocateElement(productPageVisible).isDisplayed();
    }

    @Step("Enter product name: {productName}")
    public void enterProductName(String productName) {
        explicitWait(Duration.ofSeconds(10),productNameFieldLocator);
        sendElement(productNameFieldLocator, productName);
    }

    @Step("Click on search product button")
    public void searchProduct() {
        explicitWait(Duration.ofSeconds(10), productSearchButtonLocator);
        click(productSearchButtonLocator);
    }

    @Step("Verify searched products text is displayed")
    public boolean isSearchedProductsTextDisplayed(){
        return LocateElement(searchedAllProductsTextLocator).isDisplayed();
    }

    @Step("Verify searched products are displayed")
    public boolean isSearchedProductsDisplayed(){
        return LocateElement(searchedProductsLocator).isDisplayed();
    }

    @Step("Verify product list is visible")
    public boolean isProductListVisible(){
        return LocateElement(productsListLocator).isDisplayed();
    }

    @Step("Click on view product of first product")
    public void cliclOnViewProduct(){
        click(viewProductOfTheFiristProduct);
    }

    @Step("Hover on first product, add to cart and continue shopping")
    public void HoverOnFirstPictureAndClickOnAddCartButtonAndContiueShopping(){
        scrollToElement(viewProductOfTheFiristProduct,Duration.ofSeconds(10));
        hoverOver(HoverOnFirstPictureLocator);
        //scrollToElement(AddCartButtonLOfFirstPictureocator,Duration.ofSeconds(10));
        explicitWait(Duration.ofSeconds(10),AddCartButtonLOfFirstPictureocator);
        click(AddCartButtonLOfFirstPictureocator);
        explicitWait(Duration.ofSeconds(10),ContinueShoppingButton);
        click(ContinueShoppingButton);


    }

    @Step("Hover on second product, add to cart and view cart")
    public void HoverOnSecondPictureAndClickOnAddCartButton(){

        closeAdIfDisplayed();
        explicitWait(Duration.ofSeconds(15), HoverOnSecondPictureLocator);
        hoverOver(HoverOnSecondPictureLocator);
        explicitWait(Duration.ofSeconds(15), AddCartButtonOfSecondPictureLocator);
        click(AddCartButtonOfSecondPictureLocator);
        explicitWait(Duration.ofSeconds(15), modalContentLocator);
        explicitWait(Duration.ofSeconds(15), ViewCartButtonLocator);
        click(ViewCartButtonLocator);
    }


    //test case13
    @Step("Verify selected product details are displayed")
    public boolean VerifySellectedProductDetailsDisplayed(){
        explicitWait(Duration.ofSeconds(10),VerifySellectedProductDetailsLocator);
        return LocateElement(VerifySellectedProductDetailsLocator).isDisplayed();
    }

    @Step("Increase product quantity to 4")
    public void IncreaseOfQuantityField(){
        LocateElement(QuantityFieldLocator).clear();
        sendElement(QuantityFieldLocator,"4");
    }

    @Step("Click on add to cart button")
    public void ClickOnAddCartButton(){
        click(AddCartButtonLocator);
    }

    @Step("Click on view cart button")
    public void ClickOnViewCartButton(){
        click(ViewCartButtonOfProductLocator);
    }
    //test case 18

    @Step("Verify Women Tops products text is displayed")
    public boolean IsWomenTopsProductsTextDisplayed(){
        explicitWait(Duration.ofSeconds(15), WomenTopsProductsTextLocator);
        return LocateElement(WomenTopsProductsTextLocator).isDisplayed();
    }

    @Step("Click on Men category")
    public void ClickOnMenButton(){
        click(MenButtonLocator);
    }

    @Step("Click on T-shirts category")
    public void ClickOnTshirtsButton(){
        click(TshirtsButtonLocator);
    }

    @Step("Verify Men T-shirts products text is displayed")
    public boolean IsMenTshirtsProductsTextDisplayed(){
        explicitWait(Duration.ofSeconds(15), MenTshirtsProductsTextLocator);
        return LocateElement(MenTshirtsProductsTextLocator).isDisplayed();
    }
    //test case 19
    @Step("Verify brand text is displayed")
    public boolean IsBrandTextDisplayed(){
        return LocateElement(BrandTextLocator).isDisplayed();
    }

    @Step("Click on Polo brand")
    public void ClickOnPoloBrandButton(){
        click(PoloBrandButtonLocator);
    }

    @Step("Verify Polo brand products are displayed")
    public boolean IsPoloBrandProductsDisplayed(){
        explicitWait(Duration.ofSeconds(15),PoloBrandProductLocator);
        return LocateElement(PoloBrandProductLocator).isDisplayed();
    }

    @Step("Verify Polo brand products text is displayed")
    public boolean IsBrand_PoloProductsTextDisplayed(){
        return LocateElement(Brand_PoloProductTextLocator).isDisplayed();
    }

    @Step("Click on H&M brand")
    public void ClickOnHAndMBrandButton(){
        click(HAndMBrandButtonLocator);
    }

    @Step("Verify H&M brand products are displayed")
    public boolean IsHAndMBrandProductsDisplayed(){
        explicitWait(Duration.ofSeconds(15),HAndMBrandProductLocator);
        return LocateElement(HAndMBrandProductLocator).isDisplayed();
    }

    @Step("Verify H&M brand products text is displayed")
    public boolean IsBrand_HAndMProductsTextDisplayed(){
        return LocateElement(Brand_HAndMProductLocator).isDisplayed();
    }
    // test case 20

    @Step("Add all products to cart")
    public void AddAllProductsToCart(){
        click(FirstPhotoLocator);
        explicitWait(Duration.ofSeconds(10),ContinueShoppingButton);
        click(ContinueShoppingButton);
        click(SecondPhotoLocator);
        explicitWait(Duration.ofSeconds(10),ContinueShoppingButton);
        click(ContinueShoppingButton);
        click(ThirdPhotoLocator);
        explicitWait(Duration.ofSeconds(10),ContinueShoppingButton);
        click(ContinueShoppingButton);
        click(FourthPhotoLocator);
        explicitWait(Duration.ofSeconds(10),ContinueShoppingButton);
        click(ContinueShoppingButton);
        click(FifthPhotoLocator);
        explicitWait(Duration.ofSeconds(10),ContinueShoppingButton);
        click(ContinueShoppingButton);
        click(SixPhotoLocator);
        explicitWait(Duration.ofSeconds(10),ContinueShoppingButton);
        click(ContinueShoppingButton);
    }
    //test case 21

    @Step("Verify all products text is displayed")
    public boolean IsAllProductsTextDisplayed(){
        explicitWait(Duration.ofSeconds(15),AllProductTextLocator);
        return LocateElement(AllProductTextLocator).isDisplayed();
    }

    @Step("Click on view product of the first product")
    public void ClickOnviewProductOfTheFiristProduct(){
        click(viewProductOfTheFiristProduct);
    }

    @Step("Verify 'Write Your Review' text is displayed")
    public boolean IsWriteYourReviewTextDisplayed(){
        explicitWait(Duration.ofSeconds(15),WriteYourReviewTextLocator);
        return LocateElement(WriteYourReviewTextLocator).isDisplayed();
    }

    @Step("Enter review details: Name = {name}, Email = {email}")
    public void EnterNameEmailAndReview(String name, String email, String reviewText){
        sendElement(EnterNameFieldLocator,name);
        sendElement(EnterEmailFieldLocator,email);
        sendElement(AddReviewFieldLocator,reviewText);
        click(SubmitButtonReviewLocator);

    }

    @Step("Verify review success message is displayed")
    public boolean IsSuccessMessageDisplayed(){
        explicitWait(Duration.ofSeconds(15),SuccessMessageTextLocator);
        return LocateElement(SuccessMessageTextLocator).isDisplayed();
    }





}
