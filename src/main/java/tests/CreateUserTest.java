package tests;

import org.testng.annotations.Test;
import pages.CreateUser;
import pages.LoginPage;
import utils.Driver;

public class CreateUserTest extends BaseTest {

    private CreateUser createUser;
    private LoginPage loginPage;

    @Test()
    public void createUser() {

        createUser = new CreateUser(Driver.getDriverInstance(), Driver.getWaitInstance());
        loginPage = new LoginPage(Driver.getDriverInstance(), Driver.getWaitInstance());

        loginPage.clickCreateUser();
        createUser.setUserName("jose");
        createUser.setUserEmail("jose.base2.com");

        waitTime();
//        Assert.assertTrue(createUser.isHomeScreenVisible());
    }

    @Test()
    public void createUserWithInvalid() {

        createUser = new CreateUser(Driver.getDriverInstance(), Driver.getWaitInstance());
        loginPage = new LoginPage(Driver.getDriverInstance(), Driver.getWaitInstance());

        loginPage.clickCreateUser();
        createUser.setUserName("jose");
        createUser.setUserEmail("jose.base2.com");
    }

}
