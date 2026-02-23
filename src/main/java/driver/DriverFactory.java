package driver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
public class DriverFactory {

    public static WebDriver getDriver() {

        WebDriver driver;
        String browser = ConfigReader.getProperty("browser").toLowerCase();

        switch (browser) {

            case "chrome":
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--disable-extensions");
                option.addArguments("--start-maximized");

                 driver = new ChromeDriver(option);
                 break;


            case "edge":

                EdgeOptions options = new EdgeOptions();

                options.addArguments(
                        "--load-extension=C:\\Users\\user1\\AppData\\Local\\Microsoft\\Edge\\User Data\\Default\\Extensions\\odfafepnkmbhccpbejgmiehpchacaeak\\2026.125.69.0_0"
                );

                options.addArguments("--disable-notifications");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-popup-blocking");

                driver = new EdgeDriver(options);
                break;

            default:
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }
}