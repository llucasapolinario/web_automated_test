package tests.Task;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Manager.ManagerGlobalCategoriesPage;
import pages.Task.CreateTaskPage;
import pages.Manager.ManagerProjectPage;
import tests.Base.BaseTest;
import tests.Login.LoginTest;
import utils.ExcelDataDriven;


public class CreateNewTaskTest extends BaseTest {

    private CreateTaskPage createTaskPage;
    private static final String category = "[Todos os Projetos] General";

    @DataProvider
    public Object[] BugList() {
        String bugList = "bugList";
        ExcelDataDriven.setExcelFileSheet(bugList, "Planilha1");
        ExcelDataDriven.setRowNumber(4);
        return ExcelDataDriven.getTableRow();
    }

    @Test(dataProvider = "BugList")
    public void createNewTask_DDT(XSSFRow row) {
        validate_CreateTaskPageByLink();
        createProject();
        createNewGlobalCategory();
        createTaskPage.clickCreateTask();
        System.out.println("gg  "+ row.getCell(1));
        createTaskPage.selectCategory(row.getCell(1).toString());
        createTaskPage.selectFrequency(row.getCell(2).toString());
        createTaskPage.selectSeverity(row.getCell(3).toString());
        createTaskPage.selectPriority(row.getCell(4).toString());
        createTaskPage.setSummary(row.getCell(5).toString());
        createTaskPage.setDescription(row.getCell(6).toString());
        createTaskPage.clickInNewTask();
        Assert.assertTrue(createTaskPage.isTaskCreated());
    }

    @Test
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

    private void setupCreateNewTask() {
        validate_CreateTaskPageByLink();
        createProject();
        createNewGlobalCategory();
        createTaskPage.clickCreateTask();
    }

    private void createNewGlobalCategory() {
        String Category_bug = "Bug";

        ManagerGlobalCategoriesPage managerGlobalCategoriesPage = new ManagerGlobalCategoriesPage();
        managerGlobalCategoriesPage.setCategoryName(Category_bug);
        managerGlobalCategoriesPage.clickAddCategory();
    }

    private void createProject() {
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
