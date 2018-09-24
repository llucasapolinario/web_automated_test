package tests.CreateTask;

import org.testng.annotations.Test;
import pages.CreateTask.CreateTaskPage;
import pages.Login.LoginPage;
import tests.Base.BaseTest;
import utils.PropertyManager;

public class CreateNewTaskTest extends BaseTest {

    private CreateTaskPage createTaskPage;

    @Test
    public void createNewTask_withoutCategory() {
        setupCreateNewTask();
//        createTaskPage.selectyCategory();
        createTaskPage.selectyFrequency(CreateTaskPage.FREQUENCY_LABEL[2]);
        createTaskPage.selectySeverity(CreateTaskPage.SEVERITY_LABEL[2]);
        createTaskPage.selectyPriority(CreateTaskPage.PRIORITY_LABEL[2]);
    }

    private void setupCreateNewTask() {
        createTaskPage = new CreateTaskPage();

        LoginPage login = new LoginPage();
        login.login(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getPassword());

        createTaskPage.clickCreateTask();
    }

}
