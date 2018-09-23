package tests;

import org.testng.annotations.*;
import pages.BaseElement;
import utils.Driver;
import utils.PropertyManager;

@Listeners(extentReport.TestListener.class)

public class BaseTest {

    @BeforeMethod
    public void setup() {
        Driver.newInstance().manage().window().maximize();
        new BaseElement().goToPage(PropertyManager.getInstance().getURL());
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriverInstance().close();
        Driver.getDriverInstance().quit();
    }

}
