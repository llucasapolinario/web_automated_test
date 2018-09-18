package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Constants.LOCK;

public class Driver {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void newInstance() {
        synchronized (LOCK) {
            driver = new ChromeDriver();
            wait = new WebDriverWait(Driver.getDriverInstance(),
                    PropertyManager.getInstance().getTimeOut());
        }
    }

    public static WebDriver getDriverInstance() {
        System.out.println("getDriverInstance");
        if (driver == null) {
            newInstance() ;
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
