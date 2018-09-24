package tests.ManagerTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Manager.ManagerProjectPage;
import tests.Base.BaseTest;
import tests.Login.LoginTest;


public class ManagerProjectTest extends BaseTest {

    private ManagerProjectPage managerProjectPage;
    private String projectName1 = "Automação parte 1";
    private String projectName2 = "Automação parte 2";
    private String projectName  = "Automação parte 0";

    @Test
    public void createNewProject_privateProject() {
        setupManagerProjects();

        managerProjectPage.clickNewProject();
        managerProjectPage.setProjectName(projectName1);
        managerProjectPage.setStateRelease();
        managerProjectPage.setExtendsGlobalCategory();
        managerProjectPage.setProjectPrivate();
        managerProjectPage.setProjectDescription("testind description");

        managerProjectPage.clickAddProject();
        Assert.assertTrue(managerProjectPage.isNewProjectShowing(projectName1));

        deleteProjects();
    }

    @Test
    public void createNewProject_publicProject() {
        setupManagerProjects();

        managerProjectPage.clickNewProject();
        managerProjectPage.setProjectName(projectName2);
        managerProjectPage.setStateRelease();
        managerProjectPage.setExtendsGlobalCategory();
        managerProjectPage.setProjectPublic();
        managerProjectPage.setProjectDescription("testind description");

        managerProjectPage.clickAddProject();
        Assert.assertTrue(managerProjectPage.isNewProjectShowing(projectName2));

        deleteProjects();
    }

    @Test
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

    @Test
    public void editProject() {
        setup_createProject();
        managerProjectPage.clickInProject(projectName1);

        managerProjectPage.setProjectName(projectName);
        managerProjectPage.clickUpdateProject();

        Assert.assertTrue(managerProjectPage.isNewProjectShowing(projectName));
    }

    @Test
    public void editProject_withProjectNameUsing() {
        setup_createProject();

        managerProjectPage.clickNewProject();
        managerProjectPage.setProjectName(projectName);
        managerProjectPage.setStateRelease();
        managerProjectPage.setExtendsGlobalCategory();
        managerProjectPage.setProjectPrivate();
        managerProjectPage.setProjectDescription("testind description");
        managerProjectPage.clickAddProject();

        managerProjectPage.clickInProject(projectName);
        managerProjectPage.setProjectName(projectName1);
        managerProjectPage.clickUpdateProject();

        Assert.assertTrue(managerProjectPage.isNameProjectUsing());
    }

    @Test
    public void deleteProject() {
        setup_createProject();
        managerProjectPage.clickInProject(projectName1);

        managerProjectPage.clickDeleteProject();
        managerProjectPage.clickConfirmDeleteProject();
        Assert.assertFalse(managerProjectPage.isNewProjectShowing(projectName1));

        deleteProjects();
    }

    @Test
    public void createNewProject_withoutProjectName() {
        setupManagerProjects();

        managerProjectPage.clickNewProject();
        managerProjectPage.setStateRelease();
        managerProjectPage.doNotSetExtendsGlobalCategory();
        managerProjectPage.setProjectPrivate();
        managerProjectPage.setProjectDescription("testind description");
        managerProjectPage.clickAddProject();

        Assert.assertTrue(managerProjectPage.isCreateProjectPage());
        deleteProjects();
    }

    @Test
    public void validateAccess_CreateProjectPage(){
        setupManagerProjects();
        managerProjectPage.clickNewProject();
        Assert.assertFalse(managerProjectPage.isCreateProjectPage());
    }

    @Test
    public void validateAccess_ManagerProjectPage(){
        setupManagerProjects();
        Assert.assertFalse(managerProjectPage.isManagerProjectPage());
    }

    private void setup_createProject() {

        setupManagerProjects();

        managerProjectPage.clickNewProject();
        managerProjectPage.setProjectName(projectName1);
        managerProjectPage.setStateRelease();
        managerProjectPage.setExtendsGlobalCategory();
        managerProjectPage.setProjectPrivate();
        managerProjectPage.setProjectDescription("testind description");

        managerProjectPage.clickAddProject();
        Assert.assertTrue(managerProjectPage.isNewProjectShowing(projectName1));
    }

    private void setupManagerProjects() {
        managerProjectPage = new ManagerProjectPage();

        new LoginTest().validLoginTest();
//
//        LoginPage login = new LoginPage();
//        login.login(PropertyManager.getInstance().getUsername(),
//                PropertyManager.getInstance().getPassword());

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

}
