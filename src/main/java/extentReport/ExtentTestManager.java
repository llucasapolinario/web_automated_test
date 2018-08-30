package extentReport;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    static Map extentTestMap = new HashMap();

//    public static synchronized ExtentTest getTest() {
//        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
//    }

    public static synchronized void endTestCenario() {
//        ExtentManager.getInstance().endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = ExtentManager.getInstance().createTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}