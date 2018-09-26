package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static OptionsManager optionsManager = new OptionsManager();

    public static WebDriver setDriver(String browser) {

        if (PropertyManager.getInstance().getIsTextExecutionLocal()) {

            return new ChromeDriver();

        } else {

            String hublink = PropertyManager.getInstance().getHubLink();

            if (browser.equals("firefox")) {

                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox1");
                try {
                    return new RemoteWebDriver(new URL(hublink), optionsManager.getFirefoxOptions());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equals("opera")) {
                DesiredCapabilities capabilities = DesiredCapabilities.operaBlink();
                capabilities.setBrowserName("opera1");
                try {
                    return new RemoteWebDriver(new URL(hublink), optionsManager.getOperaOptions());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome1");
                try {
                    return new RemoteWebDriver(new URL(hublink), optionsManager.getChromeOptions());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }

}
