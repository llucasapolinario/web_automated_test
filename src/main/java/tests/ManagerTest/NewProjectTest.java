package tests.ManagerTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Manager.NewProjectPage;
import tests.BaseTest;
import tests.LoginTest;


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

        //TODO emprouve this search
        Assert.assertTrue(newProjectPage.isNewProjectShowing(projectName));
    }

    @Test
    public void createNewProject_publicProject() {
        newProjectPage = new NewProjectPage();
        login = new LoginTest();

        login.validLoginTest();
        newProjectPage.gotoManagerProjects();
        newProjectPage.clickNewProject();
        String projectName = "Automação parte2";
        newProjectPage.setProjectName(projectName);
        newProjectPage.setStateRelease();
        newProjectPage.setExtendsGlobalCategory();
        newProjectPage.doNotSetExtendsGlobalCategory();
        newProjectPage.setProjectPublic();
        newProjectPage.setProjectDescription("testind description");

        newProjectPage.clickAddProject();
        Assert.assertTrue(newProjectPage.isNewProjectShowing(projectName));
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
    }

    @Test
    public void createNewProject_withProjectNameUsing() {
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

        //TODO emprouve this search
        Assert.assertTrue(newProjectPage.isNameProjectUsing());
    }

}
