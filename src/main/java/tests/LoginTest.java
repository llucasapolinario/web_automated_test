package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static utils.Constants.MESSAGE_FAILURE_LOGIN;

public class LoginTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @Test()
    public void validLoginTes() {

        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);

        loginPage.login("administrator", "lucas");

        waitTime();
        Assert.assertTrue(homePage.isHomeScreenVisible());
    }

    @Test()
    public void invalidLoginTest() {

        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);

        loginPage.login("lucas", "lucas");

        waitTime();
        Assert.assertTrue(loginPage.isLoginFail(MESSAGE_FAILURE_LOGIN));
    }

    @Test(priority = 1)
    public void invalidLoginTest_EmptyUsername() {

        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);

        loginPage.clickLogin();

        waitTime();
        Assert.assertTrue(loginPage.isLoginFail(MESSAGE_FAILURE_LOGIN));
    }

}
