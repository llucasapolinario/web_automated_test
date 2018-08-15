package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Driver {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private static final Object lock = new Object();

    public static void newInstance() {
        synchronized (lock) {
            driver = new ChromeDriver();
            wait = new WebDriverWait(Driver.getDriverInstance(),
                    PropertyManager.getInstance().getTimeOut());
        }
    }

    public static WebDriver getDriverInstance() {
        if (driver == null) {
            synchronized (lock) {
                driver = new ChromeDriver();
            }
        }

        return driver;
    }

    public static WebDriverWait getWaitInstance() {
        if (wait == null) {
            synchronized (lock) {
                wait = new WebDriverWait(Driver.getDriverInstance(),
                        PropertyManager.getInstance().getTimeOut());
            }
        }

        return wait;
    }

}
