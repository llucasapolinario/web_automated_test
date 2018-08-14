package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class Driver {


    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final int TIME_OUT = 1500;

    private static final Object lock = new Object();

    public static WebDriver getDriverInstance() {
        if (driver == null) {
        synchronized (lock) {
            driver = new ChromeDriver();
        }
    }
        return driver;
}

    public static WebDriverWait getWaitInstance(){
        if (wait == null) {
            synchronized (lock) {
                wait = new WebDriverWait(Driver.getDriverInstance(), TIME_OUT);
            }
        }
        return wait;
    }
}
