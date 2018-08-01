package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup () {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,15);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown () {
        driver.close();
        driver.quit();
    }


    void waitTime(){
        waitTime(500);
    }

    void waitTime(long time){

        try {
            Thread.sleep(time);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}
