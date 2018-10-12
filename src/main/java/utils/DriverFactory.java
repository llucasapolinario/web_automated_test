package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


class DriverFactory {

    private static OptionsManager optionsManager = new OptionsManager();

    static WebDriver setDriver(String browser) {

        if (PropertyManager.getInstance().getIsTextExecutionLocal()) {
            return localWebDriver(browser);

        } else {
            return gridWebDriver(browser);

        }

    }

    private static WebDriver gridWebDriver(String browser) {
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
                try {
                    return new RemoteWebDriver(new URL(hubLink), optionsManager.getEdgeCapabilities());

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

        return null;
    }

    private static WebDriver localWebDriver(String browser) {

        switch (browser) {
            case "firefox":
                FirefoxDriver firefoxDriver = new FirefoxDriver();
                firefoxDriver.manage().window().maximize();
                return firefoxDriver;

            case "edge":
                EdgeDriver edgeDriver = new EdgeDriver();
                edgeDriver.manage().window().maximize();
                return edgeDriver;

            default:
                ChromeDriver chromeDriver = new ChromeDriver();
                chromeDriver.manage().window().maximize();
                return chromeDriver;
        }

    }

}
