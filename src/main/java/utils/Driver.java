package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static utils.Constants.LOCK;

public class Driver {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver newInstance() {
        System.out.println("newInstance");
        synchronized (LOCK) {

            driver = DriverFactory.setDriver(PropertyManager.getInstance().getBrowserExecution());
            wait = new WebDriverWait(Driver.getDriverInstance(),
                    PropertyManager.getInstance().getTimeOut());
        }
        return driver;
    }


    public static WebDriver getDriverInstance() {
        if (driver == null) {
            driver = newInstance();
        }

        return driver;
    }

    public static WebDriverWait getWaitInstance() {
        if (wait == null) {
            synchronized (LOCK) {
                wait = new WebDriverWait(Driver.getDriverInstance(),
                        PropertyManager.getInstance().getTimeOut());
            }
        }

        return wait;
    }

}
