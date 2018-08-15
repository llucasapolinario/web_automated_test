package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class NewProjectTest extends BaseTest{

    HomePage homePage;
    LoginTest login;

    @Test
    public void test1(){
        homePage = new HomePage();
        login = new LoginTest();

        login.validLoginTest();
        homePage.clickChangelogPage();
        Assert.assertTrue(homePage.isNoneChangelog());
        homePage.clickRoadMap();
    }
}
