package extentReport;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;
import utils.Driver;


public class TestListener extends BaseTest implements ITestListener {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public synchronized void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", Driver.getDriverInstance());
    }

    @Override
    public synchronized void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
//        ExtentTestManager.endTestCenario();
        ExtentManager.getInstance().flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");

        test.set(
                ExtentManager.getInstance().createTest(
                        iTestResult.getMethod().getMethodName(),iTestResult.getMethod().getDescription())
        );
    }

    @Override
    public synchronized void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
//        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        test.get().fail(iTestResult.getThrowable());
//        //Get driver from BaseTest and assign to local webdriver variable.
//        Object testClass = iTestResult.getInstance();
//        WebDriver webDriver = ((BaseTest) testClass).getDriver();
//
//        //Take base64Screenshot screenshot.
//        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).
//                getScreenshotAs(OutputType.BASE64);
//
//        //Extentreports log and screenshot operations for failed tests.
//        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed",
//                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

    @Override
    public synchronized void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
//        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        test.get().skip(iTestResult.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}