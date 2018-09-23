package tests.ManagerTest;

import org.testng.Assert;
import pages.Manager.ManagerUserPage;
import tests.BaseTest;
import tests.LoginTest;

public class ManagerUserTest extends BaseTest {

    private ManagerUserPage managerUserPage;
    private LoginTest login;
    private String userName1 = "llucas";
    private String userRealName1 = "Lucas";
    private String projectName = "Automação parte";

//    @Test
    public void createNewUser() {
        managerUserPage = new ManagerUserPage();
        login = new LoginTest();

        login.validLoginTest();
        managerUserPage.gotoManagerUser();
        managerUserPage.clickNewUser();
        managerUserPage.setUserName(userName1);
        managerUserPage.setRealName(userRealName1);
        managerUserPage.setUserEmail(userName1+"@gmail.com");
        managerUserPage.setAccessLevel("gerente");
        managerUserPage.setAble();
        managerUserPage.setProtected();

        managerUserPage.clickCreateUser();
        managerUserPage.gotoManagerUserPage();
        Assert.assertTrue(managerUserPage.isUserShowing(userName1));
    }

//    @Test
    public void createNewUser_wrongEmail() {
        managerUserPage = new ManagerUserPage();
        login = new LoginTest();

        login.validLoginTest();
        managerUserPage.gotoManagerUser();
        managerUserPage.clickNewUser();
        managerUserPage.setUserName("JOSE");
        managerUserPage.setRealName(userRealName1);
        managerUserPage.setUserEmail(userName1+"@gmail.com");
        managerUserPage.setAccessLevel("gerente");
        managerUserPage.setAble();
        managerUserPage.setProtected();

        managerUserPage.clickCreateUser();
        Assert.assertTrue(managerUserPage.isEmailWrong());
    }

//    @Test
    public void createNewUser_userNameExists() {
        managerUserPage = new ManagerUserPage();
        login = new LoginTest();

        createNewUser();

        login.validLoginTest();
        managerUserPage.gotoManagerUser();
        managerUserPage.clickNewUser();
        managerUserPage.setUserName(userName1);
        managerUserPage.setRealName(userRealName1);
        managerUserPage.setUserEmail("JOSE.com");
        managerUserPage.setAccessLevel("gerente");
        managerUserPage.setAble();
        managerUserPage.setProtected();

        managerUserPage.clickCreateUser();
        Assert.assertTrue(managerUserPage.isEmailWrong());
    }

//    @Test
    public void editNewUser() {
        managerUserPage = new ManagerUserPage();
        login = new LoginTest();

        login.validLoginTest();
        managerUserPage.gotoManagerUser();
        managerUserPage.clickNewUser();
        managerUserPage.setUserName("JOSE");
        managerUserPage.setRealName(userRealName1);
        managerUserPage.setUserEmail("JOSE.com");
        managerUserPage.setAccessLevel("gerente");
        managerUserPage.setAble();
        managerUserPage.setProtected();

        managerUserPage.clickCreateUser();
        Assert.assertTrue(managerUserPage.isEmailWrong());
    }

//    @Test
    public void deleteNewUser() {
        managerUserPage = new ManagerUserPage();
        login = new LoginTest();

        login.validLoginTest();
        managerUserPage.gotoManagerUser();

        if (managerUserPage.isUserShowing(userName1)){

        }
    }
}
