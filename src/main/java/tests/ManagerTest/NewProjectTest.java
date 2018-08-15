package tests.ManagerTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Manager.NewProjectPage;
import tests.BaseTest;
import tests.LoginTest;

public class NewProjectTest extends BaseTest {

    private NewProjectPage newProjectPage;
    private LoginTest login;

//    @BeforeMethod
//    public void setup(){
//
//    }
//
//    @AfterMethod
//    public void tearDown(){
//
//    }

    @Test
    public void createNewProject_privateProject() {
        newProjectPage = new NewProjectPage();
        login = new LoginTest();

        login.validLoginTest();
        newProjectPage.setProjectName("Automação parte1");
        newProjectPage.setStateRelease();
//        newProjectPage.setExtendsGlobalCategory();
        newProjectPage.doNotSetExtendsGlobalCategory();
        newProjectPage.setProjectPrivate();
        newProjectPage.setProjectDescription("testind description");

        newProjectPage.clickAddProject();
        Assert.assertFalse(newProjectPage.isNoneProjectName());
    }

    @Test
    public void createNewProject_publicProject() {
        newProjectPage = new NewProjectPage();
        login = new LoginTest();

        login.validLoginTest();
        newProjectPage.setProjectName("Automação parte1");
        newProjectPage.setStateRelease();
//        newProjectPage.setExtendsGlobalCategory();
        newProjectPage.doNotSetExtendsGlobalCategory();
        newProjectPage.setProjectPublic();
        newProjectPage.setProjectDescription("testind description");

        newProjectPage.clickAddProject();
        Assert.assertFalse(newProjectPage.isNoneProjectName());
    }

    @Test
    public void createNewProject_withoutProjectName() {
        newProjectPage = new NewProjectPage();
        login = new LoginTest();

        login.validLoginTest();
        newProjectPage.setStateRelease();
        newProjectPage.doNotSetExtendsGlobalCategory();
        newProjectPage.setProjectPrivate();
        newProjectPage.setProjectDescription("testind description");

        newProjectPage.clickAddProject();
        Assert.assertTrue(newProjectPage.isNoneProjectName());
    }

}
