package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import utils.Driver;
import utils.PropertyManager;

import java.net.MalformedURLException;


public class BaseTest {


    @BeforeMethod
    public void setup() throws MalformedURLException {

        Driver.newChromeInstance();
        Driver.getDriverInstance().manage().window().maximize();

        new BasePage().goToPage(PropertyManager.getInstance().getURL());
    }

    @AfterMethod
    public void teardown() {
        Driver.getDriverInstance().close();
        Driver.getDriverInstance().quit();
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
