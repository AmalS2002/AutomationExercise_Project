package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailedPage extends BasePage {
    private final By ProductNameLocator = By.xpath("//div[@class='product-information']//h2");
    private final By ProductCategoryLocator = By.xpath("//p[contains(text(),'Category')]");
    private final By ProductPriceLocator = By.xpath("//span/span");
    private final By productAvailabilityLocator = By.xpath("//p[text()=' In Stock']");
    private final By productConditionLocator = By.xpath("//p[text()=' New']");
    private final By productBrandLocator =By.xpath("//p[text()=' Polo']");



    public ProductDetailedPage(WebDriver browser) {
        super(browser);

    }
    @Step("Verify product name is displayed")
    public boolean isProductNameDisplayed(){
        return LocateElement(ProductNameLocator).isDisplayed();
    }

    @Step("Verify product category is displayed")
    public boolean isProductCategoryDisplayed(){
        return LocateElement(ProductCategoryLocator).isDisplayed();
    }

    @Step("Verify product price is displayed")
    public boolean isProductPriceDisplayed(){
        return LocateElement(ProductPriceLocator).isDisplayed();
    }

    @Step("Verify product availability is displayed")
    public boolean isProductAvailabilityDisplayed(){
        return LocateElement(productAvailabilityLocator).isDisplayed();
    }

    @Step("Verify product condition is displayed")
    public boolean isProductConditionDisplayed(){
        return LocateElement(productConditionLocator).isDisplayed();
    }

    @Step("Verify product brand is displayed")
    public boolean isProductBrandDisplayed(){
        return LocateElement(productBrandLocator).isDisplayed();
    }
}
