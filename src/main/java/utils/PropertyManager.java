package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static utils.Constants.LOCK;
import static utils.Constants.USER_DIR;

public class PropertyManager {

    private static PropertyManager instance;

    private static String propertyFilePath = System.getProperty(USER_DIR)
            + File.separator
            + "environment.properties";

    private static String url;
    private static String hubLink;
    private static String username;
    private static String password;

    private static int TIME_OUT;

    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (LOCK) {
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
        hubLink =prop.getProperty("hubLink");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        TIME_OUT = Integer.parseInt(prop.getProperty("timeout"));
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

    public String getHubLink(){
        return hubLink;
    }

    public int getTimeOut() {
        return TIME_OUT;
    }

}
