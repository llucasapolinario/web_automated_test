package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Driver;
import utils.Utils;

public class BasePage {

//    initialize ExtentReports and attach the HtmlReporter
//    private ExtentReports extent = new ExtentReports();
//    private ExtentTest test = extent.createTest("Test");

    public void goToPage(String page) {
        Driver.getDriverInstance().get(page);
        Driver.getDriverInstance().navigate().to(page);
    }

    void click(By elementLocation) throws ElementClickInterceptedException {
        waitForElement(elementLocation);

        Utils.screenShotPage(Driver.getDriverInstance(), "ante de cliclar em logar");
        Driver.getDriverInstance().findElement(elementLocation).click();
    }

    void writeText(By elementLocation, String text) {
        waitForElement(elementLocation);
        Driver.getDriverInstance().findElement(elementLocation).clear();
        Driver.getDriverInstance().findElement(elementLocation).sendKeys(text);
//            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
    }

    String readText(By elementLocation) {
        return Driver.getDriverInstance().findElement(elementLocation).getText();
    }

    WebElement waitForElement(By elementLocation) {
        return Driver.getWaitInstance().until(ExpectedConditions.elementToBeClickable(elementLocation));
    }

}
