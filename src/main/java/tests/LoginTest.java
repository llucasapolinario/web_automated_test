package tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ExtentReport.ExtentManager;
import utils.PropertyManager;


public class LoginTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @Test(priority = 1, description = "Valid Login")
    public void validLoginTest() {
        test = ExtentManager.getInstance().createTest("CT_001");
        ExtentManager.getInstance().attachReporter();
        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getPassword());

        waitTime();
        Assert.assertTrue(homePage.isHomeScreenVisible());
        test.log(Status.PASS,"deu certo");
    }

    @Test(priority = 1, description = "Invalid Login - without password")
    public void invalidLoginTest_WrongPassword() {

        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getUsername());

        waitTime();
        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test(priority = 1, description = "Invalid Login - wrong username")
    public void invalidLoginTest_WrongUsername() {

        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.login("Jose das cove",
                PropertyManager.getInstance().getUsername());

        waitTime();
        Assert.assertTrue(loginPage.isLoginFail());
    }

    @Test(priority = 1, description = "Invalid Login - without username")
    public void invalidLoginTest_EmptyUsername() {

        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.clickLogin();

        waitTime();
        Assert.assertTrue(loginPage.isLoginFail());
    }

}
