package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.Constants.LOCK;


public class Driver {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void newChromeInstance(){
        synchronized (LOCK) {
            ChromeOptions chromeOptions = new ChromeOptions();
            URL url = null;
            try {
                url = new URL(PropertyManager.getInstance().getHubLink());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver = new RemoteWebDriver(url, chromeOptions);
            wait = new WebDriverWait(Driver.getDriverInstance(), PropertyManager.getInstance().getTimeOut());
        }
    }

    public static WebDriver getDriverInstance() {
        if (driver == null) {
            synchronized (LOCK) {
                ChromeOptions chromeOptions = null;
                URL url = null;
                try {
                    chromeOptions = new ChromeOptions();
                    url = new URL(PropertyManager.getInstance().getHubLink());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(url, chromeOptions);
            }
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
