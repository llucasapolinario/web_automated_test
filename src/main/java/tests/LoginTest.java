package tests;

import extentReport.ExtentManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.PropertyManager;


public class LoginTest extends ExtentManager {

    private HomePage homePage;
    private LoginPage loginPage;

    @Test(priority = 2
//            , successPercentage = 80,
//            retryAnalyzer = Retry.class
    )
    public void validLoginTest() {
        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getPassword());

        Assert.assertTrue(homePage.isHomeScreenVisible());
    }

    @Test(priority = 1)
    public void invalidLoginTest_WrongPassword() {

        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getUsername());

        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test(priority = 1)
    public void invalidLoginTest_WrongUsername() {
        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.login("Jose das cove", PropertyManager.getInstance().getUsername());

        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test(priority = 1)
    public void invalidLoginTest_EmptyUsername() {

        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginFail());
    }

}
