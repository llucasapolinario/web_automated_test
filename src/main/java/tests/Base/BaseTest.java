package tests.Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.Base.BaseElement;
import utils.Driver;
import utils.PropertyManager;

@Listeners(extentReport.TestListener.class)

public class BaseTest {

    @BeforeMethod
    public void setup() {
        Driver.newInstance();
        new BaseElement().goToPage(PropertyManager.getInstance().getURL());
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriverInstance().close();
    }

}
