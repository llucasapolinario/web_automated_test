package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static utils.Constants.LOCK;
import static utils.Constants.USER_DIR;

public class PropertyManager {

    private static PropertyManager instance;

    private static String propertyFilePath = System.getProperty(USER_DIR) + File.separator + "environment.properties";

    private static String url;
    private static String hubLink;
    private static String username;
    private static String password;
    private static String browserExecution;
    private static boolean isTextExecutionLocal;
    private static Integer maxRetryCount;

    private static String databaseServer;
    private static String databaseName;
    private static String dbUser;
    private static String dbPassword;

    private static int TIME_OUT;
    private static int TIME_OUT_BEFORE_ELEMENT;

    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (LOCK) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    public String getURL() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    String getBrowserExecution() {
        return browserExecution;
    }

    boolean getIsTextExecutionLocal() {
        return isTextExecutionLocal;
    }

    String getHubLink() {
        return hubLink;
    }

    int getTimeOut() {
        return TIME_OUT;
    }

    int getTimeOutBeforeElement() {
        return TIME_OUT_BEFORE_ELEMENT;
    }

    public static Integer getMaxRetryCount() {
        return maxRetryCount;
    }

    String getDatabaseServer() {
        return databaseServer;
    }

    String getDatabaseName() {
        return databaseName;
    }

    String getDbUser() {
        return dbUser;
    }

    String getDbPassword() {
        return dbPassword;
    }

    private void loadData() {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

        url = prop.getProperty("url");
        hubLink = prop.getProperty("hubLink");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        TIME_OUT = Integer.parseInt(prop.getProperty("timeout"));
        TIME_OUT_BEFORE_ELEMENT = Integer.parseInt(prop.getProperty("timeout_before_event"));
        maxRetryCount = Integer.parseInt(prop.getProperty("maxRetryCount"));
        browserExecution = prop.getProperty("browserExecution");
        isTextExecutionLocal = Boolean.parseBoolean(prop.getProperty("isTestExecutionLocal"));

        databaseServer = prop.getProperty("DatabaseServer");
        databaseName = prop.getProperty("DatabaseName");
        dbUser = prop.getProperty("DBUser");
        dbPassword = prop.getProperty("DBPassword");
    }

}
