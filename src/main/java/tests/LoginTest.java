package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static utils.Constants.MESSAGE_FAILURE_LOGIN;

public class LoginTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    // Extra information:
    // 1) @BeforeClass we declared driver and wait variables
    // 2) We send these driver and wait variables to the page class with below declaration
    //    Homepage homepage = new HomePage(driver,wait);
    // 3) super () method in page class transfer the driver and wait variables values to the BasePage class.

    @Test()
    public void validLoginTes() {

        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);

        loginPage.login("administrator", "qwe");

        waitTime();
        loginPage.assertFalseVerifyFailureLogin(MESSAGE_FAILURE_LOGIN);
//        homePage.
    }

    @Test()
    public void invalidLoginTest() {

        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);

        loginPage.login("lucas", "lucas");

        waitTime();
        loginPage.assertVerifyFailureLogin(MESSAGE_FAILURE_LOGIN);
    }

    @Test(priority = 1)
    public void invalidLoginTest_EmptyUsername() {

        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);

        loginPage.clickLogin();

        waitTime();
        loginPage.assertVerifyFailureLogin(MESSAGE_FAILURE_LOGIN);
    }

}
