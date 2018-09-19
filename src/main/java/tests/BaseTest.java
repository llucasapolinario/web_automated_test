package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.BasePage;
import utils.Driver;
import utils.PropertyManager;

@Listeners(extentReport.TestListener.class)

public class BaseTest {

    @BeforeMethod(description = "Class Level Setup!")
    public void setup() {
        System.out.println("Setup!");
        Driver.newInstance();
        Driver.getDriverInstance().manage().window().maximize();

        new BasePage().goToPage(PropertyManager.getInstance().getURL());
    }

    @AfterMethod(description = "Class Level Teardown!")
    public void tearDown() {
        Driver.getDriverInstance().close();
        Driver.getDriverInstance().quit();
    }

}
