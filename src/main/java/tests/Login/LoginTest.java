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

    @Test(/*successPercentage = 80, retryAnalyzer = Retry.class*/)
    public void validLoginTest() {
        validateLoginPage();

        loginPage.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getPassword());

        Assert.assertTrue(baseHomePage.isHomeScreenVisible());
    }

    @Test
    public void invalidLoginTest_WrongPassword() {
        validateLoginPage();

        loginPage.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getUsername());

        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test
    public void invalidLoginTest_WrongUsername() {
        validateLoginPage();

        loginPage.login("Jose das cove", PropertyManager.getInstance().getPassword());

        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test
    public void invalidLoginTest_EmptyUsername() {
        validateLoginPage();

        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test
    public void validateRecoverPasswordPage() {
        validateCreateAccountPage();

        loginPage.clickRecoverPassword();

        Assert.assertTrue(loginPage.isRecoverPasswordPage());
    }

    @Test
    public void validateCreateAccountPage() {
        validateLoginPage();

        loginPage.clickCreateUser();

        Assert.assertTrue(loginPage.isCreateAccountPage());
    }

    @Test
    public void validateLoginPage() {
        baseHomePage = new BaseHomePage();
        loginPage = new LoginPage();

        Assert.assertTrue(loginPage.isLoginPage());
    }

}
