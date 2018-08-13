package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static utils.Constants.USER_DIR;

public class PropertyManager {

    private static final Object lock = new Object();
    private static PropertyManager instance;
    private static String propertyFilePath = System.getProperty(USER_DIR);
    private static String url;
    private static String wrongUsername;
    private static String wrongPassword;

    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    private void loadData() {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

        url = prop.getProperty("url");
        wrongUsername = prop.getProperty("wrongUsername");
        wrongPassword = prop.getProperty("wrongPassword");
    }

    public String getURL() {
        return url;
    }

    public String getWrongUsername() {
        return wrongUsername;
    }

    public String getWrongPassword() {
        return wrongPassword;
    }

}
