package tests.Task;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Task.CreateTaskPage;
import pages.Task.ViewTask;
import tests.Base.BaseTest;
import tests.Login.LoginTest;

public class TaskTest extends BaseTest {


    private ViewTask viewTask;
    private static final String[] ACTION = {"Mover", "Copiar", "Atribuir", "Fechar", "Apagar", "Resolver"};

    @Test
    public void selectOneTask() {
        setupTaskTest();

        viewTask.selectBug(1);
        Assert.assertTrue(viewTask.isCheckBoxSelected(1));
    }

    @Test //o2
    public void closeOneTask() {
        setupTaskTest();
        String bug = String.valueOf(viewTask.getNumBug(1));
        viewTask.selectBug(1);
        viewTask.action(ACTION[3]);
        viewTask.clickOnOK();

        viewTask.clickConfirmCloseTask();
        Assert.assertFalse(viewTask.isTaskShowing(bug));
    }

    @Test //o3
    public void doneOneTask() {
        setupTaskTest();

        viewTask.selectBug(1);
        viewTask.action(ACTION[5]);
        viewTask.clickOnOK();

        viewTask.clickConfirmDoneTask();
        Assert.assertTrue(viewTask.isBugDone(1));
    }

    @Test //o4
    public void deleteOneTask() {
        setupTaskTest();
        String bug = String.valueOf(viewTask.getNumBug(1));
        viewTask.selectBug(1);
        viewTask.action(ACTION[4]);
        viewTask.clickOnOK();
        viewTask.clickConfirmDeleteTask();
        Assert.assertFalse(viewTask.isTaskShowing(bug));
    }

    @Test //o5
    public void deleteAllTask() {
        setupTaskTest();
        viewTask.setSelectAllBugs();
        viewTask.action(ACTION[4]);
        viewTask.clickOnOK();
        viewTask.clickConfirmDeleteTask();
        Assert.assertTrue(viewTask.isEmptyBug());
    }

    @Test //06
    public void validatePageViewTask() {
        new LoginTest().validLoginTest();
        viewTask = new ViewTask();
        viewTask.clickTask();
        Assert.assertTrue(viewTask.isInViewTakPage());
    }

    private void setupTaskTest() {
        new CreateNewTaskTest().createNewTask();

        String category = "[Todos os Projetos] General";
        CreateTaskPage createTaskPage = new CreateTaskPage();

        createTaskPage.clickInLinkCreateTask();
        createTaskPage.selectCategory(category);
        createTaskPage.selectFrequency(CreateTaskPage.FREQUENCY_LABEL[2]);
        createTaskPage.selectSeverity(CreateTaskPage.SEVERITY_LABEL[2]);
        createTaskPage.selectPriority(CreateTaskPage.PRIORITY_LABEL[2]);
        createTaskPage.setSummary("dlogin");
        createTaskPage.setDescription("erro ao entrar com o usuário x e as credenciais yyy");
        createTaskPage.clickInNewTask();

        Assert.assertTrue(createTaskPage.isTaskCreated());

        viewTask = new ViewTask();
        viewTask.clickTask();

        Assert.assertTrue(viewTask.isInViewTakPage());
    }

}
