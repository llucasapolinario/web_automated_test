package extentReport;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeMethod;


public class RegressionFunc extends ExtentManager {

    public ExtentReports extentInstance;
    public ExtentTest testInstance;
    private final String getCurrentlyLoggedInUser = System.getProperty("user.name");


    @BeforeClass
    public void createExtentInstance() {
        extentInstance = ExtentManager.getInstance();
    }

    public void initializeExtentReport() {
        String executingTestCaseName = super.getClass().getSimpleName();

        testInstance = extentInstance.createTest(
                executingTestCaseName, "'" + executingTestCaseName + "' is used to check details in Application.");
        testInstance.assignAuthor(getCurrentlyLoggedInUser);
        testInstance.assignCategory("RegressionTestCases_Test");
    }

    @BeforeMethod
    public void initReport(){
        initializeExtentReport();
    }

//    private void initializeTest() {
//        String executingTestCaseCenario = super.getClass().getMethod();
//    }


    @AfterClass
    public void tearDownFunction() {
        extentInstance.flush();
    }

}