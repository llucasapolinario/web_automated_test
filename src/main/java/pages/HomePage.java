package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private String baseURL = "http://mantis.fernando.base2.com.br/";
    private final String loginURL = "http://mantis.fernando.base2.com.br/";


    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void goToHomePage(){
        driver.get(baseURL);
        //driver.navigate().to(baseURL)
    }

    public void goToLoginPage (){
        click(By.className(loginURL));
    }

}
