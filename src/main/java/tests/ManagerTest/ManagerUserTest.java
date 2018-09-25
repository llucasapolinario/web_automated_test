package tests.ManagerTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Manager.ManagerUserPage;
import tests.Base.BaseTest;
import tests.Login.LoginTest;

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
        managerUserPage.clickManagerUserPage();
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
        validateEditUserPage();

        managerUserPage.editUsername(userName);

        managerUserPage.clickCreateUser();
        managerUserPage.clickManagerUserPage();
        Assert.assertTrue(managerUserPage.isUserShowing(userName));

        deleteUsers();
    }

    @Test
    public void deleteNewUser() {
        validateEditUserPage();

        managerUserPage.clickDeleteUser();
        managerUserPage.clickConfirmDeleteUser();
        Assert.assertFalse(managerUserPage.isUserShowing(userName1));

        deleteUsers();
    }

    @Test
    public void validateManagerUserPage(){
        validateManagerPage();

        managerUserPage.clickManagerUserPage();

        Assert.assertTrue(managerUserPage.isManagerUserPage());
    }

    @Test
    public void validateCreateUserPage(){
        validateManagerUserPage();

        managerUserPage.clickNewUser();

        Assert.assertTrue(managerUserPage.isCreateUserPage());
    }

    @Test
    public void validateLinkCreateUser(){
        new LoginTest().validLoginTest();
        managerUserPage = new ManagerUserPage();
        managerUserPage.clickInLinkCreateUser();

        Assert.assertTrue(managerUserPage.isCreateUserPage());
    }

    @Test
    public void validateEditUserPage(){
        setup_createUser();

        managerUserPage.clickInUser(userName1);

        Assert.assertTrue(managerUserPage.isEditUserPage());
    }

    @Test
    public void validateManagerPage(){
        new LoginTest().validLoginTest();
        managerUserPage = new ManagerUserPage();
        managerUserPage.clickManager();

        Assert.assertTrue(managerUserPage.isManagerPage());
    }

    private void setupManagerUser(){
        validateManagerUserPage();
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
        managerUserPage.clickManagerUserPage();
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
