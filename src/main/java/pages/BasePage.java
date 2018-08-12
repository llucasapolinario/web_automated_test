package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

//    initialize ExtentReports and attach the HtmlReporter
//    private ExtentReports extent = new ExtentReports();
//    private ExtentTest test = extent.createTest("Test");

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToPage(String page) {
        driver.get(page);
        driver.navigate().to(page);
    }

    void click(By elementLocation) throws ElementClickInterceptedException {
        waitForElement(elementLocation);

        Utils.screenshotPage(driver, "ante de cliclar em logar");
        driver.findElement(elementLocation).click();
    }

    void writeText(By elementLocation, String text) {
        waitForElement(elementLocation);
        driver.findElement(elementLocation).clear();
        driver.findElement(elementLocation).sendKeys(text);
//            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
    }

    String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

    WebElement waitForElement(By elementLocation) {
        return wait.until(ExpectedConditions.elementToBeClickable(elementLocation));
    }

}
