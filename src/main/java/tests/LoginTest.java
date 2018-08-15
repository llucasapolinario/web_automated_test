package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.PropertyManager;


public class LoginTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @Test()
    public void validLoginTest() {

        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getPassword());

        waitTime();
        Assert.assertTrue(homePage.isHomeScreenVisible());
    }

    @Test()
    public void invalidLoginTest_WrongPassword() {

        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getUsername());

        waitTime();
        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test()
    public void invalidLoginTest_WrongUsername() {

        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.login("Jose das cove",
                PropertyManager.getInstance().getUsername());

        waitTime();
        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test()
    public void invalidLoginTest_EmptyUsername() {

        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.clickLogin();

        waitTime();
        Assert.assertTrue(loginPage.isLoginFail());
    }

}
