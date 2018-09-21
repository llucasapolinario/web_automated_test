package tests.ManagerTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Manager.ManagerProjectPage;
import tests.BaseTest;
import tests.LoginTest;


public class NewProjectTest extends BaseTest {

    private ManagerProjectPage managerProjectPage;
    private LoginTest login;
    private String projectName1 = "Automação parte1";

    @Test
    public void createNewProject_privateProject() {
        managerProjectPage = new ManagerProjectPage();
        login = new LoginTest();

        login.validLoginTest();
        managerProjectPage.gotoManagerProjects();
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

    @Test
    public void createNewProject_publicProject() {
        managerProjectPage = new ManagerProjectPage();
        login = new LoginTest();

        login.validLoginTest();
        managerProjectPage.gotoManagerProjects();
        managerProjectPage.clickNewProject();
        String projectName2 = "Automação parte2";
        managerProjectPage.setProjectName(projectName2);
        managerProjectPage.setStateRelease();
        managerProjectPage.setExtendsGlobalCategory();
        managerProjectPage.doNotSetExtendsGlobalCategory();
        managerProjectPage.setProjectPublic();
        managerProjectPage.setProjectDescription("testind description");

        managerProjectPage.clickAddProject();
        Assert.assertTrue(managerProjectPage.isNewProjectShowing(projectName2));
    }

    @Test
    public void createNewProject_withProjectNameUsing() {
        managerProjectPage = new ManagerProjectPage();
        login = new LoginTest();

        login.validLoginTest();
        managerProjectPage.gotoManagerProjects();
        managerProjectPage.clickNewProject();
        managerProjectPage.setProjectName(projectName1);
        managerProjectPage.setStateRelease();
        managerProjectPage.setExtendsGlobalCategory();
        managerProjectPage.doNotSetExtendsGlobalCategory();
        managerProjectPage.setProjectPrivate();
        managerProjectPage.setProjectDescription("testind description");

        managerProjectPage.clickAddProject();
        Assert.assertTrue(managerProjectPage.isNameProjectUsing());
    }

    @Test
    public void createNewProject_withoutProjectName() {
        managerProjectPage = new ManagerProjectPage();
        login = new LoginTest();

        login.validLoginTest();
        managerProjectPage.gotoManagerProjects();
        managerProjectPage.clickNewProject();
        managerProjectPage.setStateRelease();
        managerProjectPage.doNotSetExtendsGlobalCategory();
        managerProjectPage.setProjectPrivate();
        managerProjectPage.setProjectDescription("testind description");

        managerProjectPage.clickAddProject();

        //FIXME
        Assert.assertTrue(managerProjectPage.isNameProjectEmpty());
    }

    @Test
    public void editProject() {
        managerProjectPage = new ManagerProjectPage();
        login = new LoginTest();

        login.validLoginTest();
        managerProjectPage.gotoManagerProjects();
        managerProjectPage.clickEditProject(projectName1);

        managerProjectPage.setStateRelease();
        managerProjectPage.doNotSetExtendsGlobalCategory();
        managerProjectPage.setProjectPrivate();
        managerProjectPage.setProjectDescription("project edit");

        managerProjectPage.clickUpdateProject();

        //todo validar os campos do projeto e validar a auteração na tabela de porjetos
        Assert.assertTrue(managerProjectPage.isNewProjectShowing(projectName1));
    }

    @Test
    public void deleteProject() {
        managerProjectPage = new ManagerProjectPage();
        login = new LoginTest();

        login.validLoginTest();
        managerProjectPage.gotoManagerProjects();
        managerProjectPage.clickEditProject(projectName1);

        managerProjectPage.setStateRelease();
        managerProjectPage.doNotSetExtendsGlobalCategory();
        managerProjectPage.setProjectPrivate();
        managerProjectPage.setProjectDescription("project edit");

        managerProjectPage.clickDeleteProject();
        managerProjectPage.clickConfirmDeleteProject();

        //todo validar os campos do projeto e validar a auteração na tabela de porjetos
        Assert.assertFalse(managerProjectPage.isNewProjectShowing(projectName1));
    }

}
