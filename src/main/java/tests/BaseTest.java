package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import static utils.Constants.BASE_URL;

class BaseTest {

    private static final int TIME_OUT = 15;

    WebDriver driver;
    WebDriverWait wait;
//    private static final String HUB = "http://172.17.0.2:4444/wd/hub";

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIME_OUT);
        new BasePage(driver, wait).goToPage(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
        driver.quit();
    }

    void waitTime() {
        waitTime(TIME_OUT);
    }

    private void waitTime(long time) {

        try {

            Thread.sleep(time);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

}
