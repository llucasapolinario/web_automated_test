package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.BasePage;
import utils.PropertyManager;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setup(String browser) throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);


//        Driver.newChromeInstance();
//        Driver.getDriverInstance().manage().window().maximize();
        driver.set(new RemoteWebDriver(new URL(PropertyManager.getInstance().getHubLink()), capabilities));
        new BasePage().goToPage(PropertyManager.getInstance().getURL());
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
//        Driver.getDriverInstance().close();
//        Driver.getDriverInstance().quit();
    }

    @AfterClass
    void terminate () {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }


    void waitTime() {
        waitTime(PropertyManager.getInstance().getTimeOut());
    }

    public void waitTime(long time) {

        try {

            Thread.sleep(time);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

}
