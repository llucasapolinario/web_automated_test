package utils.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

import static utils.Constants.*;

public class ExtentManager {

    private static ExtentReports extent = null;

    public static ExtentReports getInstance() {
        if (extent == null) {
            synchronized (LOCK) {
                extent = createInstance();
            }
        }
        return extent;
    }

    //Create an extent report instance
    private static ExtentReports createInstance() {

        createReportPath(WINDOWS_PATH);
        String fileName = WIN_REPORT_FILE_LOC;
        System.out.println("file report = " + fileName);

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        ExtentReports extentLocal = new ExtentReports();
        extentLocal.attachReporter(htmlReporter);

        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("TextReport");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Test Report");

        return extentLocal;
    }


    private static void createReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!");
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }

}