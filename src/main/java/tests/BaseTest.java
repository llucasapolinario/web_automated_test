package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.BasePage;

class BaseTest {

    private static final int TIME_OUT = 5;

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, TIME_OUT);
        driver.manage().window().maximize();

        new BasePage(driver, wait).goToLoginPage();
    }

    @AfterMethod
    public void teardown() {
        driver.close();
        driver.quit();
    }


    void waitTime() {
        waitTime(TIME_OUT);
    }

    void waitTime(long time) {

        try {
            Thread.sleep(time);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}
