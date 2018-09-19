package extentReport;

import com.aventstack.extentreports.Status;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import utils.PropertyManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Retry implements IRetryAnalyzer, IAnnotationTransformer {

    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        int maxRetryCount = PropertyManager.getMaxRetryCount();
        if (!result.isSuccess()) {
            if (retryCount < maxRetryCount) {
                retryCount++;
                TestListener.getTestCenario().log(Status.FAIL, "Retrying test "
                        + result.getName()
                        + " with status "
                        + getResultStatusName(result.getStatus())
                        + " for the "
                        + (retryCount + 1)
                        + " time(s).");
                return true;
            }
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

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(Retry.class);
    }

}
