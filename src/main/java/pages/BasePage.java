package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;
import utils.ExtentReport.ExtentManager;
import utils.Utils;

import java.io.IOException;

public class BasePage {

    public void goToPage(String page) {

        Driver.getDriverInstance().get(page);
        Driver.getDriverInstance().navigate().to(page);
//        test.createNode("")
//        test.addScreenCaptureFromPath(
//                test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build()));
    }

    protected void click(By elementLocation) throws ElementClickInterceptedException {
        waitForElement(elementLocation);
        Utils.screenShotPage(Driver.getDriverInstance(), "ante de cliclar em logar");
        Driver.getDriverInstance().findElement(elementLocation).click();
    }

    protected void writeText(By elementLocation, String text) {
        waitForElement(elementLocation);
        Driver.getDriverInstance().findElement(elementLocation).clear();
        Driver.getDriverInstance().findElement(elementLocation).sendKeys(text);
    }

    protected String readText(By elementLocation) {
        waitForElement(elementLocation);
        return Driver.getDriverInstance().findElement(elementLocation).getText();
    }

    protected WebElement waitForElement(By elementLocation) {
        return Driver.getWaitInstance().until(ExpectedConditions.elementToBeClickable(elementLocation));
    }

    protected void selectCheckBox(By elementLocation) throws ElementClickInterceptedException {
        WebElement checkBox = Driver.getDriverInstance().findElement(elementLocation);

        if (checkBox.isSelected()) {
            checkBox.click();
        }
    }

    protected void unSelectCheckBox(By elementLocation) throws ElementClickInterceptedException {
        WebElement checkBox = Driver.getDriverInstance().findElement(elementLocation);

        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    protected void selectSpinnerElement(By elementLocation, String value) {
        waitForElement(elementLocation);
        Driver.getDriverInstance().findElement(elementLocation).click();
        new Select(Driver.getDriverInstance().findElement(elementLocation)).selectByVisibleText(value);
    }

}
