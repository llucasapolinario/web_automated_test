package tests.ManagerTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Manager.ManagerProjectPage;
import tests.BaseTest;
import utils.PropertyManager;


public class ManagerProjectTest extends BaseTest {

    private ManagerProjectPage managerProjectPage;
    private String projectName1 = "Automação parte1";
    private String projectName2 = "Automação parte2";
    private String projectName = "Automação parte0";

    @Test(priority = 1)
    public void createNewProject_privateProject() {
        setupManagerProjects();

        managerProjectPage.clickNewProject();
        managerProjectPage.setProjectName(projectName1);
        managerProjectPage.setStateRelease();
        managerProjectPage.setExtendsGlobalCategory();
        managerProjectPage.doNotSetExtendsGlobalCategory();
        managerProjectPage.setProjectPrivate();
        managerProjectPage.setProjectDescription("testind description");

        managerProjectPage.clickAddProject();
        Assert.assertTrue(managerProjectPage.isNewProjectShowing(projectName1));

        deleteProjects();
    }

    @Test(priority = 2)
    public void createNewProject_publicProject() {
        setupManagerProjects();

        managerProjectPage.clickNewProject();
        managerProjectPage.setProjectName(projectName2);
        managerProjectPage.setStateRelease();
        managerProjectPage.setExtendsGlobalCategory();
        managerProjectPage.doNotSetExtendsGlobalCategory();
        managerProjectPage.setProjectPublic();
        managerProjectPage.setProjectDescription("testind description");

        managerProjectPage.clickAddProject();
        Assert.assertTrue(managerProjectPage.isNewProjectShowing(projectName2));

        deleteProjects();
    }

    @Test(priority = 3)
    public void createNewProject_withProjectNameUsing() {
        setup_createProject();

        managerProjectPage.clickNewProject();
        managerProjectPage.setProjectName(projectName1);
        managerProjectPage.setStateRelease();
        managerProjectPage.setExtendsGlobalCategory();
        managerProjectPage.doNotSetExtendsGlobalCategory();
        managerProjectPage.setProjectPrivate();
        managerProjectPage.setProjectDescription("testind description");

        managerProjectPage.clickAddProject();
        Assert.assertTrue(managerProjectPage.isNameProjectUsing());

        deleteProjects();
    }

    @Test(priority = 4)
    public void editProject() {
        setup_createProject();
        managerProjectPage.clickInProject(projectName1);

        managerProjectPage.setProjectName(projectName);
        managerProjectPage.clickUpdateProject();

        Assert.assertTrue(managerProjectPage.isNewProjectShowing(projectName));
    }

    @Test(priority = 5)
    public void deleteProject() {
        setup_createProject();
        managerProjectPage.clickInProject(projectName1);

        managerProjectPage.clickDeleteProject();
        managerProjectPage.clickConfirmDeleteProject();
        Assert.assertFalse(managerProjectPage.isNewProjectShowing(projectName1));

        deleteProjects();
    }

    private void setup_createProject() {

        setupManagerProjects();

        managerProjectPage.clickNewProject();
        managerProjectPage.setProjectName(projectName1);
        managerProjectPage.setStateRelease();
        managerProjectPage.setExtendsGlobalCategory();
        managerProjectPage.doNotSetExtendsGlobalCategory();
        managerProjectPage.setProjectPrivate();
        managerProjectPage.setProjectDescription("testind description");

        managerProjectPage.clickAddProject();
        Assert.assertTrue(managerProjectPage.isNewProjectShowing(projectName1));
    }

    private void setupManagerProjects() {
        managerProjectPage = new ManagerProjectPage();

        LoginPage login = new LoginPage();
        login.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getPassword());

        managerProjectPage.gotoManagerProjects();
        deleteProjects();
    }

    private void deleteProjects() {

        if (managerProjectPage.isNewProjectShowing(projectName)) {
            managerProjectPage.clickInProject(projectName);
            managerProjectPage.clickDeleteProject();
            managerProjectPage.clickConfirmDeleteProject();
            Assert.assertFalse(managerProjectPage.isNewProjectShowing(projectName));
        }

        if (managerProjectPage.isNewProjectShowing(projectName1)) {
            managerProjectPage.clickInProject(projectName1);
            managerProjectPage.clickDeleteProject();
            managerProjectPage.clickConfirmDeleteProject();
            Assert.assertFalse(managerProjectPage.isNewProjectShowing(projectName1));
        }

        if (managerProjectPage.isNewProjectShowing(projectName2)) {
            managerProjectPage.clickInProject(projectName2);
            managerProjectPage.clickDeleteProject();
            managerProjectPage.clickConfirmDeleteProject();
            Assert.assertFalse(managerProjectPage.isNewProjectShowing(projectName2));
        }

    }

    @Test(enabled = false)
    public void createNewProject_withoutProjectName() {
        setup_createProject();

        managerProjectPage.clickNewProject();
        managerProjectPage.setStateRelease();
        managerProjectPage.doNotSetExtendsGlobalCategory();
        managerProjectPage.setProjectPrivate();
        managerProjectPage.setProjectDescription("testind description");

        managerProjectPage.clickAddProject();

        //FIXME
        Assert.assertTrue(managerProjectPage.isNameProjectEmpty());
    }

}
