package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.Duration;
public class DownloadFilePage extends BasePage {

    //  Locators
    private final By downloadInvoiceButton = By.xpath("//a[text()='Download Invoice']");
    private final By continueButton = By.xpath("//div[@class='pull-right']");

    //  Constructor
    public DownloadFilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Download Invoice button")
    public void clickDownloadInvoiceButton() {
        click(downloadInvoiceButton);
        explicitWait(Duration.ofSeconds(10), continueButton);
    }

    @Step("Click Continue button after downloading invoice")
    public void clickContinueButton() {
        click(continueButton);
    }

    @Step("Verify invoice file '{fileName}' is downloaded in path: {downloadPath}")
    public boolean waitForFileToDownload(String downloadPath, String fileName, int timeoutSeconds) {

        File dir = new File(downloadPath);

        if (!dir.exists() || !dir.isDirectory()) {
            return false;
        }

        int time = 0;

        while (time < timeoutSeconds) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.getName().contains(fileName)) {
                        return true;
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time++;
        }
        return false;
    }
}
