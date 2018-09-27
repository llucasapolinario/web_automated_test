package tests.Task;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Manager.ManagerGlobalCategoriesPage;
import pages.Task.CreateTaskPage;
import pages.Manager.ManagerProjectPage;
import tests.Base.BaseTest;
import tests.Login.LoginTest;


public class CreateNewTaskTest extends BaseTest {

    private CreateTaskPage createTaskPage;
    private static final String category = "[Todos os Projetos] General";

    @Test()
    public void createNewTask() {
        setupCreateNewTask();
        createTaskPage.selectCategory(category);
        createTaskPage.selectFrequency(CreateTaskPage.FREQUENCY_LABEL[2]);
        createTaskPage.selectSeverity(CreateTaskPage.SEVERITY_LABEL[2]);
        createTaskPage.selectPriority(CreateTaskPage.PRIORITY_LABEL[2]);
        createTaskPage.setSummary("de login");
        createTaskPage.setDescription("erro ao entrar com o usuário x e as credenciais yyy");
        createTaskPage.clickInNewTask();

        Assert.assertTrue(createTaskPage.isTaskCreated());
    }

    @Test
    public void createNewTask_withoutCategory() {
        setupCreateNewTask();
        createTaskPage.selectFrequency(CreateTaskPage.FREQUENCY_LABEL[2]);
        createTaskPage.selectSeverity(CreateTaskPage.SEVERITY_LABEL[2]);
        createTaskPage.selectPriority(CreateTaskPage.PRIORITY_LABEL[2]);
        createTaskPage.setSummary("dlogin");
        createTaskPage.setDescription("erro ao entrar com o usuário x e as credenciais yyy");
        createTaskPage.clickInNewTask();

        Assert.assertTrue(createTaskPage.isCategoryNotSet());
    }

    @Test
    public void validate_CreateTaskPage() {
        new LoginTest().validLoginTest();
        createTaskPage = new CreateTaskPage();
        createTaskPage.clickCreateTask();

        Assert.assertTrue(createTaskPage.isCreateTaskPage());
    }

    @Test
    public void validate_CreateTaskPageByLink() {
        new LoginTest().validLoginTest();
        createTaskPage = new CreateTaskPage();
        createTaskPage.clickInLinkCreateTask();

        Assert.assertTrue(createTaskPage.isCreateTaskPage());
    }

    public void setupCreateNewTask() {
        validate_CreateTaskPageByLink();
        createProject();
        createNewGlobalCategory();
        createTaskPage.clickCreateTask();
    }

    public void createNewGlobalCategory() {
        String Category_bug = "Bug";

        ManagerGlobalCategoriesPage managerGlobalCategoriesPage = new ManagerGlobalCategoriesPage();
        managerGlobalCategoriesPage.setCategoryName(Category_bug);
        managerGlobalCategoriesPage.clickAddCategory();
    }

    public void createProject() {
        ManagerProjectPage managerProjectPage = new ManagerProjectPage();
        managerProjectPage.clickManager();
        managerProjectPage.clickManagerProjectsPage();
        String projectName1 = "Automação parte 1";
        if (!managerProjectPage.isNewProjectShowing(projectName1)) {
            managerProjectPage.clickNewProject();
            managerProjectPage.setProjectName(projectName1);
            managerProjectPage.setStateRelease();
            managerProjectPage.setExtendsGlobalCategory();
            managerProjectPage.setProjectPrivate();
            managerProjectPage.setProjectDescription("testind description");
            managerProjectPage.clickAddProject();
            Assert.assertTrue(managerProjectPage.isNewProjectShowing(projectName1));
        }
    }

}
