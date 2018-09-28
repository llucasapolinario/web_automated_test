package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.Utils.getCurrentPlatform;

class DriverFactory {

    private static OptionsManager optionsManager = new OptionsManager();

    static WebDriver setDriver(String browser) {

        if (PropertyManager.getInstance().getIsTextExecutionLocal()) {

            switch (browser) {
                case "firefox":
                    FirefoxDriver firefoxDriver = new FirefoxDriver();
                    firefoxDriver.manage().window().maximize();
                    return firefoxDriver;

                default:
                    ChromeDriver chromeDriver = new ChromeDriver();
                    chromeDriver.manage().window().maximize();
                    return chromeDriver;
            }

        } else {

            String hubLink = PropertyManager.getInstance().getHubLink();

            switch (browser) {
                case "firefox": {
                    try {
                        return new RemoteWebDriver(new URL(hubLink), optionsManager.getFirefoxOptions());

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    break;
                }
                case "edge": {

                    DesiredCapabilities capabilities = DesiredCapabilities.edge();
                    capabilities.setBrowserName("MicrosoftEdge");
                    capabilities.setPlatform(getCurrentPlatform());
                    capabilities.setVersion("6.17134");
//                    capabilities.setCapability("acceptSslCerts", "true");
                    try {
                        return new RemoteWebDriver(new URL(hubLink), capabilities);

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
