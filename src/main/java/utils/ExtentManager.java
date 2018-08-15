package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Platform;

import java.io.File;

import static utils.Constants.*;
import static utils.Utils.getCurrentPlatform;

public class ExtentManager {
    private static ExtentReports extent;


    public static ExtentReports getInstance() {
        if (extent == null) {
            synchronized (LOCK) {
                createInstance();
            }
        }
        return extent;
    }

    //Create an extent report instance
    private static ExtentReports createInstance() {

        Platform platform = getCurrentPlatform();
        String fileName = getReportFileLocation(platform);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }

    private static String getReportFileLocation(Platform platform) {
        String reportFileLocation = null;
        switch (platform) {
            case MAC:
                reportFileLocation = MAC_REPORT_FILE_LOC;
                createReportPath(MAC_PATH);
                System.out.println("ExtentReport Path for MAC: " + MAC_PATH + "\n");
                break;
            case WINDOWS:
                reportFileLocation = WIN_REPORT_FILE_LOC;
                createReportPath(WINDOWS_PATH);
                System.out.println("ExtentReport Path for WINDOWS: " + WINDOWS_PATH + "\n");
                break;
            default:
                System.out.println("ExtentReport path has not been set! There is a problem!\n");
                break;
        }
        return reportFileLocation;
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