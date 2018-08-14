package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import utils.Driver;

import static utils.Constants.BASE_URL;

class BaseTest {

    private static final int TIME_OUT = 1500;

//    private static final String HUB = "http://172.17.0.2:4444/wd/hub";



    @BeforeMethod
    public void setup() {
        Driver.getDriverInstance().manage().window().maximize();
        Driver.getWaitInstance();

        ChromeOptions chromeOptions = new ChromeOptions();
        new BasePage(Driver.getDriverInstance(), Driver.getWaitInstance()).goToPage(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        Driver.getDriverInstance().close();
        Driver.getDriverInstance().quit();
    }

    void waitTime() {
        waitTime(TIME_OUT);
    }

    public void waitTime(long time) {

        try {

            Thread.sleep(time);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

}
