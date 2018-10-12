package utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import static utils.Utils.getCurrentPlatform;


class OptionsManager {

    ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        System.out.println("getChromeOptions end");
        return options;
    }

    FirefoxOptions getFirefoxOptions() {
        System.out.println("getFirefoxOptions");
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("network.proxy.type", 0);
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

    DesiredCapabilities getEdgeCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        capabilities.setBrowserName("MicrosoftEdge");
        capabilities.setPlatform(getCurrentPlatform());
        capabilities.setCapability("acceptSslCerts", "true");
        return capabilities;
    }

}
