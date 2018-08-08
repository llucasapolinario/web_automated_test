package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Constants.BASEURL;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void goToLoginPage (){
        driver.get(BASEURL);
        driver.navigate().to(BASEURL);
    }

    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).clear();
        driver.findElement(elementLocation).sendKeys(text);
    }

    public void wait(Object object){
        wait.equals(object);
    }


    String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

}
