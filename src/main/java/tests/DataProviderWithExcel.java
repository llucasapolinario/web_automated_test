package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.Manager.ManagerGlobalCategoriesPage;
import pages.Manager.ManagerProjectPage;
import pages.Task.CreateTaskPage;
import tests.Base.BaseTest;
import tests.Login.LoginTest;
import utils.ExcelDataDriven;


public class DataProviderWithExcel extends BaseTest {

    private CreateTaskPage createTaskPage;
    private static final String bugList = "bugList";

    @DataProvider
    public Object[][] Authentication() throws Exception {
        ExcelDataDriven.setExcelFileSheet(bugList, "Planilha1");
        return ExcelDataDriven.getTableArray();
    }


    @Test(dataProvider = "Authentication")
    public void createNewTask(String Category, String Frequency, String Severity, String Priority, String Summary, String Description) {
        validate_CreateTaskPageByLink();
        createProject();
        createNewGlobalCategory();
        createTaskPage.clickCreateTask();
        createTaskPage.selectCategory(Category);
        createTaskPage.selectFrequency(Frequency);
        createTaskPage.selectSeverity(Severity);
        createTaskPage.selectPriority(Priority);
        createTaskPage.setSummary(Summary);
        createTaskPage.setDescription(Description);
        createTaskPage.clickInNewTask();
        Assert.assertTrue(createTaskPage.isTaskCreated());
    }

    public void validate_CreateTaskPageByLink() {
        new LoginTest().validLoginTest();
        createTaskPage = new CreateTaskPage();
        createTaskPage.clickInLinkCreateTask();
        Assert.assertTrue(createTaskPage.isCreateTaskPage());
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