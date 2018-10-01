package pages.Base;

import com.aventstack.extentreports.Status;
import extentReport.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
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
        TestListener.getTestScenario().log(Status.PASS, screenshotName);
    }

    protected void writeText(By elementLocation, String text) {
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);
        element.clear();
        element.sendKeys(text);

        String screenshotName = "writeText "+ text +" on " + elementLocation.toString();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestScenario().log(Status.PASS, screenshotName);
    }

    protected String readText(By elementLocation) {
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);

        String screenshotName = "readText"+ element.getText() +" on " + elementLocation.toString();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestScenario().log(Status.PASS, screenshotName);

        return element.getText();
    }

    protected void selectCheckBox(By elementLocation) throws ElementClickInterceptedException {
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);

        if (element.isSelected()) {
            element.click();
        }

        String screenshotName = "select checkbox " + elementLocation.toString();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestScenario().log(Status.PASS, screenshotName);
    }

    protected boolean isCheckBoxSelected(By elementLocation) throws ElementClickInterceptedException {
        WebElement element = Driver.getDriverInstance().findElement(elementLocation);
        return !element.isSelected();
    }

    protected void unSelectCheckBox(By elementLocation) throws ElementClickInterceptedException {
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);

        if (!element.isSelected()) {
            element.click();
        }

        String screenshotName = "unselect checkbox " + elementLocation.toString();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestScenario().log(Status.PASS, screenshotName);
    }

    protected void selectSpinnerElement(By elementLocation, String value) {
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);

        element.click();
        new Select(element).selectByVisibleText(value);


        String screenshotName = "select spinner '"+ value +"' on element " + elementLocation.toString();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestScenario().log(Status.PASS, screenshotName);
    }

    protected WebElement waitForElement(By elementLocation){
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);

        String screenshotName = "wait for element "+ elementLocation.toString();
        Utils.screenShotPage(Driver.getDriverInstance(), screenshotName);
        TestListener.getTestScenario().log(Status.PASS, screenshotName);

        return element;
    }

    protected boolean elementExists(By elementLocation){
        return WaitUntil.elementExists(elementLocation);
    }

    protected void scrollToElement(By elementLocation){
        WebElement element = WaitUntil.elementToBeClickable(elementLocation);
        ((JavascriptExecutor) Driver.getDriverInstance()).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void goBackPage(){
        Driver.getDriverInstance().navigate().back();
    }

}

