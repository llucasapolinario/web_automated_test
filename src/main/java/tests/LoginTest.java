package tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import extentReport.RegressionFunc;
import extentReport.Retry;
import utils.PropertyManager;



public class LoginTest extends RegressionFunc {

    private HomePage homePage;
    private LoginPage loginPage;

    @Test(priority = 0, testName = "Valid Login", retryAnalyzer = Retry.class)
    public void validLoginTest() {
        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getPassword());

        Assert.assertTrue(!homePage.isHomeScreenVisible());
        testInstance.log(Status.PASS, "deu bom");
    }

    @Test(priority = 1, testName = "Invalid Login - without password", retryAnalyzer = Retry.class)
    public void invalidLoginTest_WrongPassword() {

        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getUsername());

        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test(priority = 1, testName = "Invalid Login - wrong username", retryAnalyzer = Retry.class)
    public void invalidLoginTest_WrongUsername() {
        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.login("Jose das cove",
                PropertyManager.getInstance().getUsername());

        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test(priority = 1, testName = "Invalid Login - without username", retryAnalyzer = Retry.class)
    public void invalidLoginTest_EmptyUsername() {

        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginFail());
    }

}
