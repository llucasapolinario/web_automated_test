package pages;

import com.aventstack.extentreports.Status;
import extentReport.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;
import utils.Utils;
import utils.WaitUntil;

public class BaseElement {

    public void goToPage(String page) {

        Driver.getDriverInstance().get(page);
        Driver.getDriverInstance().navigate().to(page);
    }

    protected void click(By elementLocation) throws ElementClickInterceptedException {
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);
        assert element != null;
        element.click();

        String screenshotName = "click on " + elementLocation.toString();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestCenario().log(Status.PASS, screenshotName);
    }

    protected void writeText(By elementLocation, String text) {
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);
        element.clear();
        element.sendKeys(text);

        String screenshotName = "writeText "+ text +" on " + element.toString();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestCenario().log(Status.PASS, screenshotName);
    }

    protected String readText(By elementLocation) {
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);

        String screenshotName = "readText"+ element.getText() +" on " + element.toString();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestCenario().log(Status.PASS, screenshotName);

        return element.getText();
    }

    protected void selectCheckBox(By elementLocation) throws ElementClickInterceptedException {
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);

        if (element.isSelected()) {
            element.click();
        }

        String screenshotName = "select checkbox " + element.toString();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestCenario().log(Status.PASS, screenshotName);
    }

    protected void unSelectCheckBox(By elementLocation) throws ElementClickInterceptedException {
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);

        if (!element.isSelected()) {
            element.click();
        }

        String screenshotName = "unselect checkbox " + element.toString();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestCenario().log(Status.PASS, screenshotName);
    }

    protected void selectSpinnerElement(By elementLocation, String value) {
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);

        element.click();
        new Select(element).selectByVisibleText(value);


        String screenshotName = "select spinner '"+ value +"' on element " + element.toString();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestCenario().log(Status.PASS, screenshotName);
    }

    protected WebElement waitForElement(By elementLocation){
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);

        String screenshotName = "wait for element "+ element.getText();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestCenario().log(Status.PASS, screenshotName);

        return element;
    }

    protected boolean elementExists(By elementLocation){
        return WaitUntil.elementExists(elementLocation);
    }
}

