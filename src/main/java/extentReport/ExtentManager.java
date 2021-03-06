package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import tests.Base.BaseTest;
import utils.Constants;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
        createPath(PATH_REPORT);

        ExtentReports extentLocal = new ExtentReports();
        extentLocal.attachReporter(getHtmlReporter());

        return extentLocal;
    }

    private static ExtentHtmlReporter getHtmlReporter() {
        SimpleDateFormat sdf = new SimpleDateFormat("_dd_MM_yyyy_HH.mm.ss", Locale.ENGLISH);
        fileName +=  sdf.format(System.currentTimeMillis()) + ".html";

        ExtentHtmlReporter htmlReporter =
                new ExtentHtmlReporter(new File(fileName));

        htmlReporter.loadXMLConfig(Constants.ExtentConfigPath);
        htmlReporter.setAppendExisting(false);

        return htmlReporter;
    }

}