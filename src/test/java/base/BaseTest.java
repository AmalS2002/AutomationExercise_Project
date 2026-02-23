package base;

import config.ConfigReader;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.JsonDataReader;

import java.io.File;
import java.io.IOException;

@Listeners({
        io.qameta.allure.testng.AllureTestNg.class,
        listeners.TestListener.class
})
public class BaseTest {
   public static WebDriver browser ;
    String fileName= JsonDataReader.getData("ScreenShot","fileName");
    String path=JsonDataReader.getData("ScreenShot","path");
    @BeforeSuite
    public void set() {
        browser = DriverFactory.getDriver();
    }

    @BeforeMethod
    public void setUp() {
        browser.get(ConfigReader.getProperty("url"));
    }

    @BeforeClass
    public void maximize() {
        browser.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {

        BasePage page = new BasePage(browser);
        page.attachScreenshotToAllure();
        try {
            page.TakeScreenShot(fileName + result.getName(), path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @AfterSuite
    public void tearDown() {

            browser.quit();

    }


}
