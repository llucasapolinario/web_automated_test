package utils;

import java.io.File;

public abstract class Constants {

    public static final Object LOCK = new Object();
    // FOLDER
    static final String USER_DIR = "user.dir";
    static final String SCREENSHOT_FOLDER = System.getProperty(USER_DIR) + File.separator +
            "ScreenShots" + File.separator;

    // REPORT
    static String REPORT_FILE_NAME = "ExtentReports-Version3-Test-Automaton-Report.html";
    static String WINDOWS_PATH = System.getProperty(USER_DIR) + "\\TestReport";
    static String WIN_REPORT_FILE_LOC = WINDOWS_PATH + "\\" + REPORT_FILE_NAME;

    static String MAC_PATH = System.getProperty(USER_DIR) + "/TestReport";
    static String MAC_REPORT_FILE_LOC = MAC_PATH + "/" + REPORT_FILE_NAME;

    // PAGINA INICIAL
    public String MANTS =  "/span[@innertext=' MantisBT ']";
    public static String MANTS_BD =  "/div[@id='navbar-container']//a[@href='/my_view_page.php']/span[@class='smaller-75']";

    // jonsmart spredshitdata
    // org.apache.poi.ss.
    //

}
