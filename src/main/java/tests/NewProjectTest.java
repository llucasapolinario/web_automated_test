package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Driver;

public class NewProjectTest extends BaseTest{

    HomePage homePage;
    LoginTest login;

    @Test
    public void test1(){
        homePage = new HomePage(Driver.getDriverInstance(), Driver.getWaitInstance());
        login = new LoginTest();

        login.validLoginTes();
        homePage.clickRegistroDeMudanca();
        Assert.assertTrue(homePage.isNoneRegistro());
        homePage.clickRoadMap();
    }
}
