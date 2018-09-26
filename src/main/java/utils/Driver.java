package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Constants.LOCK;

public class Driver {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver newInstance() {
        System.out.println("newInstance");
        synchronized (LOCK) {

//            driver = getDriver();
            wait = new WebDriverWait(Driver.getDriverInstance(),
                    PropertyManager.getInstance().getTimeOut());
        }
        return driver;
    }

//    private static WebDriver getDriver() {
//        if (PropertyManager.getInstance().getIsTextExecutionLocal()){
//            return new ChromeDriver("Drivers");
//        }
//        else {
//            String browser = PropertyManager.getInstance().getBrowserExecution();
//            String browser = PropertyManager.getInstance().getBrowserExecution();
//            switch (browser){
//                case ("firefox"):
//                    new RemoteWebDriver()
//            }
//        }
//    }

    public static WebDriver getDriverInstance() {
        if (driver == null) {
            driver = newInstance();
        }

        return driver;
    }

    public static WebDriverWait getWaitInstance() {
        if (wait == null) {
            synchronized (LOCK) {
                wait = new WebDriverWait(Driver.getDriverInstance(),
                        PropertyManager.getInstance().getTimeOut());
            }
        }

        return wait;
    }

}
