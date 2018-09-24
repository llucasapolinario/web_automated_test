package tests.CreateTask;

import org.testng.annotations.Test;
import pages.CreateTask.CreateTaskPage;
import tests.Base.BaseTest;
import tests.Login.LoginTest;

public class CreateNewTaskTest extends BaseTest {

    private CreateTaskPage createTaskPage;

    @Test(enabled = false)
    public void createNewTask_withoutCategory() {
        setupCreateNewTask();
//        createTaskPage.selectyCategory();
        createTaskPage.selectyFrequency(CreateTaskPage.FREQUENCY_LABEL[2]);
        createTaskPage.selectySeverity(CreateTaskPage.SEVERITY_LABEL[2]);
        createTaskPage.selectyPriority(CreateTaskPage.PRIORITY_LABEL[2]);
    }

    private void setupCreateNewTask() {
        createTaskPage = new CreateTaskPage();
        new LoginTest().validLoginTest();
        createTaskPage.clickCreateTask();
    }

}
