package tests.Task;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Task.ViewTask;
import tests.Base.BaseTest;
import tests.Login.LoginTest;

public class TaskTest extends BaseTest {


    private ViewTask viewTask;
    private static final String[] ACTION = {"Mover", "Copiar", "Atribuir", "Fechar", "Apagar", "Resolver"};

    @Test
    public void selectTask() {
        validatePageViewTask();

        viewTask.selectBug(1);
        viewTask.selectBug(2);
        viewTask.selectBug(3);
        Assert.assertTrue(viewTask.isCheckBoxSelected(1));
        Assert.assertTrue(viewTask.isCheckBoxSelected(2));
        Assert.assertTrue(viewTask.isCheckBoxSelected(3));
    }

    @Test
    public void delete_oneTask() {
        validatePageViewTask();

        viewTask.selectBug(1);
        viewTask.action(ACTION[4]);
        viewTask.clickOn();
        String bugNum = viewTask.getBugLink();
        viewTask.clickConfirmDeleteTask();


        Assert.assertFalse(viewTask.isTaskShowing(bugNum));

    }

    @Test
    public void validatePageViewTask() {
        new LoginTest().validLoginTest();
        viewTask = new ViewTask();
        viewTask.gotoViewTaskPage();
        Assert.assertTrue(viewTask.isInViewTakPage());
    }

}
