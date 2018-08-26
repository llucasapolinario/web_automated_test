package utils;

import java.io.File;

public abstract class Constants {

    public static final Object LOCK = new Object();

    // FOLDER
    static final String USER_DIR = "user.dir";
    private static final String FS = File.separator;

    static final String SCREEN_SHOT_FOLDER =
            System.getProperty(USER_DIR) + FS + "ScreenShots" + FS;
    public static final String ExtentConfigPath = System.getProperty(USER_DIR) + FS + "extent-config.xml";
    public static String PATH_REPORT = System.getProperty(USER_DIR) + FS + "TestReport" + FS;
    // REPORT
    private static String REPORT_FILE_NAME = "Report.html";
    public static String REPORT_FILE_LOC = PATH_REPORT + REPORT_FILE_NAME;

    //For Report start time and End time format
//    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);

}
