package base;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BasePage {

    protected static WebDriver browser;

    public BasePage(WebDriver browser) {
        this.browser = browser;
    }

    public void implicitWait(Duration duration) {
        browser.manage().timeouts().implicitlyWait(duration);
    }


    public void explicitWait(Duration duration, By locator) {
        new WebDriverWait(browser, duration)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForClickable(Duration time, By locator){
        new WebDriverWait(browser, time)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitForPresence(Duration time, By locator){
        new WebDriverWait(browser, time)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }




    public void fluentWait(By locator, int timeoutSeconds, int pollingMillis, String timeoutMessage) {

        Wait<WebDriver> wait = new FluentWait<>(browser)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(pollingMillis))
                .ignoring(NoSuchElementException.class)
                .withMessage(timeoutMessage);

        wait.until(driver -> driver.findElement(locator).isDisplayed());
    }
    public void waiteForURL(String url,Duration duration) {
        new WebDriverWait(browser, duration).until(ExpectedConditions.urlToBe(url));
    }


    public void navigateToURL(String url) {
        browser.get(url);
    }


    public String getPageTitle() {
        return browser.getTitle();
    }


    public String getCurrentUrl() {
        return browser.getCurrentUrl();
    }


    public WebElement LocateElement(By locator) {
        return browser.findElement(locator);
    }


    public  void clickOnButton(By locator) {
        LocateElement(locator).click();
    }


    public void performAction(By locator, String actionType) {

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        Actions actions = new Actions(browser);

        switch(actionType.toLowerCase()) {
            case "click":
                element.click();
                break;
            case "rightclick":
                actions.contextClick(element).perform();
                break;
            case "doubleclick":
                actions.doubleClick(element).perform();
                break;
            case "hover":
                actions.moveToElement(element).perform();
                break;
            default:
                throw new IllegalArgumentException("Action type not supported: " + actionType);
        }
    }


    public void click (By locator) {
        performAction(locator, "click");
    }


    public void rightClick(By locator) {
        performAction(locator, "rightclick");
    }


    public void doubleClick(By locator) {
        performAction(locator, "doubleclick");
    }


    public void hoverOver(By locator) {
        performAction(locator, "hover");
    }


    public void sendElement (By locator, String text) {

        WebElement element = LocateElement(locator);
        element.clear();
        element.sendKeys(text);
    }


    public String getText(By locator,Duration duration) {
        explicitWait(duration, locator);
        return LocateElement(locator).getText();
    }


    public void selectDropdownByVisibleText(By locator, String visibleText, Duration duration) {

        explicitWait(duration, locator);

        WebElement dropdownElement = LocateElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
    }


    public void selectDropdownByValue(By locator, String value, Duration duration) {
        // Wait until dropdown is visible
        explicitWait(duration, locator);

        WebElement dropdownElement = LocateElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByValue(value);
    }

    public void selectDropdownByIndex(By locator, int index, Duration duration) {
        explicitWait(duration, locator);
        WebElement dropdownElement = LocateElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }


    public void dragAndDrop(By source, By destination, Duration duration) {
        explicitWait(duration, source);
        WebElement sourceElement = LocateElement(source);
        WebElement destinationElement = LocateElement(destination);
        Actions actions = new Actions(browser);
        actions.dragAndDrop(sourceElement, destinationElement).perform();
    }

    public void checkCheckbox(By locator, Duration duration) {

        explicitWait(duration, locator);

        WebElement checkbox = LocateElement(locator);


        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheckCheckbox(By locator, Duration duration) {

        explicitWait(duration, locator);

        WebElement checkbox = LocateElement(locator);


        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void selectRadioButton(By locator, Duration duration) {

        explicitWait(duration, locator);

        WebElement radio = LocateElement(locator);


        if (!radio.isSelected()) {
            radio.click();
        }
    }
    public void switchToWindowByTitle(String windowTitle) {
        for (String handle : browser.getWindowHandles()) {
            browser.switchTo().window(handle);
            if (browser.getTitle().equals(windowTitle)) {
                return;
            }
        }
        throw new RuntimeException("No window with title: " + windowTitle + " found.");
    }
    public void switchToWindowByHandle(String windowHandle) {
        for (String handle : browser.getWindowHandles()) {
            if (handle.equals(windowHandle)) {
                browser.switchTo().window(handle);
                return;
            }
        }
        throw new RuntimeException("No window with handle: " + windowHandle + " found ");
    }
    public void quitCurrentWindow() {
        browser.quit();
    }
    public void navigateBack() {
        browser.navigate().back();
    }
    public void navigateForward() {
        browser.navigate().forward();
    }
    public void navigateRefresh() {
        browser.navigate().refresh();
    }
    public void scrollToElement(By locator, Duration duration) {

        explicitWait(duration, locator);

        WebElement element = LocateElement(locator);
        Actions actions = new Actions(browser);
        actions.scrollToElement(element).perform();
    }
    public void scrollToBottom() {
        Actions actions = new Actions(browser);
        actions.sendKeys(Keys.END).perform();
    }
    public void scrollToTop() {
        Actions actions = new Actions(browser);
        actions.sendKeys(Keys.HOME).perform();
    }
    public void acceptAlert() {
        browser.switchTo().alert().accept();
    }
    public void dismissAlert() {
        browser.switchTo().alert().dismiss();
    }
    public String getAlertText() {
        return browser.switchTo().alert().getText();
    }
    public void sendTextToAlert(String text) {
        browser.switchTo().alert().sendKeys(text);
        browser.switchTo().alert().accept();
    }
    public void closeBrowserWindow() {
        browser.close();
    }
    public File TakeScreenShot(String fileName, String path) throws IOException
    {
        File src =((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
        File dest = new File(path+fileName+".png");
        FileHandler.copy(src,dest);
        return dest;
    }
    @Step("Attach screenshot")
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshotToAllure() {
        return ((TakesScreenshot) browser)
                .getScreenshotAs(OutputType.BYTES);
    }

    public void closeAdIfDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(3));
            WebElement closeBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(@class,'close-modal')]")
                    )
            );
            closeBtn.click();
        } catch (Exception e) {

        }
    }
    protected List<WebElement> findAll(By locator) {
        return browser.findElements(locator);
    }







}
