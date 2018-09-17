package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import tests.BaseTest;
import utils.Constants;

import java.io.File;

import static utils.Constants.*;
import static utils.Utils.createPath;

public class ExtentManager extends BaseTest {

    private static ExtentReports extent = null;
    private static String fileName = REPORT_FILE_LOC;

    static ExtentReports getInstance() {
        if (extent == null) {
            synchronized (LOCK) {
                extent = createInstance();
            }
        }
        return extent;
    }

    private static ExtentReports createInstance() {
        System.out.println("file report = " + fileName);
        createPath(PATH_REPORT);

        ExtentHtmlReporter htmlReporter = getHtmlReporter();
        ExtentReports extentLocal = new ExtentReports();
        extentLocal.attachReporter(htmlReporter);

        return extentLocal;
    }

    private static ExtentHtmlReporter getHtmlReporter() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File(fileName));

        htmlReporter.loadXMLConfig(Constants.ExtentConfigPath);
        htmlReporter.setAppendExisting(false);

        return htmlReporter;
    }

}