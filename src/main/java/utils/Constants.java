package utils;

import java.io.File;

public abstract class Constants {

    public static final Object LOCK = new Object();

    static final String USER_DIR = "user.dir";
    static final String FS = File.separator;

    static final String SCREEN_SHOT_FOLDER = System.getProperty(USER_DIR) + FS + "ScreenShots" + FS;
    public static final String ExtentConfigPath = System.getProperty(USER_DIR) + FS + "extent-config.xml";
    public static String PATH_REPORT = System.getProperty(USER_DIR) + FS + "TestReport" + FS;

    private static String REPORT_FILE_NAME = "Report";
    public static String REPORT_FILE_LOC = PATH_REPORT + REPORT_FILE_NAME;
    public static String operapath
//            = "C:"+ FS +"Users"+ FS +"apoli"+ FS +"AppData"+ FS +"Local"+ FS +"Programs"+ FS +"Opera"+ FS +"launcher.exe";
            = "C:\\Users\\apoli\\Documents\\Opera\\launcher.exe";


}
