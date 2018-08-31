package extentReport;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class RegressionFunc extends ExtentManager {

    private ExtentReports extentInstance;
    protected ExtentTest testInstance;
    public static ExtentTest senario;
    private final String getCurrentlyLoggedInUser = System.getProperty("user.name");
    private String testName;

    @BeforeClass
    public void createExtentInstance() {
        extentInstance = ExtentManager.getInstance();
//        initializeExtentReport();
    }

//    @BeforeMethod
//    public void beforeMethod(Method method) {
//        Test test = method.getAnnotation(Test.class);
//        testName = test.testName();
//        initTestCase();
//    }

    private void initializeExtentReport() {
        String executingTestCaseName = super.getClass().getSimpleName();

        testInstance = extentInstance.createTest(
                executingTestCaseName,
                "'" + executingTestCaseName + "' is used to check details in Application.");
        testInstance.assignAuthor(getCurrentlyLoggedInUser);
        testInstance.assignCategory("RegressionTestCases_Test");
    }

    private void initTestCase() {
        String executingTestCaseName = super.getClass().getSimpleName();

        testInstance = extentInstance.createTest(
                testName,
                "'" + executingTestCaseName + "' is used to check details in Application.");
        testInstance.assignAuthor(getCurrentlyLoggedInUser);
        testInstance.assignCategory(executingTestCaseName);
    }

//    @AfterClass
//    public void tearDownFunction() {
//        extentInstance.flush();
//    }

}