package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.io.IOException;

import static utils.Constants.BASE_URL;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // initialize ExtentReports and attach the HtmlReporter
    private ExtentReports extent = new ExtentReports();
    private ExtentTest test = extent.createTest("Test");

    public BasePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void goToLoginPage (){
        driver.get(BASE_URL);
        driver.navigate().to(BASE_URL);
    }

    void click(By elementLocation) throws ElementClickInterceptedException {
        Utils.screenshotPage(driver, "ante de cliclar em logar");
        driver.findElement(elementLocation).click();
    }

    void writeText(By elementLocation, String text) {
        try {

            driver.findElement(elementLocation).clear();
            driver.findElement(elementLocation).sendKeys(text);
            // adding screenshots to log
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitForObject(Object object){
       wait.equals(object);
    }

    String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

}
