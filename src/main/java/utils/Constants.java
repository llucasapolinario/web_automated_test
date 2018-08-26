package utils;

import java.io.File;

public abstract class Constants {

    public static final Object LOCK = new Object();
    // FOLDER
    static final String USER_DIR = "user.dir";
    static final String SCREENSHOT_FOLDER = System.getProperty(USER_DIR) + File.separator +
            "ScreenShots" + File.separator;

    // REPORT
    public static String REPORT_FILE_NAME = "Report.html";
    public static String WINDOWS_PATH = System.getProperty(USER_DIR) + File.separator + "TestReport";
    public static String WIN_REPORT_FILE_LOC = WINDOWS_PATH + File.separator + REPORT_FILE_NAME;

}
