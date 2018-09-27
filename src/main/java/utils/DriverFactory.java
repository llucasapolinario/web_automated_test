package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

class DriverFactory {

    private static OptionsManager optionsManager = new OptionsManager();

    static WebDriver setDriver(String browser) {

        if (PropertyManager.getInstance().getIsTextExecutionLocal()) {

            switch (browser) {
                case "firefox":
                    FirefoxDriver firefoxDriver = new FirefoxDriver();
                    firefoxDriver.manage().window().maximize();
                    return firefoxDriver;

                case "opera":
                    OperaDriver operaDriver = new OperaDriver();
                    operaDriver.manage().window().maximize();
                    return operaDriver;

                default:
                    ChromeDriver chromeDriver = new ChromeDriver();
                    chromeDriver.manage().window().maximize();
                    return chromeDriver;

            }

        } else {

            String hubLink = PropertyManager.getInstance().getHubLink();

            switch (browser) {
                case "firefox": {

                    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                    capabilities.setBrowserName("firefox1");
                    try {

                        return new RemoteWebDriver(new URL(hubLink), optionsManager.getFirefoxOptions());

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    break;
                }
                case "opera": {

                    DesiredCapabilities capabilities = DesiredCapabilities.operaBlink();
                    capabilities.setBrowserName("operablink");
                    try {

                        return new RemoteWebDriver(new URL(hubLink), optionsManager.getOperaOptions());

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    break;
                }
                default: {

                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    capabilities.setBrowserName("chrome1");
                    try {

                        return new RemoteWebDriver(new URL(hubLink), optionsManager.getChromeOptions());

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return null;
    }

}
