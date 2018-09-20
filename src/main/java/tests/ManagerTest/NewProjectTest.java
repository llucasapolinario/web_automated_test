package tests.ManagerTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Manager.NewProjectPage;
import tests.BaseTest;
import tests.LoginTest;

import javax.swing.*;

public class NewProjectTest extends BaseTest {

    private NewProjectPage newProjectPage;
    private LoginTest login;


    @Test
    public void createNewProject_privateProject() {
        newProjectPage = new NewProjectPage();
        login = new LoginTest();

        login.validLoginTest();
        newProjectPage.gotoManagerProjects();
        newProjectPage.clickNewProject();
        String projectName = "Automação parte1";
        newProjectPage.setProjectName(projectName);
        newProjectPage.setStateRelease();
        newProjectPage.setExtendsGlobalCategory();
        newProjectPage.doNotSetExtendsGlobalCategory();
        newProjectPage.setProjectPrivate();
        newProjectPage.setProjectDescription("testind description");

        newProjectPage.clickAddProject();
        Assert.assertFalse(newProjectPage.isNoneProjectName());
        Assert.assertTrue(newProjectPage.isProjectCreate(projectName));
    }

    @Test
    public void createNewProject_publicProject() {
        newProjectPage = new NewProjectPage();
        login = new LoginTest();

        login.validLoginTest();
        String projectName = "Automação parte1";
        newProjectPage.setProjectName(projectName);
        newProjectPage.setStateRelease();
        newProjectPage.setExtendsGlobalCategory();
        newProjectPage.doNotSetExtendsGlobalCategory();
        newProjectPage.setProjectPublic();
        newProjectPage.setProjectDescription("testind description");

        newProjectPage.clickAddProject();
        Assert.assertFalse(newProjectPage.isNoneProjectName());
        Assert.assertTrue(newProjectPage.isProjectCreate(projectName));
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
        Assert.assertFalse(newProjectPage.isProjectCreate(""));
    }

}
