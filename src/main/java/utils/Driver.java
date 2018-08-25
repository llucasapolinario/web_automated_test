package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().window().setSize(new Dimension(1920, 1080));

            wait = new WebDriverWait(Driver.getDriverInstance(),
                    PropertyManager.getInstance().getTimeOut());
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

//    public static RemoteWebDriver chromeDriver() throws MalformedURLException {
//
//        URL url = new URL(PropertyManager.getInstance().getURL());
//
//        DesiredCapabilities capability = DesiredCapabilities.firefox();
////        ChromeOptions chromeOptions = new ChromeOptions();
//
//        return new RemoteWebDriver(url, capability);
//    }
//
//    public static RemoteWebDriver firefoxDriver() throws MalformedURLException {
//
//        URL url = new URL(PropertyManager.getInstance().getURL());
//
//        DesiredCapabilities capability = DesiredCapabilities.chrome();
////        ChromeOptions chromeOptions = new ChromeOptions();
//
//        return new RemoteWebDriver(url, capability);
//    }
//
}
