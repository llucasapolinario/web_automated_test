package tests.Login;

import extentReport.ExtentManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Base.BaseHomePage;
import pages.Login.LoginPage;
import utils.PropertyManager;


public class LoginTest extends ExtentManager {

    private BaseHomePage baseHomePage;
    private LoginPage loginPage;

    @Test(
//            successPercentage = 80,
//            retryAnalyzer = Retry.class
    )
    public void validLoginTest() {
        baseHomePage = new BaseHomePage();
        loginPage = new LoginPage();

        loginPage.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getPassword());

        Assert.assertTrue(baseHomePage.isHomeScreenVisible());
    }

    @Test()
    public void invalidLoginTest_WrongPassword() {

        baseHomePage = new BaseHomePage();
        loginPage = new LoginPage();

        loginPage.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getUsername());

        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test()
    public void invalidLoginTest_WrongUsername() {
        baseHomePage = new BaseHomePage();
        loginPage = new LoginPage();

        loginPage.login("Jose das cove", PropertyManager.getInstance().getUsername());

        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test()
    public void invalidLoginTest_EmptyUsername() {

        baseHomePage = new BaseHomePage();
        loginPage = new LoginPage();

        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginFail());
    }

}
