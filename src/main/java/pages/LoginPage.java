package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static utils.Constants.*;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void login(String username, String password) {

        try{
            setLoginUsername(username);
            setLoginPassword(password);

        }catch (Exception e){
            System.out.println();
        }

    }

    public void setLoginUsername(String username) {
        writeText(By.id(USERNAME_ID), username);
        clickLogin();
    }

    public void setLoginPassword(String password) {
        writeText(By.id(PASSWORD_ID), password);
        clickLogin();
    }

    public void clickLogin() {
        click(By.xpath(LOGIN_XPATH));
    }


    public void assertVerifyFailureLogin(String expectedText) {
        Assert.assertEquals(readText(By.xpath(errorMessagePasswordXpath)), expectedText);
    }

    public void assertFalseVerifyFailureLogin(String expectedText) {
        Assert.assertNotEquals(readText(By.xpath(errorMessagePasswordXpath)), expectedText);
    }

}
