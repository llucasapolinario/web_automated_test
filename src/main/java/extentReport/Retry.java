package extentReport;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
import utils.PropertyManager;

public class Retry implements IRetryAnalyzer {

    public boolean retry(ITestResult result) {
        int retryCount = 0;
        int maxRetryCount = PropertyManager.getMaxRetryCount();

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

}
