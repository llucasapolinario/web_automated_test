package utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaOptions;

import static utils.Constants.operapath;


class OptionsManager {

    ChromeOptions getChromeOptions() {
        System.out.println("getChromeOptions");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
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

    Capabilities getOperaOptions() {
        System.out.println("getOperaOptions");
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.setBinary("@"+operapath);
        operaOptions.addArguments("--start-maximized");
        return operaOptions;
    }

}
