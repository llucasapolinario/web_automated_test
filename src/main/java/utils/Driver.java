package utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.Constants.LOCK;


public class Driver {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void newChromeInstance() {
        synchronized (LOCK) {
            ChromeOptions chromeOptions = new ChromeOptions();
            URL url = null;
            try {
                url = new URL(PropertyManager.getInstance().getHubLink());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setPlatform(Platform.LINUX);
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("68.0.3440.84");
            driver = new RemoteWebDriver(url, capabilities);
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

//    public IWebDriver Initialize(string browser) {
//        double timeout = Convert.ToDouble(ConfigurationManager.AppSettings["DefaultTimeout"]);
//
//        if (_driver == null) {
//            if (browser.Equals("Chrome")) {
//                if (Convert.ToBoolean(ConfigurationManager.AppSettings["Remote"])) {
//                    _driver = Chrome.Build();
//                } else {
//                    _driver = Chrome.BuildLocal();
//                }
//            } else if (browser.Equals("Firefox")) {
//                _driver = Firefox.Build();
//            } else {
//                throw new Exception("Driver não suportado!");
//            }
//        }
//
//        _driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(timeout);
//        _driver.Manage().Timeouts().PageLoad = TimeSpan.FromSeconds(timeout);
//
//        return _driver;
//    }

}
