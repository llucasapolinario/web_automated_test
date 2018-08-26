package extentReport;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Retry implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 1;

    public boolean retry(ITestResult result) {
        //Re-run the test case if it is less than maximum retry count
        if (retryCount < maxRetryCount) {
            retryCount++;
            Reporter.log("Retrying test "
                    + result.getName()
                    + " with status "
                    + getResultStatusName(result.getStatus())
                    + " for the "
                    + (retryCount + 1)
                    + " time(s).", true);
            return true;
        }
        return false;
    }

    private String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }

    //HOW TO USE THE Retry Analyzer class file
    @Test(retryAnalyzer = Retry.class)
    public void testGenX() {
        Assert.assertEquals("james", "JamesFail"); // ListenerTest fails
    }
}
