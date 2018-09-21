package pages;

import com.aventstack.extentreports.Status;
import extentReport.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;
import utils.Utils;

public class BasePage {

    public void goToPage(String page) {

        Driver.getDriverInstance().get(page);
        Driver.getDriverInstance().navigate().to(page);
    }

    protected void click(By elementLocation) throws ElementClickInterceptedException {
        waitForElement(elementLocation);
        Utils.screenShotPage(Driver.getDriverInstance(), "ante de cliclar em logar");
        Driver.getDriverInstance().findElement(elementLocation).click();
        TestListener.getTestCenario().log(Status.PASS, "click on " + elementLocation.toString());

    }

    protected void writeText(By elementLocation, String text) {
        waitForElement(elementLocation);
        Driver.getDriverInstance().findElement(elementLocation).clear();
        Driver.getDriverInstance().findElement(elementLocation).sendKeys(text);
        TestListener.getTestCenario().log(Status.PASS, "writeText '"+ text +"' on " + elementLocation.toString());

    }

    protected String readText(By elementLocation) {
        waitForElement(elementLocation);
        System.out.println(Driver.getDriverInstance().findElement(elementLocation).getText());
        return Driver.getDriverInstance().findElement(elementLocation).getText();
    }

    protected String getAlertText(){
        return Driver.getDriverInstance().switchTo().activeElement().getText();
    }

    protected WebElement waitForElement(By elementLocation) {
        return Driver.getWaitInstance().until(ExpectedConditions.elementToBeClickable(elementLocation));
    }

    protected void selectCheckBox(By elementLocation) throws ElementClickInterceptedException {
        WebElement checkBox = Driver.getDriverInstance().findElement(elementLocation);
        if (checkBox.isSelected()) {
            checkBox.click();
        }
        TestListener.getTestCenario().log(Status.PASS, "selectCheckBox on " + elementLocation.toString());

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

    protected boolean isShowing(String value){
//        Driver.getDriverInstance().
        return true;
    }

}

