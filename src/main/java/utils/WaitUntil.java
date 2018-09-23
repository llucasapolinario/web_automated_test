package utils;

import com.aventstack.extentreports.Status;
import extentReport.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class WaitUntil {

    private static long TIMEOUT = PropertyManager.getInstance().getTimeOut();
    private static long TIME_OUT_BEFORE_ELEMENT = PropertyManager.getInstance().getTimeOutBeforeElement();

    public static WebElement elementToBeClickable(By elementLocation) {

        try {
            Thread.sleep(TIME_OUT_BEFORE_ELEMENT);

            return new WebDriverWait(Driver.getDriverInstance(), TIMEOUT).until(webDriver -> Exists(elementLocation));

        } catch (InterruptedException e) {
            TestListener.getTestCenario().log(Status.FAIL, elementLocation.toString() + "  not found");
            return null;
        }

    }

    public static boolean elementExists(By elementLocation) {

        try {
            Thread.sleep(TIME_OUT_BEFORE_ELEMENT);
            Driver.getDriverInstance().manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.MILLISECONDS);

            return Driver.getDriverInstance().findElement(elementLocation) != null;

        } catch (InterruptedException | NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }

    }

    private static WebElement Exists(By locator) {
        return Driver.getDriverInstance().findElement(locator);
    }

}
