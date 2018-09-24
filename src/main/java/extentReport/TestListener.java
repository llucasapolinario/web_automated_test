package extentReport;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.Base.BaseTest;
import utils.Driver;
import utils.Utils;

import java.io.IOException;


public class TestListener extends BaseTest implements ITestListener {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private final String getCurrentlyLoggedInUser = System.getProperty("user.name");

    public static ExtentTest getTestCenario(){
        return test.get();
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }


     @Override
    public synchronized void onStart(ITestContext iTestContext) {
        iTestContext.setAttribute("WebDriver", Driver.getDriverInstance());
    }

    @Override
    public synchronized void onFinish(ITestContext iTestContext) {
        ExtentManager.getInstance().flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult iTestResult) {
        test.set(
                ExtentManager.getInstance().createTest(
                        iTestResult.getMethod().getMethodName(),
                        iTestResult.getMethod().getDescription())
        );

        test.get().assignAuthor(getCurrentlyLoggedInUser);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult iTestResult) {
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        test.get().fail(iTestResult.getThrowable());

        try {
            test.get().addScreenCaptureFromPath(Utils.screenShotPage(Driver.getDriverInstance(), iTestResult.getName()).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        test.get().skip(iTestResult.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}