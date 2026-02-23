package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {

    //locators
    private final By TestCasesButtonLocator= By.cssSelector("a[href=\"/test_cases\"]");
    private final By TestCasesTextLocator= By.xpath("//h2[@class='title text-center']");


    public TestCasesPage(WebDriver browser) {

        super(browser);
    }

    @Step("Click on Test Cases button")
    public  void TestCasesButtonClick(){
        click(TestCasesButtonLocator);
    }

    @Step("Verify test case displayed")
    public boolean TestCasesTextIsDisplayed(){
        return LocateElement(TestCasesTextLocator).isDisplayed();
    }

}
