package tests.ManagerTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login.LoginPage;
import pages.Manager.ManagerUserPage;
import tests.Base.BaseTest;
import utils.PropertyManager;

public class ManagerUserTest extends BaseTest {

    private ManagerUserPage managerUserPage;
    private String userName1 = "llucas";
    private String userName2 = "jjose";
    private String userName = "JOSE";
    private String userRealName1 = "Lucas";

    @Test
    public void createNewUser() {
        setupManagerUser();

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

        deleteUsers();
    }

    @Test
    public void createNewUser_wrongEmail() {
        setupManagerUser();

        managerUserPage.clickNewUser();
        managerUserPage.setUserName(userName2);
        managerUserPage.setRealName(userRealName1);
        managerUserPage.setUserEmail(userName2+".com");
        managerUserPage.setAccessLevel("gerente");
        managerUserPage.setAble();
        managerUserPage.setProtected();

        managerUserPage.clickCreateUser();
        Assert.assertTrue(managerUserPage.isEmailWrong());

        deleteUsers();
    }

    @Test
    public void createNewUser_userNameExists() {
        setup_createUser();

        managerUserPage.clickNewUser();
        managerUserPage.setUserName(userName1);
        managerUserPage.setRealName(userRealName1);
        managerUserPage.setUserEmail(userName1+"@gmail.com");
        managerUserPage.setAccessLevel("gerente");
        managerUserPage.setAble();
        managerUserPage.setProtected();

        managerUserPage.clickCreateUser();
        Assert.assertTrue(managerUserPage.isNameProjectUsing());

        deleteUsers();
    }

    @Test
    public void editNewUser() {
        setup_createUser();

        managerUserPage.clickInUser(userName1);
        managerUserPage.editUsername(userName);

        managerUserPage.clickCreateUser();
        managerUserPage.gotoManagerUser();
        Assert.assertTrue(managerUserPage.isUserShowing(userName));

        deleteUsers();
    }

    @Test
    public void deleteNewUser() {
        setup_createUser();

        managerUserPage.clickInUser(userName1);
        managerUserPage.clickDeleteUser();
        managerUserPage.clickConfirmDeleteUser();
        Assert.assertFalse(managerUserPage.isUserShowing(userName1));

        deleteUsers();
    }

    private void setupManagerUser(){
        managerUserPage = new ManagerUserPage();
        LoginPage login = new LoginPage();

        login.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getPassword());

        managerUserPage.gotoManagerUser();
        deleteUsers();
    }

    private void setup_createUser(){
        setupManagerUser();

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

    private void deleteUsers(){


        if (managerUserPage.isUserShowing(userName1)){
            managerUserPage.clickInUser(userName1);
            managerUserPage.clickDeleteUser();
            managerUserPage.clickConfirmDeleteUser();
            Assert.assertFalse(managerUserPage.isUserShowing(userName1));
        }

        if (managerUserPage.isUserShowing(userName2)){
            managerUserPage.clickInUser(userName1);
            managerUserPage.clickDeleteUser();
            managerUserPage.clickConfirmDeleteUser();
            Assert.assertFalse(managerUserPage.isUserShowing(userName1));
        }

        if (managerUserPage.isUserShowing(userName)){
            managerUserPage.clickInUser(userName);
            managerUserPage.clickDeleteUser();
            managerUserPage.clickConfirmDeleteUser();
            Assert.assertFalse(managerUserPage.isUserShowing(userName1));
        }
    }

}
