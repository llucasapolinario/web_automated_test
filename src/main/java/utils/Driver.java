package utils;

import org.openqa.selenium.WebDriver;


import static utils.Constants.LOCK;

public class Driver {

    private static WebDriver driver;

    private static WebDriver newInstance() {
        System.out.println("newInstance");
        synchronized (LOCK) {

            driver = DriverFactory.setDriver(PropertyManager.getInstance().getBrowserExecution());
        }

        return driver;
    }


    public static WebDriver getDriverInstance() {
        if (driver == null) {
            driver = newInstance();
        }

        return driver;
    }

    public static void setDriverNull() {
        driver = null;
    }

}
